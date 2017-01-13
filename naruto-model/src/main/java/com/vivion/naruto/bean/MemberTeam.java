package com.vivion.naruto.bean;

import com.hkfs.fundamental.api.data.PojoDataObjectBase;
import java.util.Date;
/**
 * 小队分配表
 */
public class MemberTeam extends PojoDataObjectBase {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 成员名称
     */
    private String member;
    /**
     * 鼬战斗力
     */
    private String fightingA;
    /**
     * 红战斗力
     */
    private String fightingB;
    /**
     * 小队位置
     */
    private String position;
    private Date createTime;
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
    public String getMember() {
        return this.member;
    }
    public void setMember(String member) {
        this.member = member;
    }
    public String getFightingA() {
        return this.fightingA;
    }
    public void setFightingA(String fightingA) {
        this.fightingA = fightingA;
    }
    public String getFightingB() {
        return this.fightingB;
    }
    public void setFightingB(String fightingB) {
        this.fightingB = fightingB;
    }
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getIsValid() {
        return this.isValid;
    }
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}
