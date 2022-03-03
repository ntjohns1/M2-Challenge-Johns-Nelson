package com.company.MonthAndMathService.models;

import java.util.Objects;

public class Month {

    String number;
    String name;

    public Month() {
    }

    public Month(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return Objects.equals(getNumber(), month.getNumber()) && Objects.equals(getName(), month.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getName());
    }

    @Override
    public String toString() {
        return "Month{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
