package br.com.matemagico.controller.response;

import br.com.matemagico.domain.enums.AutismLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentProfileResponseDTO {
    private Long id;
    private Integer level;
    private Integer age;
    private AutismLevel autismLevel;

    private String hyperfocus;
    private String avatar;
    private String themeColor;
    private String fontSize;
    private Boolean soundSensitivity;
    private Boolean colorSensitivity;

    private Long userId;
}