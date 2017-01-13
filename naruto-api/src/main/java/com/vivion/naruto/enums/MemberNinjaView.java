package com.vivion.naruto.enums;

import java.util.Date;

/**
 * Created by GuoXinJie on 2017-01-13.
 */
public class MemberNinjaView {
    private Long id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 忍者
     */
    private String ninja;
    /**
     * 战斗力
     */
    private String fightingForce;
    /**
     * 抗魔值
     */
    private String magicResistance;
    private Date createTime;
    private Date updateTime;
    private Integer isValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNinja() {
        return ninja;
    }

    public void setNinja(String ninja) {
        this.ninja = ninja;
    }

    public String getFightingForce() {
        return fightingForce;
    }

    public void setFightingForce(String fightingForce) {
        this.fightingForce = fightingForce;
    }

    public String getMagicResistance() {
        return magicResistance;
    }

    public void setMagicResistance(String magicResistance) {
        this.magicResistance = magicResistance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
