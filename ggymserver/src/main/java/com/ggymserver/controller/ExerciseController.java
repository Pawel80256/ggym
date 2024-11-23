package com.ggymserver.controller;

import com.ggymserver.entity.ExerciseDto;
import com.ggymserver.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<ExerciseDto>> getByExerciseTypes(
            @RequestParam(required = false) List<String> types
    ){
        return ResponseEntity.ok(exerciseService.getByExerciseTypes(types));
    }
}
