package com.ruoyi.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: MM
 * @date: 2022-06-15 15:41
 */
@Entity
@Table(name = "inspackage")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class InspackageVO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="package_id")
    private int pkid;

    //项目号
    @Column(name = "project_num")
    private String projectnum;

    //版本号
    @Column(name = "version_num")
    private String versionnum;

    //安装包名字
    @Column(name = "file_name")
    private String filename;

    //安装包路径
    @Column(name = "virtual_path")
    private String virtualPath;

    //描述
    @Column(name = "content")
    private String content;

    //类型
    @Column(name = "type")
    private String type;

    //创建日期
    @Column(name = "creat_date")
    private Date creatdate;

    //条件
    @Column(name = "condition_num")
    private int condition;

    public InspackageVO(String virtualPath, String fileName) {
    }




    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getVirtualPath() {
        return virtualPath;
    }

    public void setVirtualPath(String virtualPath) {
        this.virtualPath = virtualPath;
    }

    public String getProjectnum() {
        return projectnum;
    }

    public void setProjectnum(String projectnum) {
        this.projectnum = projectnum;
    }

    public String getVersionnum() {
        return versionnum;
    }

    public void setVersionnum(String versionnum) {
        this.versionnum = versionnum;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
