package com.ggymserver.controller;

import com.ggymserver.dto.request.CreatePlannedTrainingWeekDto;
import com.ggymserver.service.PlannedTrainingWeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planned-training-week")
@RequiredArgsConstructor
public class PlannedTrainingWeekController {
    private final PlannedTrainingWeekService plannedTrainingWeekService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreatePlannedTrainingWeekDto dto){
        plannedTrainingWeekService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
