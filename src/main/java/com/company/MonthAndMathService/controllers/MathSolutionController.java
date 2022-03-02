package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.models.MathSolution;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathSolutionController {

    @PostMapping("/add")
    public MathSolution addition(@RequestBody MathSolution solution) {
        int answer = solution.getOperand1() + solution.getOperand2();
        solution.setOperation("add");
        solution.setAnswer(answer);
        return solution;
    }

    @PostMapping("/subtract")
    public MathSolution subtraction(@RequestBody MathSolution solution) {
        int answer = solution.getOperand1() - solution.getOperand2();
        solution.setOperation("subtract");
        solution.setAnswer(answer);
        return solution;
    }

    @PostMapping("/multiply")
    public MathSolution multiplication(@RequestBody MathSolution solution) {
        int answer = solution.getOperand1() * solution.getOperand2();
        solution.setOperation("multiply");
        solution.setAnswer(answer);
        return solution;
    }

    @PostMapping("/divide")
    public MathSolution division(@RequestBody MathSolution solution) {
        if (solution.getOperand2() == 0) {
            throw new IllegalArgumentException("Cannot Divide by Zero");
        }
        int answer = solution.getOperand1() / solution.getOperand2();
        solution.setOperation("divide");
        solution.setAnswer(answer);
        return solution;
    }
}
