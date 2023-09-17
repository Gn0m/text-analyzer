package com.example.textanalyzer.comparator;

import java.util.Comparator;
import java.util.Map;

public class MapComparator implements Comparator<Character> {

    private final Map<Character, Integer> map;

    public MapComparator(Map<Character, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Character o1, Character o2) {
        int i = map.get(o1);
        int j = map.get(o2);

        if (i == 1 && j == i) {
            i++;
        }

        if (i == j) {
            j++;
        }

        return j - i;
    }
}
