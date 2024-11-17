package com.ggymserver.controller;

import com.ggymserver.dto.request.CreatePlannedTrainingDto;
import com.ggymserver.entity.PlannedTraining;
import com.ggymserver.service.PlannedTrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planned-training")
@RequiredArgsConstructor
public class PlannedTrainingController {
    private final PlannedTrainingService plannedTrainingService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreatePlannedTrainingDto dto) {
        plannedTrainingService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
