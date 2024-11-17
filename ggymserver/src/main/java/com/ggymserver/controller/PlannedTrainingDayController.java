package com.ggymserver.controller;

import com.ggymserver.dto.request.CreatePlannedTrainingDayDto;
import com.ggymserver.entity.PlannedTrainingDay;
import com.ggymserver.service.PlannedTrainingDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planned-training-day")
@RequiredArgsConstructor
public class PlannedTrainingDayController {
    private final PlannedTrainingDayService plannedTrainingDayService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreatePlannedTrainingDayDto dto) {
        plannedTrainingDayService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
