package com.example.textanalyzer.builder;

import com.example.textanalyzer.comparator.MapComparator;
import com.example.textanalyzer.dto.ChartDTO;
import com.example.textanalyzer.model.StringValue;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ClassBuilder {

    public static ChartDTO getCharDTO() {
        return new ChartDTO('l', 2);
    }

    public static StringValue getStringValue() {
        return new StringValue("Hello world", 2, 8);
    }

    public static Map<Character, Integer> getTree() {
        Map<Character, Integer> map = new TreeMap<>(new MapComparator(getTmpMap()));
        map.putAll(getTmpMap());
        return map;
    }

    private static Map<Character, Integer> getTmpMap() {
        Map<Character, Integer> tmpMap = new HashMap<>();
        tmpMap.put('l', 2);
        tmpMap.put('o', 2);
        tmpMap.put('w', 1);
        tmpMap.put('r', 1);
        tmpMap.put(' ', 1);
        return tmpMap;
    }
}
