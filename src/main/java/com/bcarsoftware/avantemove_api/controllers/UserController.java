package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RecoveryDTO;
import com.bcarsoftware.avantemove_api.dtos.RespTokenDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.services.IUserService;
import com.bcarsoftware.avantemove_api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController{
    private final IUserService userService = new UserService();
    private final JwtInsert jwtInsert = new JwtInsert();

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.save(userDTO));
        successResponse.setCode(201);

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        SuccessResponse<RespTokenDTO> successResponse = new SuccessResponse<>();

        User logged = this.userService.login(loginDTO);

        String token = jwtInsert.createToken(
            logged.getId(),
            loginDTO.username(),
            "user"
        );

        logged.setPassword(null);

        RespTokenDTO response = new RespTokenDTO(logged, token);

        successResponse.setData(response);
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.logout());
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
        @PathVariable Long id,
        @RequestParam String token
    ) {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.getById(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<?> update(
        @PathVariable Long id,
        @RequestBody UserDTO userDTO,
        @RequestParam String token
    ) {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.update(id, userDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PatchMapping("/recovery")
    public ResponseEntity<?> updatePassword(RecoveryDTO recoveryDTO) {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.updatePassword(recoveryDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
        @PathVariable Long id,
        @RequestParam String token
    ) {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
