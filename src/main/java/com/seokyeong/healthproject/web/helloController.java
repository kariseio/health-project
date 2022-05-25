package com.seokyeong.healthproject.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class helloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
