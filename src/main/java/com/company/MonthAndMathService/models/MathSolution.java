package com.company.MonthAndMathService.models;

import java.util.Objects;

public class MathSolution {

    private Integer operand1;
    private Integer operand2;
    private String operation;
    private Integer answer;

    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution solution = (MathSolution) o;
        return Objects.equals(getOperand1(), solution.getOperand1()) && Objects.equals(getOperand2(), solution.getOperand2()) && Objects.equals(getOperation(), solution.getOperation()) && Objects.equals(getAnswer(), solution.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperand1(), getOperand2(), getOperation(), getAnswer());
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }
}
