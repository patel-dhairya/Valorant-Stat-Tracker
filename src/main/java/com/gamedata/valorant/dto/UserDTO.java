package com.gamedata.valorant.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    @NotNull(message = "Username is a mandatory field.")
    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 1, max = 50, message = "Username must be between 1 and 50 characters.")
    private String userName;

    @NotNull(message = "User email is a mandatory field.")
    @NotBlank(message = "User email cannot be blank.")
    @Email(message = "User email should be a valid email address.")
    @Size(max = 100, message = "User email must be at most 100 characters.")
    private String userEmail;

    @NotNull(message = "Password is a mandatory field.")
    @NotBlank(message = "Password cannot be blank.")
    @Size(min = 6, max = 100, message = "Password must have at least 6 and at most 100 characters.")
    private String password;
}
