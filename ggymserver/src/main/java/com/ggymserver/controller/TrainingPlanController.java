package com.ggymserver.controller;

import com.ggymserver.dto.TrainingPlanDto;
import com.ggymserver.service.TrainingPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training-plan")
@RequiredArgsConstructor
public class TrainingPlanController {
    private final TrainingPlanService trainingPlanService;

    @GetMapping("/{id}")
    public ResponseEntity<TrainingPlanDto> getById(@PathVariable("id") Long trainingPlanId) {
        return ResponseEntity.ok(trainingPlanService.getById(trainingPlanId));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('MANAGE_TRAINING_PLAN')")
    public ResponseEntity<Void> create(@RequestBody TrainingPlanDto dto) {
        trainingPlanService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('MANAGE_TRAINING_PLAN')")
    public ResponseEntity<Void> update(@PathVariable("id") Long trainingId, @RequestBody TrainingPlanDto dto) {
        trainingPlanService.update(trainingId, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//    @PostMapping("/{id}/training-week")
//    public ResponseEntity<Void> addTrainingWeek(@PathVariable("id") Long trainingPlanId, @RequestBody CreateTrainingWeekDto trainingWeekDto) {
//        trainingPlanService.addTrainingWeek(trainingPlanId, trainingWeekDto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
}
