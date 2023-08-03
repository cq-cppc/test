package com.edu.cqupt.bigdata.RiskFactorExcavation.commom.task;

public enum TaskType {
    spark,pyspark,runtime;

    @Override
    public String toString() {
        return this.name();
    }
}
