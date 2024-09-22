package com.baldefullstackdev.Security_service.Models.User.UserDto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
