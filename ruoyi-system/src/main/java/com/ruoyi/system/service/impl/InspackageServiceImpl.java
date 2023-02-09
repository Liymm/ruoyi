package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.system.dao.InspackageVODao;
import com.ruoyi.system.domain.vo.FileVO;
import com.ruoyi.system.domain.vo.InspackageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.InspackageMapper;
import com.ruoyi.system.domain.Inspackage;
import com.ruoyi.system.service.IInspackageService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@Service
@PropertySource("classpath:/properties/insfile.properties")
public class InspackageServiceImpl implements IInspackageService
{
    //获取配置文件中的配置 为属性动态赋值 注解@Value
    @Value("${insfile.localPathDir}")
    private String localPathDir;  // Windows路径 例如 D:/files
    @Value("${insfile.localUrlPath}")
    private String localUrlPath;  // Linux路径 例如 /Users/zhaoguoxing/Desktop/files

    @Autowired
    private InspackageVODao inspackagevoDao;

    @Autowired
    private InspackageMapper inspackageMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param packageId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Inspackage selectInspackageByPackageId(Long packageId)
    {
        return inspackageMapper.selectInspackageByPackageId(packageId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param inspackage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Inspackage> selectInspackageList(Inspackage inspackage)
    {
        return inspackageMapper.selectInspackageList(inspackage);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param inspackage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertInspackage(Inspackage inspackage)
    {
        return inspackageMapper.insertInspackage(inspackage);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param inspackage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateInspackage(Inspackage inspackage)
    {
        return inspackageMapper.updateInspackage(inspackage);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param packageIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteInspackageByPackageIds(Long[] packageIds)
    {
        return inspackageMapper.deleteInspackageByPackageIds(packageIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param packageId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteInspackageByPackageId(Long packageId)
    {
        return inspackageMapper.deleteInspackageByPackageId(packageId);
    }

    @Override
    public FileVO upload(MultipartFile file) throws IOException {
        //1.1 获取文件名称
        String fileName = file.getOriginalFilename();
        System.out.println("fileName:"+fileName);
        //2. 目录结构
        String datePath =
                new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println("datePath:"+datePath);
        //2.2 最终本地图片存储路径
        String localDir = localPathDir ;
        String realFileName = datePath+"_" + fileName;
        System.out.println("realFileName:"+realFileName);
        //4.最终文件存储的路径+文件名 = /2021/11/11/uuid.pdf
        //可以在这里将路径存储到数据库 实际保存文件地址 此处省略
        String filePathAll = localDir + realFileName;
        System.out.println("filePathAll"+filePathAll);
        //5.实现文件上传
        File realFile = new File(filePathAll);
        file.transferTo(realFile);
        //6.封装FileVO对象  //2021/11/11/uuid.pdf 图片路径 稍后给前台传递
        //我们不可能将filePathAll告诉用户，这样不安全，容易被攻击
        //virtualPath 半个路径，没有具体盘符或根目录 /2021/11/11/uuid.pdf
        String virtualPath = localPathDir+ realFileName;
        System.out.println("virtualPath:"+virtualPath);
        //7.将文件存储路径(半个路径，没有具体盘符或根目录) 和 重命名后的文件名 封装到实体类中

        return new FileVO(virtualPath,fileName);
    }

    @Override
    public int add(InspackageVO ig) {
        System.out.println("ig.getProjectnum():"+ig.getProjectnum());
        System.out.println("ig.getVersionnum():"+ig.getVersionnum());
        System.out.println("ig.getFilename():"+ig.getFilename());
        System.out.println("ig.getVirtualPath():"+ig.getVirtualPath());
        System.out.println("ig.getDescribe():"+ig.getContent());
        System.out.println("ig.getType():"+ig.getType());
        InspackageVO inspackage = new InspackageVO();
        inspackage.setProjectnum(ig.getProjectnum());
        inspackage.setVersionnum(ig.getVersionnum());
        inspackage.setFilename(ig.getFilename());
        inspackage.setVirtualPath(ig.getVirtualPath());
        inspackage.setContent(ig.getContent());
        String type;
        if (ig.getType().equals("1")){
            type="IOS";
        }else {
            type="Android";
        }
        inspackage.setType(type);
        inspackage.setCreatdate(new Date());
        inspackage.setCondition(0);

        inspackagevoDao.save(inspackage);
        System.out.println("projectnum:"+ig.getProjectnum());
        return 0;
    }
}
