package com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.file.FileType;

public enum TableType {
    mysql,hive;

    @Override
    public String toString() {
        return this.name();
    }

    public static TableType verify(String type) throws Exception {
        switch (type){
            case "mysql":return mysql;
            case "hive":return hive;
            default:
                throw new Exception("不支持该类型");
        }
    }
}
