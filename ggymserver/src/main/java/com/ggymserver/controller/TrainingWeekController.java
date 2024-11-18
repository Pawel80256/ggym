package com.ggymserver.controller;

import com.ggymserver.dto.request.CreateTrainingDayDto;
import com.ggymserver.service.TrainingWeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training-week")
@RequiredArgsConstructor
public class TrainingWeekController {
    private final TrainingWeekService trainingWeekService;

    @PostMapping("/{id}/training-day")
    public ResponseEntity<Void> addTrainingDay(@PathVariable("id") Long trainingWeekId, @RequestBody CreateTrainingDayDto trainingDayDto) {
        trainingWeekService.addTrainingDay(trainingWeekId,trainingDayDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
