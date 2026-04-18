package br.com.matemagico.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDTO {

    @NotNull(message = "O ID do estudante é obrigatório.")
    private Long studentId;

    @NotNull(message = "A resposta não pode estar nula.")
    private Integer answer;
}