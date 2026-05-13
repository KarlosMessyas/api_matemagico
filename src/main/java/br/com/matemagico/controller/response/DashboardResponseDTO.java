package br.com.matemagico.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponseDTO {

    private long totalActivities;
    private int correctAnswers;
    private int wrongAnswers;
    private double averageScore;
}