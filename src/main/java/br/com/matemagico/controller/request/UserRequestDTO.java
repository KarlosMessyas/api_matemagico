package br.com.matemagico.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDTO {

    @NotBlank
    String name;

    @Email
    @NotBlank
    String email;

    @NotBlank
    String password;
}
