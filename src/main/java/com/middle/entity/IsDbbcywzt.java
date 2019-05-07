package com.middle.entity;

public class IsDbbcywzt {
    private String dbspid;

    private String lpzt00;

    public String getDbspid() {
        return dbspid;
    }

    public void setDbspid(String dbspid) {
        this.dbspid = dbspid == null ? null : dbspid.trim();
    }

    public String getLpzt00(Object lpzt00) {
        return this.lpzt00;
    }

    public void setLpzt00(String lpzt00) {
        this.lpzt00 = lpzt00 == null ? null : lpzt00.trim();
    }
}