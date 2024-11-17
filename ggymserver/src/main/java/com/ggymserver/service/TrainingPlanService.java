package com.ggymserver.service;

import com.ggymserver.dto.request.CreateTrainingPlanDto;
import com.ggymserver.entity.TrainingPlan;
import com.ggymserver.entity.User;
import com.ggymserver.mapper.TrainingPlanMapper;
import com.ggymserver.repository.TrainingPlanRepository;
import com.ggymserver.repository.UserRepository;
import com.ggymserver.utility.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingPlanService {
    private final TrainingPlanRepository trainingPlanRepository;
    private final TrainingPlanMapper trainingPlanMapper;
    private final UserRepository userRepository;

    public void create(CreateTrainingPlanDto createDTO) {
        TrainingPlan trainingPlan = trainingPlanMapper.toEntity(createDTO);

        User createdBy = userRepository.findByName(AuthUtil.getCurrentUserName())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        trainingPlan.setOwner(createdBy);

        trainingPlanRepository.save(trainingPlan);
    }
}
