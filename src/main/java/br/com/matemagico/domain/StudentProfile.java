package br.com.matemagico.domain;

import br.com.matemagico.domain.enums.AutismLevel;
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
    private Integer age;

    @Enumerated(EnumType.STRING)
    private AutismLevel autismLevel;

    private String hyperfocus;
    private String avatar;
    private String themeColor;
    private String fontSize;
    private Boolean soundSensitivity;
    private Boolean colorSensitivity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}