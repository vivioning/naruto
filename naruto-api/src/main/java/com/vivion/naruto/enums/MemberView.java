package com.vivion.naruto.enums;
import javax.validation.constraints.NotNull;

/**
 * Created by Mr.vivion on 2017/1/8.
 */
public class MemberView {

    private Long id;
    /**
     * 昵称
     */
    @NotNull(message = "游戏ID不能为空")
    private String nickName;
    /**
     * 战斗力
     */
    @NotNull(message = "战斗力不能为空")
    private String fightingForce;
    /**
     * 职位
     */
    private String position;
    /**
     * 是否有效
     */
    private Integer isValid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFightingForce() {
        return fightingForce;
    }

    public void setFightingForce(String fightingForce) {
        this.fightingForce = fightingForce;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
