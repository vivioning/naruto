package com.vivion.naruto.bean;

import com.hkfs.fundamental.api.data.PojoDataObjectBase;
import java.util.Date;
/**
 * 
 */
public class TeamDistribute extends PojoDataObjectBase {
    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 小队标志
     */
    private Integer teamId;
    private String teamName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 是否是leader
     */
    private String isLeader;
    private Date createTime;
    private Integer isValid;
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getTeamId() {
        return this.teamId;
    }
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
    public String getTeamName() {
        return this.teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getIsLeader() {
        return this.isLeader;
    }
    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
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
