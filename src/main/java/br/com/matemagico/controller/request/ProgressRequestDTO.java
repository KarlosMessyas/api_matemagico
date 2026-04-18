package br.com.matemagico.controller.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgressRequestDTO {

    @NotNull(message = "A quantidade de respostas corretas é obrigatória.")
    @Min(value = 0, message = "As respostas corretas não podem ser negativas.")
    private Integer correctAnswers;

    @NotNull(message = "A quantidade de respostas erradas é obrigatória.")
    @Min(value = 0, message = "As respostas erradas não podem ser negativas.")
    private Integer wrongAnswers;

    @NotNull(message = "A pontuação é obrigatória.")
    private Integer score;

    @NotNull(message = "O ID do estudante é obrigatório.")
    private Long studentId;

    @NotNull(message = "O ID da atividade é obrigatória.")
    private Long activityId;
}