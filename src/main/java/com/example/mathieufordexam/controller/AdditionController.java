package com.example.mathieufordexam.controller;

import com.example.mathieufordexam.dto.AdditionDtoIn;
import com.example.mathieufordexam.dto.AdditionDtoOut;
import com.example.mathieufordexam.service.AdditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AdditionController {

    private final AdditionService additionService;

    @PutMapping("add")
    public ResponseEntity<AdditionDtoOut> addTwoNumbers(@RequestBody AdditionDtoIn additionDtoIn) {
        return ResponseEntity.ok(additionService.addTwoNumbers(additionDtoIn));
    }
}
