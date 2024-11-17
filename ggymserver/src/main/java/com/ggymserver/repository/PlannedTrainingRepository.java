package com.ggymserver.repository;

import com.ggymserver.entity.PlannedTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedTrainingRepository extends JpaRepository<PlannedTraining, Long> {
}
