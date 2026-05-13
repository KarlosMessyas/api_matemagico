package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProgressResponseDTO {

    private Long id;
    private Long studentId;
    private Long activityId;

    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer score;
    private Integer timeSpentInSeconds;
    private LocalDateTime completionDate;
    private boolean isCorrect;
}