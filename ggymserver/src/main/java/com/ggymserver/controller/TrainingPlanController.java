package com.ggymserver.controller;

import com.ggymserver.dto.request.CreateTrainingPlanDto;
import com.ggymserver.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training-plan")
@RequiredArgsConstructor
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;

    @PostMapping
    @PreAuthorize("hasAuthority('MANAGE_TRAINING_PLAN')")
    public ResponseEntity<Void> create(@RequestBody CreateTrainingPlanDto dto) {
        trainingPlanService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
