package com.vivion.naruto.enums;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
public class MemberParamter {
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 战斗力
     */
    private String fighting;
    /**
     * 是否有效
     */
    private Integer isValid;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFighting() {
        return fighting;
    }

    public void setFighting(String fighting) {
        this.fighting = fighting;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
