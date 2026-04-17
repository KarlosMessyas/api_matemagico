package br.com.matemagico.repository;

import br.com.matemagico.domain.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

    boolean existsByUserId(Long userId);
}