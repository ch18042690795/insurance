package com.middle.entity;

import java.util.List;

public class IsDbsp {
    private String pkid;

    private String sbcwpc;

    private String jzlx00;

    private IsGrxx isGrxx;
    private IsZyxx isZyxx;
    private IsCyxx isCyxx;
    private List<IsZysfmx> isZysfmx;


    public List<IsZysfmx> getIsZysfmx() {
        return isZysfmx;
    }

    public void setIsZysfmx(List<IsZysfmx> isZysfmx) {
        this.isZysfmx = isZysfmx;
    }

    public IsCyxx getIsCyxx() {
        return isCyxx;
    }

    public void setIsCyxx(IsCyxx isCyxx) {
        this.isCyxx = isCyxx;
    }

    public IsZyxx getIsZyxx() {
        return isZyxx;
    }

    public void setIsZyxx(IsZyxx isZyxx) {
        this.isZyxx = isZyxx;
    }

    public IsGrxx getIsGrxx() {
        return isGrxx;
    }

    public void setIsGrxx(IsGrxx isGrxx) {
        this.isGrxx = isGrxx;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid == null ? null : pkid.trim();
    }

    public String getSbcwpc() {
        return sbcwpc;
    }

    public void setSbcwpc(String sbcwpc) {
        this.sbcwpc = sbcwpc == null ? null : sbcwpc.trim();
    }

    public String getJzlx00() {
        return jzlx00;
    }

    public void setJzlx00(String jzlx00) {
        this.jzlx00 = jzlx00 == null ? null : jzlx00.trim();
    }
}