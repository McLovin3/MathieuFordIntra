package com.example.mathieufordexam.controller;

import com.example.mathieufordexam.dto.AdditionDtoIn;
import com.example.mathieufordexam.dto.AdditionDtoOut;
import com.example.mathieufordexam.service.AdditionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AdditionControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    AdditionController additionController;

    @Mock
    AdditionService additionService;

    JacksonTester<AdditionDtoIn> additionDtoInJacksonTester;

    AdditionDtoIn additionDtoIn1;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders.standaloneSetup(additionController).build();
        JacksonTester.initFields(this, new ObjectMapper());

        additionDtoIn1 = new AdditionDtoIn(10, 11);
    }


    @Test
    void putAddHappyDayTest() throws Exception {
        //Arrange
        when(additionService.addTwoNumbers(additionDtoIn1))
                .thenReturn(new AdditionDtoOut(
                        additionDtoIn1.getFirstNumber() + additionDtoIn1.getSecondNumber()));

        //Act
        mockMvc.perform(put("http://localhost:8080/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(additionDtoInJacksonTester.write(additionDtoIn1).getJson()))

                //Assert
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(additionDtoIn1.getFirstNumber() + additionDtoIn1.getSecondNumber()));
    }

    @Test
    void putAddBadRequestTest() throws Exception {
        //Act
        mockMvc.perform(put("http://localhost:8080/add"))

                //Assert
                .andExpect(status().isBadRequest());
    }

}
