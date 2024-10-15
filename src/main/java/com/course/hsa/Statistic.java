package com.course.hsa;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Statistic {

    private List<Double> searchTime = new ArrayList<>();
    private List<Double> insertTime = new ArrayList<>();
    private List<Double> deleteTime = new ArrayList<>();
}
