package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ActivityResponseDTO {

    private Long id;
    private String type;
    private Integer level;
    private String content;
}