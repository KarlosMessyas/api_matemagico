package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DashboardResponseDTO {

    private Long totalActivities;
    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Double averageScore;
}