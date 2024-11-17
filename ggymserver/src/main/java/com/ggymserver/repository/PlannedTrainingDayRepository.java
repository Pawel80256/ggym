package com.ggymserver.repository;

import com.ggymserver.entity.PlannedTrainingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedTrainingDayRepository extends JpaRepository<PlannedTrainingDay, Long> {
}
