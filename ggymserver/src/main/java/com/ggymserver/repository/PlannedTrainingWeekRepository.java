package com.ggymserver.repository;

import com.ggymserver.entity.PlannedTrainingWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannedTrainingWeekRepository extends JpaRepository<PlannedTrainingWeek, Long> {
}
