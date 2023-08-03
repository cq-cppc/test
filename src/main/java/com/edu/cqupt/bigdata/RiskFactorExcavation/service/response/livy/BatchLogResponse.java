package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BatchLogResponse {
    private Integer id;
    private Integer from;
    private Integer size;
    private List<String> log=new ArrayList<>();
}
