package com.seokyeong.healthproject.controller;

import com.seokyeong.healthproject.data.dto.ExerciseHistoryDto;
import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import com.seokyeong.healthproject.service.ExerciseHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise-api")
public class ExerciseHistoryController {

    private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class); // 로그
    private ExerciseHistoryService exerciseHistoryService; // 서비스

    @Autowired // 서비스 의존성 주입
    public ExerciseHistoryController(ExerciseHistoryService exerciseHistoryService) {
        this.exerciseHistoryService = exerciseHistoryService;
    }

    // 운동 기록 저장
    //http://localhost:8080/api/v1/exercise-api/
    @PostMapping(value = "/")
    public ExerciseHistoryDto saveExerciseHistory(@RequestBody ExerciseHistoryDto exerciseDto) {

        long startTime = System.currentTimeMillis(); // 시작 시간
        LOGGER.info("[ExerciseHistoryController] perform {} of healthProject API." , "saveExerciseHistory"); // 시작 로그

        Long userId = exerciseDto.getUserId(); // 유저 아이디
        String exerciseId = exerciseDto.getExerciseId(); // 운동 아이디
        LocalDate date = exerciseDto.getDate(); // 날짜
        int exerciseSet = exerciseDto.getExerciseSet(); // 세트 수
        int weight = exerciseDto.getWeight(); // 무게
        int rep = exerciseDto.getRep(); // 반복 횟수

        // 완료 로그
        LOGGER.info("[ExerciseHistoryController] Response :: userId = {}, exerciseId = {}, date = {}, exerciseSet = {}, weight = {}, rep = {}, Response Time = {}ms",
                userId, exerciseId, date, exerciseSet, weight, rep, (System.currentTimeMillis() - startTime));

        return exerciseHistoryService.saveExerciseHistory(userId, exerciseId, date, exerciseSet, weight, rep);
    }

    // 모든 운동 기록 검색
    //http://localhost:8080/api/v1/exercise-api/{userId}
    @GetMapping(value = "/{userId}")
    public List<ExerciseHistoryDto> getExerciseHistory(@PathVariable Long userId) {

        long startTime = System.currentTimeMillis(); // 시작 시간
        LOGGER.info("[ExerciseHistoryController] perform {} of healthProject API." , "getExerciseHistory"); // 시작 로그

        List<ExerciseHistoryDto> exerciseHistoryDtoList = exerciseHistoryService.getExerciseHistory(userId); // 운동 기록 가져오기
        
        // 완료 로그
        LOGGER.info("[ExerciseHistoryController] Response :: userId = {}, size = {}, Response Time = {}ms",
                userId, exerciseHistoryDtoList.size(), (System.currentTimeMillis() - startTime));

        return exerciseHistoryDtoList;
    }

    // 운동 기준 운동 기록 검색
    //http://localhost:8080/api/v1/exercise-api/{userId}/{exerciseId}
    @GetMapping(value = "/{userId}/{exerciseId}")
    public List<ExerciseHistoryDto> getExerciseHistoryById(@PathVariable Long userId, @PathVariable String exerciseId) {

        long startTime = System.currentTimeMillis(); // 시작 시간
        LOGGER.info("[ExerciseHistoryController] perform {} of healthProject API." , "getExerciseHistoryById"); // 시작 로그

        List<ExerciseHistoryDto> exerciseHistoryDtoList = exerciseHistoryService.getExerciseHistoryById(userId, exerciseId);

        LOGGER.info("[ExerciseHistoryController] Response :: userId = {}, exerciseId = {}, size = {}, Response Time = {}ms",
               userId, exerciseId, exerciseHistoryDtoList.size(), (System.currentTimeMillis() - startTime));

        return exerciseHistoryDtoList;
    }

    // 날짜 기준 운동 기록 검색
    //http://localhost:8080/api/v1/exercise-api/{userId}/{date}
    @GetMapping(value = "/{userId}/{date}")
    public List<ExerciseHistoryDto> getExerciseHistoryByDate(@PathVariable Long userId, @PathVariable LocalDate date) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ExerciseHistoryController] perform {} of healthProject API." , "getExerciseByDate");

        List<ExerciseHistoryDto> exerciseHistoryDtoList = exerciseHistoryService.getExerciseHistoryByDate(userId, date);

        LOGGER.info("[ExerciseHistoryController] Response :: userId = {}, date = {}, size = {}, Response Time = {}ms",
                userId, date, exerciseHistoryDtoList.size(), (System.currentTimeMillis() - startTime));

        return exerciseHistoryDtoList;
    }


//    public ExerciseDto updateExercise() {
//
//    }
//
//    public ExerciseDto deleteExercise() {
//
//    }
}
