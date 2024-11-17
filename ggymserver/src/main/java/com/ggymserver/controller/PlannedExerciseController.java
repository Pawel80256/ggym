package com.ggymserver.controller;

import com.ggymserver.dto.request.CreatePlannedExerciseDto;
import com.ggymserver.service.PlannedExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planned-exercise")
@RequiredArgsConstructor
public class PlannedExerciseController {
    private final PlannedExerciseService plannedExerciseService;

    @PostMapping
    public ResponseEntity<Void> create (@RequestBody CreatePlannedExerciseDto dto){
        plannedExerciseService.create(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
