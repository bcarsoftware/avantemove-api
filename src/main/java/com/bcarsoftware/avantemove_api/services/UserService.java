package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Override
    public User save(UserDTO userDTO) {
        return null;
    }

    @Override
    public User login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public User logout() {
        return null;
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User update(Integer id, UserDTO userDTO) {
        return null;
    }

    @Override
    public User updatePassword(RecoveryDTO recoveryDTO) {
        return null;
    }

    @Override
    public User delete(Integer id) {
        return null;
    }
}
