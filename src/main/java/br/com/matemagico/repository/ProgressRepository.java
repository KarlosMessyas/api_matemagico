package br.com.matemagico.repository;

import br.com.matemagico.domain.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findByStudentId(Long studentId);
}
