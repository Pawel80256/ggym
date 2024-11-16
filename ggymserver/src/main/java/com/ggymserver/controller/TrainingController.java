package com.ggymserver.controller;

import com.ggymserver.entity.Training;
import com.ggymserver.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_TRAINING')")
    public void create(@RequestBody Training training) {
        trainingService.createTraining(training);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DELETE_TRAINING')")
    public void delete(@PathVariable Long id) {
        trainingService.deleteTraining(id);
    }
}
