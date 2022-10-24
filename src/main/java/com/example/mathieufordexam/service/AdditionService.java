package com.example.mathieufordexam.service;

import com.example.mathieufordexam.dto.AdditionDtoIn;
import com.example.mathieufordexam.dto.AdditionDtoOut;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {

    public AdditionDtoOut addTwoNumbers(AdditionDtoIn additionDtoIn) {
        return new AdditionDtoOut(
                additionDtoIn.getFirstNumber() + additionDtoIn.getSecondNumber());
    }
}
