package com.ggymserver.repository;

import com.ggymserver.entity.PlannedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedExerciseRepository extends JpaRepository<PlannedExercise, Long> {
}
