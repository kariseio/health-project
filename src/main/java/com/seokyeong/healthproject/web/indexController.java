package com.seokyeong.healthproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class indexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
