package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProgressResponseDTO {

    private Long id;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer score;
    private Long studentId;
    private Long activityId;
}