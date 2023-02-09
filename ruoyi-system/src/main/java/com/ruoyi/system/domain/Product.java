package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备对象 product
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
public class Product extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long proId;

    /**  */
    @Excel(name = "")
    private String proName;

    /**  */
    @Excel(name = "")
    private String proImg;

    /**  */
    @Excel(name = "")
    private String proListName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProId(Long proId) 
    {
        this.proId = proId;
    }

    public Long getProId() 
    {
        return proId;
    }
    public void setProName(String proName) 
    {
        this.proName = proName;
    }

    public String getProName() 
    {
        return proName;
    }
    public void setProImg(String proImg) 
    {
        this.proImg = proImg;
    }

    public String getProImg() 
    {
        return proImg;
    }
    public void setProListName(String proListName) 
    {
        this.proListName = proListName;
    }

    public String getProListName() 
    {
        return proListName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("proId", getProId())
            .append("proName", getProName())
            .append("proImg", getProImg())
            .append("proListName", getProListName())
            .toString();
    }
}
