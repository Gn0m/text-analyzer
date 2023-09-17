package com.example.textanalyzer.controller;

import com.example.textanalyzer.dto.ChartDTO;
import com.example.textanalyzer.model.StringValue;
import com.example.textanalyzer.service.StringService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/chars")
public class CharController {

    private final StringService service;

    @PostMapping()
    public Map<Character, Integer> allCount(@RequestBody StringValue value) {
        return service.getComparedTree(value);
    }

    @PostMapping("/count")
    public ChartDTO count(@RequestBody StringValue value, Character character) {
        return service.getNumbers(value, character);
    }

}
