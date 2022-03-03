package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.models.MathSolution;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldAddIntegersAndReturn200StatusCode() throws Exception {

        Map<String, String> input = new HashMap<>();
        input.put("operand1", "8");
        input.put("operand2", "8");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution math = new MathSolution(8,8,"add");
        math.setAnswer(math.getOperand1() + math.getOperand2());
        String expectedJson = mapper.writeValueAsString(math);

        mockMvc.perform(post("/add")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(expectedJson));
    }

    @Test
    public void shouldSubtractIntegersAndReturn200StatusCode() throws Exception {

        Map<String, String> input = new HashMap<>();
        input.put("operand1", "20");
        input.put("operand2", "10");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution math = new MathSolution(20, 10, "subtract");
        math.setAnswer(math.getOperand1() - math.getOperand2());
        String expectedJson = mapper.writeValueAsString(math);

        mockMvc.perform(post("/subtract")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(expectedJson));

    }

    @Test
    public void shouldMultiplyIntegersAndReturn200StatusCode() throws Exception {
        Map<String, String> input = new HashMap<>();
        input.put("operand1", "3");
        input.put("operand2", "2");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution math = new MathSolution(3, 2, "multiply");
        math.setAnswer(math.getOperand1() * math.getOperand2());
        String expectedJson = mapper.writeValueAsString(math);

        mockMvc.perform(post("/multiply")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(expectedJson));

    }

    @Test
    public void shouldDivideIntegersAndReturn200StatusCode() throws Exception {
        Map<String, String> input = new HashMap<>();
        input.put("operand1", "16");
        input.put("operand2", "2");
        String inputJson = mapper.writeValueAsString(input);

        MathSolution math = new MathSolution(16, 2, "divide");
        math.setAnswer(math.getOperand1() / math.getOperand2());
        String expectedJson = mapper.writeValueAsString(math);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()).andExpect(content().json(expectedJson));
    }

    @Test
    public void shouldReturn422ErrorCodeWithNonIntegerInput() throws Exception {

        Map<String, String> input1 = new HashMap<>();
        input1.put("operand1", "16");
        input1.put("operand2", "Three");
        String inputJson1 = mapper.writeValueAsString(input1);

        mockMvc.perform(post("/add")
                        .content(inputJson1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, String> input2 = new HashMap<>();
        input2.put("operand1", "false");
        input2.put("operand2", "10");
        String inputJson2 = mapper.writeValueAsString(input2);

        mockMvc.perform(post("/subtract")
                        .content(inputJson2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, String> input3 = new HashMap<>();
        input3.put("operand1", "Six");
        input3.put("operand2", "12");
        String inputJson3 = mapper.writeValueAsString(input3);

        mockMvc.perform(post("/multiply")
                        .content(inputJson3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, String> input4 = new HashMap<>();
        input4.put("operand1", ".00002");
        input4.put("operand2", "2");
        String inputJson4 = mapper.writeValueAsString(input4);

        mockMvc.perform(post("/divide")
                        .content(inputJson4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ErrorCodeWithNullInput() throws Exception {
        Map<String, String> input1 = new HashMap<>();
        input1.put("operand1", null);
        input1.put("operand2", "16");
        String inputJson1 = mapper.writeValueAsString(input1);

        mockMvc.perform(post("/add")
                        .content(inputJson1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, String> input2 = new HashMap<>();
        input2.put("operand1", null);
        input2.put("operand2", null);
        String inputJson2 = mapper.writeValueAsString(input2);

        mockMvc.perform(post("/subtract")
                        .content(inputJson2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, String> input3 = new HashMap<>();
        input3.put("operand1", "5");
        input3.put("operand2", null);
        String inputJson3 = mapper.writeValueAsString(input3);

        mockMvc.perform(post("/multiply")
                        .content(inputJson3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, String> input4 = new HashMap<>();
        input4.put("operand1", "6");
        input4.put("operand2", null);
        String inputJson4 = mapper.writeValueAsString(input4);

        mockMvc.perform(post("/divide")
                        .content(inputJson4)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldReturn422ErrorCodeWithDivisionByZero() throws Exception {
        Map<String, String> input = new HashMap<>();
        input.put("operand1", "16");
        input.put("operand2", "0");
        String inputJson = mapper.writeValueAsString(input);

        mockMvc.perform(post("/divide")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}