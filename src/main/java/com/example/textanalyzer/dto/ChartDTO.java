package com.example.textanalyzer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ApiModel(description = "ДТО ответа на поиск символа")
public class ChartDTO {

    @ApiModelProperty(notes = "Символ")
    private Character symbol;
    @ApiModelProperty(notes = "Количество")
    private int count;

    @Override
    public String toString() {
        return "CharsetDTO{" +
                "count=" + count +
                ", symbol=" + symbol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartDTO chartDTO = (ChartDTO) o;
        return count == chartDTO.count && Objects.equals(symbol, chartDTO.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, count);
    }
}
