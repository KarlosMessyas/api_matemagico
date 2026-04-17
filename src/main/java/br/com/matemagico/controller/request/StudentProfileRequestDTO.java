package br.com.matemagico.controller.request;

import br.com.matemagico.domain.enums.AutismLevel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentProfileRequestDTO {

    @NotNull(message = "O nível não pode ser nulo.")
    @Min(value = 1, message = "O nível deve ser no mínimo 1.")
    private Integer level;

    @NotBlank(message = "As preferências não podem estar em branco.")
    private String preferences;

    @NotNull(message = "O ID do usuário vinculado é obrigatório.")
    private Long userId;

    @NotNull(message = "O nível de suporte deve ser informado.")
    private AutismLevel autismLevel;

    @NotNull(message = "A idade é obrigatória.")
    @Min(value = 1, message = "A idade deve ser um valor válido e maior que zero.")
    private Integer age;

    @NotNull(message = "A informação sobre sensibilidade sonora é obrigatória.")
    private Boolean soundSensitivity;

    @NotNull(message = "A informação sobre sensibilidade a cores é obrigatória.")
    private Boolean colorSensitivity;
}