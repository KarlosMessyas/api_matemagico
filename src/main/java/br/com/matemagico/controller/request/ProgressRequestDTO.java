package br.com.matemagico.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgressRequestDTO {

    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer score;
    private Long studentId;
    private Long activityId;
}
