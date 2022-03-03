package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MonthController {

    @GetMapping(value = "/month/{num}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonth(@PathVariable String num) {

        Month month = new Month();
        month.setNumber(num);
        switch (num) {
            case "1":
                month.setName("January");
                return month;
            case "2":
                month.setName("February");
                return month;
            case "3":
                month.setName("March");
                return month;
            case "4":
                month.setName("April");
                return month;
            case "5":
                month.setName("May");
                return month;
            case "6":
                month.setName("June");
                return month;
            case "7":
                month.setName("July");
                return month;
            case "8":
                month.setName("August");
                return month;
            case "9":
                month.setName("September");
                return month;
            case "10":
                month.setName("October");
                return month;
            case "11":
                month.setName("November");
                return month;
            case "12":
                month.setName("December");
                return month;
            default:
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Please enter a number between 1 and 12");
        }
    } // End getMonth Method

    @GetMapping(value = "/randomMonth")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {
        int num = (int) Math.floor(Math.random() * 12) + 1;

        Month month = new Month();
        switch (num) {
            case 1:
                month.setNumber("1");
                month.setName("January");
                return month;
            case 2:
                month.setNumber("2");
                month.setName("February");
                return month;
            case 3:
                month.setNumber("3");
                month.setName("March");
                return month;
            case 4:
                month.setNumber("4");
                month.setName("April");
                return month;
            case 5:
                month.setNumber("5");
                month.setName("May");
                return month;
            case 6:
                month.setNumber("6");
                month.setName("June");
                return month;
            case 7:
                month.setNumber("7");
                month.setName("July");
                return month;
            case 8:
                month.setNumber("8");
                month.setName("August");
                return month;
            case 9:
                month.setNumber("9");
                month.setName("September");
                return month;
            case 10:
                month.setNumber("10");
                month.setName("October");
                return month;
            case 11:
                month.setNumber("11");
                month.setName("November");
                return month;
            case 12:
                month.setNumber("12");
                month.setName("December");
                return month;
            default:
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please Try Again");
        } // End randomMonth Method
    }
}

