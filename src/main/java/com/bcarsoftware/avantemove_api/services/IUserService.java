package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.TokenDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.models.User;

public interface IUserService {
    User save(UserDTO userDTO);
    User login(LoginDTO loginDTO);
    void logout(String token);
    User getById(Long id);
    User update(Long id, UserDTO userDTO);
    User delete(Long id);
    User getUserByToken(TokenDTO tokenDTO);
}
