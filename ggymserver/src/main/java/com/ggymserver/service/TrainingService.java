package com.ggymserver.service;

import com.ggymserver.entity.Training;
import com.ggymserver.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public void createTraining(Training training){
        trainingRepository.save(training);
    }

    public void deleteTraining(Long id){
        trainingRepository.deleteById(id);
    }
}
