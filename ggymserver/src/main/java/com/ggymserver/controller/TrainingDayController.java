package com.ggymserver.controller;

import com.ggymserver.dto.request.CreatePlannedTrainingDto;
import com.ggymserver.service.TrainingDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training-day")
@RequiredArgsConstructor
public class TrainingDayController {
    private final TrainingDayService trainingDayService;

    @PostMapping("/{id}/planned-training")
    public ResponseEntity<Void> addPlannedTraining(@PathVariable("id") Long trainingDayId, @RequestBody CreatePlannedTrainingDto plannedTrainingDto) {
        trainingDayService.addTraining(trainingDayId, plannedTrainingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
