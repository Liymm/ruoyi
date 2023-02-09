package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息详情对象 user
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户唯一标识（外键） */
    @Excel(name = "用户唯一标识", readConverterExp = "外=键")
    private Long uid;

    /**  用户的名称 */
    @Excel(name = " 用户的名称")
    private String userName;

    /** 性别 */
    @Excel(name = "性别")
    private Long sex;

    /**  身高 */
    @Excel(name = " 身高")
    private Long height;

    /**  体重 */
    @Excel(name = " 体重")
    private Long weight;

    /**  生日 */
    @Excel(name = " 生日")
    private String birthdate;

    /**  用户头像 */
    @Excel(name = " 用户头像")
    private String userPhoto;

    /**  地址 */
    @Excel(name = " 地址")
    private String address;

    public void setUid(Long uid) 
    {
        this.uid = uid;
    }

    public Long getUid() 
    {
        return uid;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setBirthdate(String birthdate) 
    {
        this.birthdate = birthdate;
    }

    public String getBirthdate() 
    {
        return birthdate;
    }
    public void setUserPhoto(String userPhoto) 
    {
        this.userPhoto = userPhoto;
    }

    public String getUserPhoto() 
    {
        return userPhoto;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("uid", getUid())
            .append("userName", getUserName())
            .append("sex", getSex())
            .append("height", getHeight())
            .append("weight", getWeight())
            .append("birthdate", getBirthdate())
            .append("userPhoto", getUserPhoto())
            .append("address", getAddress())
            .toString();
    }
}
