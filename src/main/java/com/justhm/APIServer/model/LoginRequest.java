package com.justhm.APIServer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
}
