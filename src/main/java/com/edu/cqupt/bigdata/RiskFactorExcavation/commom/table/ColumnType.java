package com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table;

public enum ColumnType {
    cdate,cdouble,cinteger,cenum,cstring;
    public static String convertHiveType(ColumnType dateType) throws Exception {
        switch (dateType) {
            case cdate:
                return "date";
            case cenum:
            case cstring:
                return "string";
            case cdouble:
                return "double";
            case cinteger:
                return "int";
            default:
                throw new Exception("不支持该类型");
        }
    }

    public static String convertMysqlType(ColumnType dateType) throws Exception {
        switch (dateType) {
            case cdate:
                return "datetime";
            case cenum:
            case cstring:
                return "varchar(2048)";
            case cdouble:
                return "double";
            case cinteger:
                return "int";
            default:
                throw new Exception("不支持该类型");
        }
    }

    public static String convertType(ColumnType dateType,TableType tableType) throws Exception{
        switch (tableType){
            case hive:return convertHiveType(dateType);
            case mysql:return convertMysqlType(dateType);
            default:
                throw new Exception("不支持该类型");
        }
    }

}
