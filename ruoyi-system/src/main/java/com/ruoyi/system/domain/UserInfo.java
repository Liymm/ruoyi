package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户数据表对象 user_info
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long pid;

    /** 用户唯一标识 */
    @Excel(name = "用户唯一标识")
    private Long uuid;

    /** 手机号 */
    @Excel(name = "手机号")
    private String userPhone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String userEmail;

    /** 密码 */
    private String userPwd;

    /** 当前用户的app版本 */
    @Excel(name = "当前用户的app版本")
    private String appVersion;

    /** 当前登录的手机名字 */
    @Excel(name = "当前登录的手机名字")
    private String phoneName;

    /** 手机序列号 */
    @Excel(name = "手机序列号")
    private String clientSn;

    /** 表示ios或android登录 */
    @Excel(name = "表示ios或android登录")
    private String clientType;

    /** 手机型号+手机版本号 */
    @Excel(name = "手机型号+手机版本号")
    private String phoneModel;

    /** 注册来源 */
    @Excel(name = "注册来源")
    private String userSource;

    /** 登录时间 */
    @Excel(name = "登录时间")
    private String loginDatetime;

    /** 第三方登录来源 */
    @Excel(name = "第三方登录来源")
    private String flag;

    /** 第三方登录的授权码 */
    @Excel(name = "第三方登录的授权码")
    private String accessToken;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 判断是否有无填写个人信息（0无/1有） */
    private Long selectType;

    @Excel(name = "是否为测试人员(0否/是)")
    private Long whiteList;

    @Excel(name = "iOS显示卡片的开关（0关/1开）")
    private Long switchDisplay;

    /** 是否禁用(0否/是) */
    @Excel(name = "是否禁用(0否/是)")
    private Long deleteNum;

    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setUuid(Long uuid) 
    {
        this.uuid = uuid;
    }

    public Long getUuid() 
    {
        return uuid;
    }
    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }
    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }
    public void setUserPwd(String userPwd) 
    {
        this.userPwd = userPwd;
    }

    public String getUserPwd() 
    {
        return userPwd;
    }
    public void setAppVersion(String appVersion) 
    {
        this.appVersion = appVersion;
    }

    public String getAppVersion() 
    {
        return appVersion;
    }
    public void setPhoneName(String phoneName) 
    {
        this.phoneName = phoneName;
    }

    public String getPhoneName() 
    {
        return phoneName;
    }
    public void setClientSn(String clientSn) 
    {
        this.clientSn = clientSn;
    }

    public String getClientSn() 
    {
        return clientSn;
    }
    public void setClientType(String clientType) 
    {
        this.clientType = clientType;
    }

    public String getClientType() 
    {
        return clientType;
    }
    public void setPhoneModel(String phoneModel) 
    {
        this.phoneModel = phoneModel;
    }

    public String getPhoneModel() 
    {
        return phoneModel;
    }
    public void setUserSource(String userSource) 
    {
        this.userSource = userSource;
    }

    public String getUserSource() 
    {
        return userSource;
    }
    public void setLoginDatetime(String loginDatetime) 
    {
        this.loginDatetime = loginDatetime;
    }

    public String getLoginDatetime() 
    {
        return loginDatetime;
    }
    public void setFlag(String flag) 
    {
        this.flag = flag;
    }

    public String getFlag() 
    {
        return flag;
    }
    public void setAccessToken(String accessToken) 
    {
        this.accessToken = accessToken;
    }

    public String getAccessToken() 
    {
        return accessToken;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setSelectType(Long selectType) 
    {
        this.selectType = selectType;
    }

    public Long getSelectType() 
    {
        return selectType;
    }

    public Long getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(Long whiteList) {
        this.whiteList = whiteList;
    }

    public Long getSwitchDisplay() {
        return switchDisplay;
    }

    public void setSwitchDisplay(Long switchDisplay) {
        this.switchDisplay = switchDisplay;
    }

    public void setDeleteNum(Long deleteNum)
    {
        this.deleteNum = deleteNum;
    }

    public Long getDeleteNum() 
    {
        return deleteNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pid", getPid())
            .append("uuid", getUuid())
            .append("userPhone", getUserPhone())
            .append("userEmail", getUserEmail())
            .append("userPwd", getUserPwd())
            .append("appVersion", getAppVersion())
            .append("phoneName", getPhoneName())
            .append("clientSn", getClientSn())
            .append("clientType", getClientType())
            .append("phoneModel", getPhoneModel())
            .append("userSource", getUserSource())
            .append("loginDatetime", getLoginDatetime())
            .append("flag", getFlag())
            .append("accessToken", getAccessToken())
            .append("country", getCountry())
            .append("selectType", getSelectType())
            .append("whiteList", getWhiteList())
            .append("switchDisplay",getSwitchDisplay())
            .append("deleteNum", getDeleteNum())
            .toString();
    }
}
