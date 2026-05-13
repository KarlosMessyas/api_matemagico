package br.com.matemagico.repository;

import br.com.matemagico.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByLevel(Integer level);
}