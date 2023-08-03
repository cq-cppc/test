package com.edu.cqupt.bigdata.RiskFactorExcavation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RiskFactorExcavationApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiskFactorExcavationApplication.class, args);
    }

}
