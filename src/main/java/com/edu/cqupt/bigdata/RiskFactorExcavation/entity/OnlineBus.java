package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.abstractEntity.AbstractBus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Data
public class OnlineBus extends AbstractBus {
    private String busInputTopic;
    private String busOutputTopic;

}
