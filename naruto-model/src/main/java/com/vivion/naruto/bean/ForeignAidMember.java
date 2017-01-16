package com.vivion.naruto.bean;

import com.hkfs.fundamental.api.data.PojoDataObjectBase;
import java.util.Date;
/**
 * 小队外援成员信息表
 */
public class ForeignAidMember extends PojoDataObjectBase {
    private static final long serialVersionUID = 1L;
    /**
     * 外援名称
     */
    private Long id;
    private String foreignAidName;
    private String fighting;
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
    public String getForeignAidName() {
        return this.foreignAidName;
    }
    public void setForeignAidName(String foreignAidName) {
        this.foreignAidName = foreignAidName;
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
