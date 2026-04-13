package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentProfileResponseDTO {

    private Long id;
    private Integer level;
    private String preferences;
    private Long userId;
}