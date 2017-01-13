package com.vivion.naruto.bean;

import com.hkfs.fundamental.api.data.PojoDataObjectBase;
import java.util.Date;
/**
 * 成员忍者信息一览表
 */
public class MemberNinja extends PojoDataObjectBase {
    private static final long serialVersionUID = 1L;
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
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getNinja() {
        return this.ninja;
    }
    public void setNinja(String ninja) {
        this.ninja = ninja;
    }
    public String getFightingForce() {
        return this.fightingForce;
    }
    public void setFightingForce(String fightingForce) {
        this.fightingForce = fightingForce;
    }
    public String getMagicResistance() {
        return this.magicResistance;
    }
    public void setMagicResistance(String magicResistance) {
        this.magicResistance = magicResistance;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getIsValid() {
        return this.isValid;
    }
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
