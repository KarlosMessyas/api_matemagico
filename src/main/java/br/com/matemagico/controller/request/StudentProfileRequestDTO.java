package br.com.matemagico.controller.request;

import br.com.matemagico.domain.enums.AutismLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentProfileRequestDTO {

    private Integer level;
    private String preferences;
    private Long userId;
    private AutismLevel autismLevel;
    private Integer age;
    private Boolean soundSensitivity;
    private Boolean colorSensitivity;
}