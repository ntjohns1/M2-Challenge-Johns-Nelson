package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.models.Month;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnMonthNameFromInputValue() throws Exception {

        Month output1 = new Month();
        output1.setNumber("1");
        output1.setName("January");
        String outputJson1 = mapper.writeValueAsString(output1);

        Month output2 = new Month();
        output2.setNumber("7");
        output2.setName("July");
        String outputJson2 = mapper.writeValueAsString(output2);

        Month output3 = new Month();
        output3.setNumber("11");
        output3.setName("November");
        String outputJson3 = mapper.writeValueAsString(output3);

        mockMvc.perform(get("/month/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(outputJson1));
        mockMvc.perform(get("/month/7")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(outputJson2));
        mockMvc.perform(get("/month/11")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(outputJson3));
    }

    @Test
    public void shouldReturnRandomMonth() throws Exception {
        mockMvc.perform(get("/randomMonth"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn422ErrorCodeIfInputOutOfRange() throws Exception {
        mockMvc.perform(get("/month/13"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}