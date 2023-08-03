package com.edu.cqupt.bigdata.RiskFactorExcavation.commom.file;

public enum FileType {
    csv,java,jar,py,zip,no_type;

    public static FileType verify(String type){
        if (type.equals(csv.name())) return csv;
        if (type.equals(jar.name())) return jar;
        if (type.equals(zip.name())) return zip;
        if (type.equals(java.name())) return java;
        if (type.equals(py.name())) return py;
        return no_type;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
