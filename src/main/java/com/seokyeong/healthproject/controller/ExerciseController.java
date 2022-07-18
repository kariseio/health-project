package com.seokyeong.healthproject.controller;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import com.seokyeong.healthproject.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercise-api")
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    //http://localhost:8080/api/v1/exercise-api/exercise/{userId}/{exerciseId}
    @GetMapping(value = "/exercise/{userId}/{exerciseId}")
    public ExerciseDto getExercise(@PathVariable String userId, @PathVariable String exerciseId) {
        return exerciseService.getExercise(userId, exerciseId);
    }

    //http://localhost:8080/api/v1/exercise-api/exercise
    @GetMapping(value = "/exercise")
    public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto) {
        String userId = exerciseDto.getUserId();
        String exerciseId = exerciseDto.getExerciseId();
        int sets = exerciseDto.getSets();
        int weight = exerciseDto.getWeight();
        int times = exerciseDto.getTimes();

        return exerciseService.saveExercise(userId, exerciseId, sets, weight, times);
    }
}
