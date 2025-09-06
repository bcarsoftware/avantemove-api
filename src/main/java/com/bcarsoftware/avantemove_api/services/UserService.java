package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.utils.UserDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.TokenDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.AccessToken;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    private final BCryptPasswordEncoder bcrypt;
    private final JwtInsert jwtInsert;
    private final UserRepository userRepository;

    @Autowired
    public UserService(
        JwtInsert jwtInsert,
        UserRepository userRepository,
        BCryptPasswordEncoder bcrypt
    ) {
        this.jwtInsert = jwtInsert;
        this.userRepository = userRepository;
        this.bcrypt = bcrypt;
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = this.transferDtoToUser(userDTO);
        user.setPassword(this.encrypt(user.getPassword()));

        return this.userRepository.save(user);
    }

    @Override
    public User login(LoginDTO loginDTO) {
        User user = this.userRepository.findUserByUsernameOrEmail(
            loginDTO.username(),
            loginDTO.username()
        ).orElseThrow(() -> new DatabaseException("login failed user not found", 404));

        if (!this.isPasswordMatched(loginDTO.password(), user.getPassword()))
            throw new AuthException("login password don't match");

        if (!user.isActive()) {
            user.setActive(true);
            this.userRepository.save(user);
        }

        return user;
    }

    @Override
    public void logout(String token) {
        if (!this.jwtInsert.deleteTokenByToken(token))
            throw new AuthException("user logout failed");
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new DatabaseException("user not found", 404));
    }

    @Override
    @Transactional
    public User update(Long id, UserDTO userDTO) {
        UserDTOChecker.userDTOChecker(userDTO);

        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new DatabaseException("user not found", 404));

        this.transferDtoToUserUpdateContext(userDTO, user);

        boolean isSavePassword = UserDTOChecker.isSavingPassword(userDTO.password());

        user.setPassword(
            isSavePassword ?
            this.encrypt(userDTO.password()) :
            user.getPassword()
        );

        return this.userRepository.save(user);
    }

    @Override
    public User delete(Long id) {
        User user = this.userRepository.findById(id)
                        .orElseThrow(() -> new DatabaseException("user not found", 404));

        user.setActive(false);

        User deleted = this.userRepository.save(user);

        deleted.setPassword(null);

        return deleted;
    }

    @Override
    public User getUserByToken(TokenDTO tokenDTO) {
        AccessToken accessToken = jwtInsert.getAccessTokenByToken(tokenDTO.token());

        return userRepository.findUserByUsernameOrEmail(
            accessToken.getUsername(),
            accessToken.getUsername()
        ).orElseThrow(() -> new DatabaseException("user not found", 404));
    }

    protected String encrypt(String password) {
        return bcrypt.encode(password);
    }

    protected boolean isPasswordMatched(String password, String encryptedPassword) {
        return bcrypt.matches(password, encryptedPassword);
    }

    protected void transferDtoToUserUpdateContext(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.firstName());
        user.setLastName(userDTO.lastName());
        user.setBirthDate(userDTO.birthDate());
        user.setGender(userDTO.gender());

        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());

        String mobile = userDTO.mobile().isPresent() ? userDTO.mobile().get() : null;

        user.setMobile(mobile);
        user.setExperience(userDTO.experience());
    }

    protected User transferDtoToUser(UserDTO userDTO) {
        UserDTOChecker.checkSavePassword(userDTO.password());
        UserDTOChecker.userDTOChecker(userDTO);

        User user = new User();
        String mobile = userDTO.mobile().isPresent() ? userDTO.mobile().get() : null;

        user.setFirstName(userDTO.firstName());
        user.setLastName(userDTO.lastName());
        user.setBirthDate(userDTO.birthDate());
        user.setGender(userDTO.gender());
        user.setMobile(mobile);

        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setExperience(userDTO.experience());
        user.setActive(userDTO.active());

        return user;
    }
}
