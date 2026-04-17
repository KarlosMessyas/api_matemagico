package br.com.matemagico.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDTO {

    @NotBlank(message = "O campo nome não pode estar em branco.")
    String name;

    @Email
    @NotBlank(message = "O campo email não pode estar em branco.")
    String email;

    @NotBlank(message = "O campo senha não pode estar em branco.")
    String password;
}
