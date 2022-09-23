package com.seokyeong.healthproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.seokyeong.healthproject.data.dto.ExerciseHistoryDto;
import com.seokyeong.healthproject.data.entity.ExerciseHistory;
import com.seokyeong.healthproject.repository.ExerciseHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ExerciseControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ExerciseHistoryRepository exerciseHistoryRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(roles="USER")
    public void 운동등록() throws Exception {
        // given
        Long userId = 1234L;
        String exerciseId = "홍길동";
        LocalDate date = LocalDate.of(2022, 7, 28);
        int set = 10;
        int weight = 100;
        int rep = 5;
        ExerciseHistoryDto exerciseHistoryDto = ExerciseHistoryDto.builder()
                .userId(userId)
                .exerciseId(exerciseId)
                .date(date)
                .set(set)
                .weight(weight)
                .rep(rep)
                .build();

//        String url = "http://localhost:" + port + "/api/v1/exercise-api/";
        String url = "http://localhost:" + port + "/api/v1/exercise-api/";


        // when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(exerciseHistoryDto)))
                .andExpect(status().isOk());


        // then
        List<ExerciseHistory> all = exerciseHistoryRepository.findAll();
        assertThat(all.get(0).getUserId()).isEqualTo(userId);
        assertThat(all.get(0).getExerciseId()).isEqualTo(exerciseId);

    }
}
