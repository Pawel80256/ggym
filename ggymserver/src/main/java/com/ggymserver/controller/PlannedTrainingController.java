package com.ggymserver.controller;

import com.ggymserver.dto.request.CreatePlannedExerciseDto;
import com.ggymserver.service.PlannedTrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planned-training")
@RequiredArgsConstructor
public class PlannedTrainingController {
    private final PlannedTrainingService plannedTrainingService;

    @PostMapping("/{id}/planned-exercise")
    public ResponseEntity<Void> addPlannedExercise(@PathVariable("id") Long plannedTrainingId, @RequestBody CreatePlannedExerciseDto plannedExerciseDto) {
        plannedTrainingService.addPlannedExercise(plannedTrainingId, plannedExerciseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
