package com.seokyeong.healthproject.controller;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import com.seokyeong.healthproject.service.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercise-api")
public class ExerciseController {

    private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    //http://localhost:8080/api/v1/exercise-api/exercise/{userId}/{exerciseId}
    @GetMapping(value = "/exercise/{userId}/{exerciseId}")
    public ExerciseDto getExercise(@PathVariable String userId, @PathVariable String exerciseId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseController] perform {} of healthproject API." , "getExercise");

        ExerciseDto exerciseDto = exerciseService.getExercise(userId, exerciseId);

        LOGGER.info("[ExerciseController] Response :: userId = {}, exerciseId = {}, sets = {}, weight = {}, times = {}, Response Time = {}ms",
                exerciseDto.getUserId(), exerciseDto.getExerciseId(), exerciseDto.getSets(), exerciseDto.getWeight(), exerciseDto.getTimes(), (System.currentTimeMillis() - startTime));

        return exerciseDto;
    }

    //http://localhost:8080/api/v1/exercise-api/exercise
    @GetMapping(value = "/exercise")
    public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseController] perform {} of healthproject API." , "saveExercise");

        String userId = exerciseDto.getUserId();
        String exerciseId = exerciseDto.getExerciseId();
        int sets = exerciseDto.getSets();
        int weight = exerciseDto.getWeight();
        int times = exerciseDto.getTimes();

        LOGGER.info("[ExerciseController] Response :: userId = {}, exerciseId = {}, sets = {}, weight = {}, times = {}, Response Time = {}ms",
                userId, exerciseId, sets, weight, times, (System.currentTimeMillis() - startTime));

        return exerciseService.saveExercise(userId, exerciseId, sets, weight, times);
    }
}
