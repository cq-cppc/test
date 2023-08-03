package com.edu.cqupt.bigdata.RiskFactorExcavation.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NameNameGenerator {

    Random random=new Random();

    public String getName(){
        int index=random.nextInt(25);
        char[] na=new char[2];
        na[0]=(char) (index+'a');
        index=random.nextInt(25);
        na[1]=(char) (index+'a');
        return new String(na);
    }

}
