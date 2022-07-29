package com.seokyeong.healthproject.controller;

import com.seokyeong.healthproject.config.auth.dto.SessionUser;
import com.seokyeong.healthproject.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
//        model.addAllAttributes("exerciseEntity", ExerciseService.findAllDesc());
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        return "index";
    }

    @GetMapping(value = "/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/exercise/save")
    public String saveExercise() {
        return "saveExercise";
    }

    @GetMapping(value = "/exercise/update")
    public String updateExercise() {
        return "updateExercise";
    }

    @GetMapping(value = "/exercise/delete")
    public String deleteExercise() {
        return "deleteExercise";
    }

    @PostMapping("/logtest")
    public void logTest() {
        LOGGER.trace("Trace log");
        LOGGER.debug("Debug log");
        LOGGER.info("Info log");
        LOGGER.warn("Warn log");
        LOGGER.error("Error log");
    }
}
