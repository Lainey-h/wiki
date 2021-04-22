package com.lainey.wiki.domain;

public class Jcsj {
    private String albh;

    private String bz;

    private Double qz;

    private String sjlx;

    private String sjmx;

    private String sjz;

    private String dw;

    public String getAlbh() {
        return albh;
    }

    public void setAlbh(String albh) {
        this.albh = albh;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Double getQz() {
        return qz;
    }

    public void setQz(Double qz) {
        this.qz = qz;
    }

    public String getSjlx() {
        return sjlx;
    }

    public void setSjlx(String sjlx) {
        this.sjlx = sjlx;
    }

    public String getSjmx() {
        return sjmx;
    }

    public void setSjmx(String sjmx) {
        this.sjmx = sjmx;
    }

    public String getSjz() {
        return sjz;
    }

    public void setSjz(String sjz) {
        this.sjz = sjz;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", albh=").append(albh);
        sb.append(", bz=").append(bz);
        sb.append(", qz=").append(qz);
        sb.append(", sjlx=").append(sjlx);
        sb.append(", sjmx=").append(sjmx);
        sb.append(", sjz=").append(sjz);
        sb.append(", dw=").append(dw);
        sb.append("]");
        return sb.toString();
    }
}