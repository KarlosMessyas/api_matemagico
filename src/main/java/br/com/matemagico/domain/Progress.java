package br.com.matemagico.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "progress")
@Getter
@Setter
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer correctAnswers;
    private Integer wrongAnswers;
    private Integer score;
    private Integer timeSpentInSeconds;
    private LocalDateTime completionDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile student;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
}