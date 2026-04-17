package br.com.matemagico.controller.response;

import br.com.matemagico.domain.enums.AutismLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentProfileResponseDTO {

    private Long id;
    private Integer level;
    private String preferences;
    private Long userId;
    private AutismLevel autismLevel;
    private Integer age;
    private Boolean soundSensitivity;
    private Boolean colorSensitivity;
}