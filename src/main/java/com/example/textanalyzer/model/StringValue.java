package com.example.textanalyzer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StringValue {

    private String string;
    private int start;
    private int end;


    public void setString(String string) {
        this.string = string;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "StringValue{" +
                "string='" + string + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public char[] getCharArray() {
        return string.toCharArray();
    }
}
