package br.com.matemagico.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student_profiles")
@Getter
@Setter
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer level;

    private String preferences;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}