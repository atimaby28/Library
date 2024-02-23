package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CaculatorMultiplyRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/param")
    public int addTwoParams(@RequestParam int number1, @RequestParam  int number2) {
        return number1 + number2;
    }

    @GetMapping("/get/object")
    public int addObject(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/post/object")
    public int multiplyObject(@RequestBody CaculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

}
