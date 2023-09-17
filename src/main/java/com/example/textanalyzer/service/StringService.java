package com.example.textanalyzer.service;

import com.example.textanalyzer.comparator.MapComparator;
import com.example.textanalyzer.dto.ChartDTO;
import com.example.textanalyzer.model.StringValue;
import lombok.NoArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
@NoArgsConstructor
public class StringService {

    public Map<Character, Integer> getComparedTree(StringValue value) {
        val chars = value.getCharArray();
        val map = getSubstring(value.getStart(), value.getEnd(), chars);
        Map<Character, Integer> tree = new TreeMap<>(
                new MapComparator(map)
        );
        tree.putAll(map);
        return tree;
    }

    public ChartDTO getNumbers(StringValue value, Character c) {

        if (value.getEnd() == 0) {
            value.setEnd(value.getString().length() - 1);
        }

        val chars = value.getCharArray();
        int countChar = 0;
        for (int i = value.getStart(); i <= value.getEnd(); i++) {
            if (c.equals(chars[i])) {
                countChar++;
            }
        }
        return new ChartDTO(c, countChar);
    }


    private Map<Character, Integer> getSubstring(int start, int end, char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        end++;
        for (int i = start; i < end; i++) {
            int countChar = 0;
            Character c = chars[i];
            countChar++;
            for (int j = i + 1; j < end; j++) {
                if (c.equals(chars[j])) {
                    countChar++;
                }
            }
            map.putIfAbsent(c, countChar);
        }
        return map;
    }

}
