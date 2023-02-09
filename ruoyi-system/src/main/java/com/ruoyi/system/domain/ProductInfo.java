package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备详情列表对象 product_info
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
public class ProductInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long ppid;

    /**  */
    @Excel(name = "")
    private String id;

    /**  */
    @Excel(name = "")
    private Long pid;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private String info;

    /**  */
    @Excel(name = "")
    private String img;

    /**  */
    @Excel(name = "")
    private String filterType;

    /**  */
    @Excel(name = "")
    private String filterValue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String deviceAbility;

    public void setPpid(Long ppid) 
    {
        this.ppid = ppid;
    }

    public Long getPpid() 
    {
        return ppid;
    }
    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setFilterType(String filterType) 
    {
        this.filterType = filterType;
    }

    public String getFilterType() 
    {
        return filterType;
    }
    public void setFilterValue(String filterValue) 
    {
        this.filterValue = filterValue;
    }

    public String getFilterValue() 
    {
        return filterValue;
    }
    public void setDeviceAbility(String deviceAbility) 
    {
        this.deviceAbility = deviceAbility;
    }

    public String getDeviceAbility() 
    {
        return deviceAbility;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ppid", getPpid())
            .append("id", getId())
            .append("pid", getPid())
            .append("name", getName())
            .append("info", getInfo())
            .append("img", getImg())
            .append("filterType", getFilterType())
            .append("filterValue", getFilterValue())
            .append("deviceAbility", getDeviceAbility())
            .toString();
    }
}
