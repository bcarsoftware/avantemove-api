package com.bcarsoftware.avantemove_api.services;

import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.models.User;

public interface IUserService {
    public abstract User save(UserDTO userDTO);
    public abstract User login(LoginDTO loginDTO);
    public abstract User logout();
    public abstract User getById(Long id);
    public abstract User update(Long id, UserDTO userDTO);
    public abstract User updatePassword(RecoveryDTO recoveryDTO);
    public abstract User delete(Long id);
}
