package com.example.mathieufordexam.service;

import com.example.mathieufordexam.dto.AdditionDtoIn;
import com.example.mathieufordexam.dto.AdditionDtoOut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AdditionServiceTest {
    static AdditionService additionService;

    AdditionDtoIn additionDtoIn;

    @BeforeAll
    static void beforeAll() {
        additionService = new AdditionService();
    }

    @BeforeEach
    void beforeEach() {
        additionDtoIn = new AdditionDtoIn(10, 11);
    }

    @Test
    void addTwoNumbersHappyDayTest() {
        //Act
        AdditionDtoOut additionDtoOut = additionService.addTwoNumbers(additionDtoIn);

        //Assert
        assertThat(additionDtoOut.getResult())
                .isEqualTo(additionDtoIn.getFirstNumber() + additionDtoIn.getSecondNumber());
    }
}
