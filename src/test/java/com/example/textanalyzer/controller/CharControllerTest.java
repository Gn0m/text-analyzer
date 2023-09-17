package com.example.textanalyzer.controller;

import com.example.textanalyzer.builder.ClassBuilder;
import com.example.textanalyzer.constant.PathURL;
import com.example.textanalyzer.dto.ChartDTO;
import com.example.textanalyzer.model.StringValue;
import com.example.textanalyzer.service.StringService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class CharControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private StringService service;

    private ChartDTO chartDTO;
    private StringValue stringValue;
    private Map<Character, Integer> map;

    @BeforeEach
    void setUp() {
        chartDTO = ClassBuilder.getCharDTO();
        stringValue = ClassBuilder.getStringValue();
        map = ClassBuilder.getTree();
    }

    @Test
    void allCount() throws Exception {
        MockHttpServletRequestBuilder content = post(PathURL.BASIC_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(stringValue));


        Mockito.when(service.getComparedTree(Mockito.any(StringValue.class)))
                .thenReturn(map);

        this.mockMvc.perform(content)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.l").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.o").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.r", CoreMatchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.l", CoreMatchers.is(2)))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()
                );
    }


    @Test
    void count() throws Exception {
        MockHttpServletRequestBuilder content = post(PathURL.BASIC_URL.concat(PathURL.COUNT_URL))
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(stringValue));


        Mockito.when(service.getNumbers(Mockito.any(StringValue.class), Mockito.any()))
                .thenReturn(chartDTO);

        this.mockMvc.perform(content)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.count").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.symbol", CoreMatchers.is("l")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count", CoreMatchers.is(2)))
                .andDo(MockMvcResultHandlers.print()
                );
    }
}