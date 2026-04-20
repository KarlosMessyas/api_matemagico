package br.com.matemagico.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @Email
    @NotBlank(message = "O campo email não pode estar em branco.")
    private String email;

    @NotBlank(message = "O campo senha não pode estar em branco.")
    private String password;
}
