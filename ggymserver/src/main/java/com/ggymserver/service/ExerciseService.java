package com.ggymserver.service;

import com.ggymserver.entity.ExerciseDto;
import com.ggymserver.mapper.ExerciseMapper;
import com.ggymserver.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public List<ExerciseDto> getByExerciseTypes(List<String> typesNames) {
        var exercises = exerciseRepository.findAllByExerciseTypes_NameIn(typesNames);
        return exercises.stream().map(exerciseMapper::toDto).toList();
    }
}
