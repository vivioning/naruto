package com.vivion.naruto.bean;

import com.hkfs.fundamental.api.data.PojoDataObjectBase;
/**
 * 组织个人信息表
 */
public class Member extends PojoDataObjectBase {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 最高战斗力
     */
    private String fighting;
    /**
     * 饰品抗魔
     */
    private String magicResistance;
    /**
     * 职位
     */
    private String position;
    /**
     * 是否有效
     */
    private Integer isValid;
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getFighting() {
        return this.fighting;
    }
    public void setFighting(String fighting) {
        this.fighting = fighting;
    }
    public String getMagicResistance() {
        return this.magicResistance;
    }
    public void setMagicResistance(String magicResistance) {
        this.magicResistance = magicResistance;
    }
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Integer getIsValid() {
        return this.isValid;
    }
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
