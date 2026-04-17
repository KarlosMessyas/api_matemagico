package br.com.matemagico.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDTO {

    private Long studentId;
    private Integer answer;
}