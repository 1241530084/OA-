package com.icss.hr.perm.pojo;

public class Permission {
    private Integer permId;

    private String permName;

    private String perInfo;

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPerInfo() {
        return perInfo;
    }

    public void setPerInfo(String perInfo) {
        this.perInfo = perInfo == null ? null : perInfo.trim();
    }
}