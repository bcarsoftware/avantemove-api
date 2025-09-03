package com.bcarsoftware.avantemove_api.controllers;

import com.bcarsoftware.avantemove_api.core.jwt.JwtInsert;
import com.bcarsoftware.avantemove_api.core.responses.SuccessResponse;
import com.bcarsoftware.avantemove_api.dtos.LoginDTO;
import com.bcarsoftware.avantemove_api.dtos.RespTokenDTO;
import com.bcarsoftware.avantemove_api.dtos.TokenDTO;
import com.bcarsoftware.avantemove_api.dtos.UserDTO;
import com.bcarsoftware.avantemove_api.exceptions.AuthException;
import com.bcarsoftware.avantemove_api.models.User;
import com.bcarsoftware.avantemove_api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
    private final IUserService userService;
    private final JwtInsert jwtInsert;

    @Autowired
    public UserController(IUserService userService, JwtInsert jwtInsert) {
        this.userService = userService;
        this.jwtInsert = jwtInsert;
    }

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

        String token = this.jwtInsert.createToken(
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
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        SuccessResponse<User> successResponse = new SuccessResponse<>();

        this.userService.logout(token);

        successResponse.setData(null);
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PostMapping("/logout/all")
    public ResponseEntity<?> logoutAll(
        @RequestParam String username,
        @RequestParam String email,
        @RequestHeader("Authorization") String token
    ) {
        this.jwtInsert.verifyToken(token);

        if (!this.jwtInsert.deleteAllTokensUser(username, email))
            throw new AuthException("invalid token");

        SuccessResponse<RespTokenDTO> response = new SuccessResponse<>();

        response.setData(null);
        response.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
        @PathVariable Long id,
        @RequestHeader("Authorization") String token
    ) {
        this.jwtInsert.verifyToken(token);

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
        @RequestHeader("Authorization") String token
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.update(id, userDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(
        @PathVariable Long id,
        @RequestHeader("Authorization") String token
    ) {
        this.jwtInsert.verifyToken(token);

        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.delete(id));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }

    @Override
    @PostMapping("/token")
    public ResponseEntity<?> getUserByToken(@RequestBody TokenDTO tokenDTO) {
        jwtInsert.verifyToken(tokenDTO.token());

        SuccessResponse<User> successResponse = new SuccessResponse<>();

        successResponse.setData(this.userService.getUserByToken(tokenDTO));
        successResponse.setCode(200);

        return ResponseEntity.status(HttpStatus.OK).body(successResponse);
    }
}
