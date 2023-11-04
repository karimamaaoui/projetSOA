package com.nuistindo.UniversitySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nuistindo.UniversitySystem.model.UserLoginRequest;
import com.nuistindo.UniversitySystem.model.UserLoginResponse;
import com.nuistindo.UniversitySystem.service.UsersService;

@Endpoint
public class UserLoginSOAPController {
    private static final String NAMESPACE_URI = "http://nuistindo.com/management"; 

    private final UsersService userService;

    @Autowired
    public UserLoginSOAPController(UsersService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserLoginRequest")
    @ResponsePayload
    public UserLoginResponse login(@RequestPayload UserLoginRequest request) {
        UserLoginResponse response = new UserLoginResponse();
        String username = request.getUsername();
        String password = request.getPassword();

        boolean isAuthenticated = userService.authenticateUser(username, password);

        response.setSuccess(isAuthenticated);

        return response;
    }
}
