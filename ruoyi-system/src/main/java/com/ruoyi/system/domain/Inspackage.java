package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 inspackage
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public class Inspackage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long packageId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String projectNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String versionNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fileName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String virtualPath;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date creatDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long conditionNum;

    public void setPackageId(Long packageId) 
    {
        this.packageId = packageId;
    }

    public Long getPackageId() 
    {
        return packageId;
    }
    public void setProjectNum(String projectNum) 
    {
        this.projectNum = projectNum;
    }

    public String getProjectNum() 
    {
        return projectNum;
    }
    public void setVersionNum(String versionNum) 
    {
        this.versionNum = versionNum;
    }

    public String getVersionNum() 
    {
        return versionNum;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setVirtualPath(String virtualPath) 
    {
        this.virtualPath = virtualPath;
    }

    public String getVirtualPath() 
    {
        return virtualPath;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setCreatDate(Date creatDate) 
    {
        this.creatDate = creatDate;
    }

    public Date getCreatDate() 
    {
        return creatDate;
    }
    public void setConditionNum(Long conditionNum) 
    {
        this.conditionNum = conditionNum;
    }

    public Long getConditionNum() 
    {
        return conditionNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("packageId", getPackageId())
            .append("projectNum", getProjectNum())
            .append("versionNum", getVersionNum())
            .append("fileName", getFileName())
            .append("virtualPath", getVirtualPath())
            .append("content", getContent())
            .append("type", getType())
            .append("creatDate", getCreatDate())
            .append("conditionNum", getConditionNum())
            .toString();
    }
}
