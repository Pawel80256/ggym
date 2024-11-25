package com.ggymserver.controller;

import com.ggymserver.entity.ExerciseDto;
import com.ggymserver.service.ExerciseService;
import com.ggymserver.utility.LazyRequest;
import com.ggymserver.utility.LazyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/lazy")
    public ResponseEntity<LazyResponse<ExerciseDto>> getLazy(
            @RequestBody LazyRequest lazyRequest
            ){
        return ResponseEntity.ok(exerciseService.getLazy(lazyRequest));
    }
}
