package com.seokyeong.healthproject.controller;

import com.seokyeong.healthproject.data.dto.ExerciseDto;
import com.seokyeong.healthproject.service.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise-api")
public class ExerciseController {

    private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // 운동 저장
    //http://localhost:8080/api/v1/exercise-api/
    @PostMapping(value = "/")
    public ExerciseDto saveExercise(@RequestBody ExerciseDto exerciseDto) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseController] perform {} of healthproject API." , "saveExercise");

        Long userId = exerciseDto.getUserId();
        String exerciseId = exerciseDto.getExerciseId();
        LocalDate date = exerciseDto.getDate();
        int sets = exerciseDto.getSets();
        int weight = exerciseDto.getWeight();
        int reps = exerciseDto.getReps();

        LOGGER.info("[ExerciseController] Response :: userId = {}, exerciseId = {}, date = {}, sets = {}, weight = {}, times = {}, Response Time = {}ms",
                userId, exerciseId, date, sets, weight, reps, (System.currentTimeMillis() - startTime));

        return exerciseService.saveExercise(userId, exerciseId, date, sets, weight, reps);
    }

    // 유저의 모든 운동 가져오기
    //http://localhost:8080/api/v1/exercise-api/{userId}
    @GetMapping(value = "/{userId}")
    public List<ExerciseDto> getExercise(@PathVariable Long userId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseController] perform {} of healthproject API." , "getExercise");

        List<ExerciseDto> exerciseDtoList = exerciseService.getAllExercise(userId);

        LOGGER.info("[ExerciseController] Response :: userId = {}, Response Time = {}ms",
                userId, (System.currentTimeMillis() - startTime));

        return exerciseDtoList;
    }

    // 유저의 선택한 운동 가져오기
    //http://localhost:8080/api/v1/exercise-api/{userId}/{exerciseId}
    @GetMapping(value = "/{userId}/{exerciseId}")
    public List<ExerciseDto> getExercise(@PathVariable Long userId, @PathVariable String exerciseId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseController] perform {} of healthproject API." , "getExercise");

        List<ExerciseDto> exerciseDtoList = exerciseService.getExercise(userId, exerciseId);

        LOGGER.info("[ExerciseController] Response :: userId = {}, exerciseId = {}, Response Time = {}ms",
                userId, exerciseId, (System.currentTimeMillis() - startTime));

        return exerciseDtoList;
    }

    // 유저의 날짜 가져오기
    //http://localhost:8080/api/v1/exercise-api/{userId}/{date}
    @GetMapping(value = "/{userId}/{date}")
    public List<ExerciseDto> getExerciseByDate(@PathVariable Long userId, @PathVariable LocalDate date) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseController] perform {} of healthproject API." , "getExerciseByDate");

        List<ExerciseDto> exerciseDtoList = exerciseService.getExerciseByDate(userId, date);

        LOGGER.info("[ExerciseController] Response :: userId = {}, size = {}, Response Time = {}ms",
                userId, exerciseDtoList.size(), (System.currentTimeMillis() - startTime));

        return exerciseDtoList;
    }


//    public ExerciseDto updateExercise() {
//
//    }
//
//    public ExerciseDto deleteExercise() {
//
//    }
}
