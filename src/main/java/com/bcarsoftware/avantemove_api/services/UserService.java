package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.utils.UserDTOChecker;
import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import com.bcarsoftware.avantemove_api.exceptions.DatabaseException;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private JwtInsert jwtInsert;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDTO userDTO) {
        User user = this.transferDtoToUser(userDTO);
        user.setPassword(this.encrypt(user.getPassword()));

        try {
            return this.userRepository.save(user);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public User login(LoginDTO loginDTO) {
        String safePassword = this.encrypt(loginDTO.password());

        User user = this.userRepository.makeUserLogin(loginDTO.username(), safePassword);

        if (user == null)
            throw new DatabaseException(
                "login failed - username or password invalid",
                404
            );

        if (user.isActive()) {
            user.setPassword(null);
            return user;
        }

        try {
            user.setActive(true);
            this.userRepository.save(user);

            user.setPassword(null);

            return user;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public void logout(String token) {
        if (!this.jwtInsert.deleteTokenByToken(token))
            throw new AuthException("user logout failed");
    }

    @Override
    public User getById(Long id) {
        User user = this.userRepository.findUserById(id);

        if (user == null)
            throw new DatabaseException("user not found", 404);

        return user;
    }

    @Override
    public User update(Long id, UserDTO userDTO) {
        UserDTOChecker.userDTOChecker(userDTO);

        User user = this.userRepository.findUserById(id);

        if (user == null)
            throw new DatabaseException("user not found", 404);

        user = this.transferDtoToUserUpdateContext(userDTO, user);

        try {
            return this.userRepository.save(user);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public User updatePassword(RecoveryDTO recoveryDTO) {
        UserDTOChecker.checkPassword(recoveryDTO.password());

        String safePassword = this.encrypt(recoveryDTO.password());

        User user = this.userRepository.findUserByEmail(recoveryDTO.email());

        if (user == null)
            throw new DatabaseException("user not found", 404);

        user.setPassword(safePassword);

        try {
            User updated = this.userRepository.save(user);

            updated.setPassword(null);

            return updated;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    @Override
    public User delete(Long id) {
        User user = this.userRepository.findUserById(id);

        if (user == null)
            throw new DatabaseException("user not found", 404);

        user.setActive(false);

        try {
            User deleted = this.userRepository.save(user);

            deleted.setPassword(null);

            return deleted;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());

            throw new DatabaseException("Internal Server Error", 500);
        }
    }

    protected String encrypt(String password) {
        var bcrypt = new BCryptPasswordEncoder();

        return bcrypt.encode(password);
    }

    protected User transferDtoToUserUpdateContext(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.firstName());
        user.setLastName(userDTO.lastName());
        user.setBirthDate(userDTO.birthDate());
        user.setGender(userDTO.gender());

        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());

        String mobile = userDTO.mobile().isPresent() ? userDTO.mobile().get() : null;

        user.setMobile(mobile);
        user.setExperience(userDTO.experience());

        return user;
    }

    protected User transferDtoToUser(UserDTO userDTO) {
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

        return user;
    }
}
