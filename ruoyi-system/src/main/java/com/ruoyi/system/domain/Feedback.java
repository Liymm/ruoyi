package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 意见反馈对象 feedback
 * 
 * @author ruoyi
 * @date 2022-10-26
 */
public class Feedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long fid;

    /** 用户唯一标识 */
    @Excel(name = "用户唯一标识")
    private Long uuid;

    /** 手机类型 */
    @Excel(name = "手机类型")
    private String clientType;

    /** app版本 */
    @Excel(name = "app版本")
    private String appVersion;

    /** 反馈内容 */
    @Excel(name = "反馈内容")
    private String content;

    /** 反馈上传的图片路径 */
    @Excel(name = "反馈上传的图片路径")
    private String filePaths;

    /** 发表时间 */
    @Excel(name = "发表时间")
    private String issueTime;

    /** 操作系统 */
    @Excel(name = "操作系统")
    private String phoneModel;

    public void setFid(Long fid) 
    {
        this.fid = fid;
    }

    public Long getFid() 
    {
        return fid;
    }
    public void setUuid(Long uuid) 
    {
        this.uuid = uuid;
    }

    public Long getUuid() 
    {
        return uuid;
    }
    public void setClientType(String clientType) 
    {
        this.clientType = clientType;
    }

    public String getClientType() 
    {
        return clientType;
    }
    public void setAppVersion(String appVersion) 
    {
        this.appVersion = appVersion;
    }

    public String getAppVersion() 
    {
        return appVersion;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setFilePaths(String filePaths)
    {
        this.filePaths = filePaths;
    }

    public String getFilePaths()
    {
        return filePaths;
    }
    public void setIssueTime(String issueTime) 
    {
        this.issueTime = issueTime;
    }

    public String getIssueTime() 
    {
        return issueTime;
    }
    public void setPhoneModel(String phoneModel) 
    {
        this.phoneModel = phoneModel;
    }

    public String getPhoneModel() 
    {
        return phoneModel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fid", getFid())
            .append("uuid", getUuid())
            .append("clientType", getClientType())
            .append("appVersion", getAppVersion())
            .append("content", getContent())
            .append("filePath", getFilePaths())
            .append("issueTime", getIssueTime())
            .append("phoneModel", getPhoneModel())
            .toString();
    }
}
