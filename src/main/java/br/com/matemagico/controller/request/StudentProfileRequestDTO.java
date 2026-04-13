package br.com.matemagico.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentProfileRequestDTO {

    private Integer level;
    private String preferences;
    private Long userId;
}