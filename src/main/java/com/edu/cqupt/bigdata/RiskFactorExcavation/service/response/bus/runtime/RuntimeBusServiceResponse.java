package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.runtime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RuntimeBusServiceResponse {
   // private Integer busId;
   // private String busName;
  //  private String busDescription;
  //  @JSONField(format="yyyy-MM-dd HH:mm:ss")
   // private Timestamp taskCreateTime;
  //  private String icdCode;
   // private int algorithmId;
  //  private int tableId;
    private List<String> res;

    private String symptom1;
    private String symptom2;
    private String symptom3;
    private String symptom4;
    private String symptom5;
}
