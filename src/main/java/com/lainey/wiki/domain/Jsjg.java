package com.lainey.wiki.domain;

public class Jsjg {
    private Long albh;

    private Double tgdbsd;

    private Double tgwj;

    private Double tgxsd;

    private String tgmc;

    public Long getAlbh() {
        return albh;
    }

    public void setAlbh(Long albh) {
        this.albh = albh;
    }

    public Double getTgdbsd() {
        return tgdbsd;
    }

    public void setTgdbsd(Double tgdbsd) {
        this.tgdbsd = tgdbsd;
    }

    public Double getTgwj() {
        return tgwj;
    }

    public void setTgwj(Double tgwj) {
        this.tgwj = tgwj;
    }

    public Double getTgxsd() {
        return tgxsd;
    }

    public void setTgxsd(Double tgxsd) {
        this.tgxsd = tgxsd;
    }

    public String getTgmc() {
        return tgmc;
    }

    public void setTgmc(String tgmc) {
        this.tgmc = tgmc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", albh=").append(albh);
        sb.append(", tgdbsd=").append(tgdbsd);
        sb.append(", tgwj=").append(tgwj);
        sb.append(", tgxsd=").append(tgxsd);
        sb.append(", tgmc=").append(tgmc);
        sb.append("]");
        return sb.toString();
    }
}