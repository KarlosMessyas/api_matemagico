package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerResponseDTO {

    private boolean correct;
    private Integer score;
}