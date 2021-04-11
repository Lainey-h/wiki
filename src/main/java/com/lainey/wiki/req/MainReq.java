package com.lainey.wiki.req;

import java.util.Date;

public class MainReq {
    private String albh;

    private String jh;

    private String ytmc;

    private String jx;

    private String jb;

    private String gk;

    private Double zs;

    private Double zzjs;

    private String zydc;

    private String yx;

    private String sllb;

    private String sglx;

    private Date sgfssj;

    private Double sssj;

    private String slly;

    private String bz;

    private String sgfsms;

    private String sgclgc;

    private String zjclyj;

    public String getAlbh() {
        return albh;
    }

    public void setAlbh(String albh) {
        this.albh = albh;
    }

    public String getJh() {
        return jh;
    }

    public void setJh(String jh) {
        this.jh = jh;
    }

    public String getYtmc() {
        return ytmc;
    }

    public void setYtmc(String ytmc) {
        this.ytmc = ytmc;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getJb() {
        return jb;
    }

    public void setJb(String jb) {
        this.jb = jb;
    }

    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    public Double getZs() {
        return zs;
    }

    public void setZs(Double zs) {
        this.zs = zs;
    }

    public Double getZzjs() {
        return zzjs;
    }

    public void setZzjs(Double zzjs) {
        this.zzjs = zzjs;
    }

    public String getZydc() {
        return zydc;
    }

    public void setZydc(String zydc) {
        this.zydc = zydc;
    }

    public String getYx() {
        return yx;
    }

    public void setYx(String yx) {
        this.yx = yx;
    }

    public String getSllb() {
        return sllb;
    }

    public void setSllb(String sllb) {
        this.sllb = sllb;
    }

    public String getSglx() {
        return sglx;
    }

    public void setSglx(String sglx) {
        this.sglx = sglx;
    }

    public Date getSgfssj() {
        return sgfssj;
    }

    public void setSgfssj(Date sgfssj) {
        this.sgfssj = sgfssj;
    }

    public Double getSssj() {
        return sssj;
    }

    public void setSssj(Double sssj) {
        this.sssj = sssj;
    }

    public String getSlly() {
        return slly;
    }

    public void setSlly(String slly) {
        this.slly = slly;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getSgfsms() {
        return sgfsms;
    }

    public void setSgfsms(String sgfsms) {
        this.sgfsms = sgfsms;
    }

    public String getSgclgc() {
        return sgclgc;
    }

    public void setSgclgc(String sgclgc) {
        this.sgclgc = sgclgc;
    }

    public String getZjclyj() {
        return zjclyj;
    }

    public void setZjclyj(String zjclyj) {
        this.zjclyj = zjclyj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", albh=").append(albh);
        sb.append(", jh=").append(jh);
        sb.append(", ytmc=").append(ytmc);
        sb.append(", jx=").append(jx);
        sb.append(", jb=").append(jb);
        sb.append(", gk=").append(gk);
        sb.append(", zs=").append(zs);
        sb.append(", zzjs=").append(zzjs);
        sb.append(", zydc=").append(zydc);
        sb.append(", yx=").append(yx);
        sb.append(", sllb=").append(sllb);
        sb.append(", sglx=").append(sglx);
        sb.append(", sgfssj=").append(sgfssj);
        sb.append(", sssj=").append(sssj);
        sb.append(", slly=").append(slly);
        sb.append(", bz=").append(bz);
        sb.append(", sgfsms=").append(sgfsms);
        sb.append(", sgclgc=").append(sgclgc);
        sb.append(", zjclyj=").append(zjclyj);
        sb.append("]");
        return sb.toString();
    }
}