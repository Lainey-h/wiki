package com.lainey.wiki.req;

public class FszzQueryReq extends PageReq {
    private Long albh;

    private Double qz;

    private String gzfs;

    private String sgfsqhbs;

    private String sgzzlx;

    private String sgzzbm;

    private String ydzk;

    private String ydcs;

    private String dw;

    private String sxlb;

    public Long getAlbh() {
        return albh;
    }

    public void setAlbh(Long albh) {
        this.albh = albh;
    }

    public Double getQz() {
        return qz;
    }

    public void setQz(Double qz) {
        this.qz = qz;
    }

    public String getGzfs() {
        return gzfs;
    }

    public void setGzfs(String gzfs) {
        this.gzfs = gzfs;
    }

    public String getSgfsqhbs() {
        return sgfsqhbs;
    }

    public void setSgfsqhbs(String sgfsqhbs) {
        this.sgfsqhbs = sgfsqhbs;
    }

    public String getSgzzlx() {
        return sgzzlx;
    }

    public void setSgzzlx(String sgzzlx) {
        this.sgzzlx = sgzzlx;
    }

    public String getSgzzbm() {
        return sgzzbm;
    }

    public void setSgzzbm(String sgzzbm) {
        this.sgzzbm = sgzzbm;
    }

    public String getYdzk() {
        return ydzk;
    }

    public void setYdzk(String ydzk) {
        this.ydzk = ydzk;
    }

    public String getYdcs() {
        return ydcs;
    }

    public void setYdcs(String ydcs) {
        this.ydcs = ydcs;
    }

    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    public String getSxlb() {
        return sxlb;
    }

    public void setSxlb(String sxlb) {
        this.sxlb = sxlb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", albh=").append(albh);
        sb.append(", qz=").append(qz);
        sb.append(", gzfs=").append(gzfs);
        sb.append(", sgfsqhbs=").append(sgfsqhbs);
        sb.append(", sgzzlx=").append(sgzzlx);
        sb.append(", sgzzbm=").append(sgzzbm);
        sb.append(", ydzk=").append(ydzk);
        sb.append(", ydcs=").append(ydcs);
        sb.append(", dw=").append(dw);
        sb.append(", sxlb=").append(sxlb);
        sb.append("]");
        return sb.toString();
    }
}