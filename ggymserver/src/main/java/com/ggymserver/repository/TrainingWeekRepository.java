package com.ggymserver.repository;

import com.ggymserver.entity.TrainingWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingWeekRepository extends JpaRepository<TrainingWeek, Long> {
}
