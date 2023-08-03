package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchResponse {

    private Integer id;
    private String appId;
    private AppInfo appInfo;
    private List<String> log;
    private SessionState state;
}
