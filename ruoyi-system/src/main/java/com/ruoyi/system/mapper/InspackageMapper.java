package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Inspackage;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
public interface InspackageMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param packageId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Inspackage selectInspackageByPackageId(Long packageId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param inspackage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Inspackage> selectInspackageList(Inspackage inspackage);

    /**
     * 新增【请填写功能名称】
     * 
     * @param inspackage 【请填写功能名称】
     * @return 结果
     */
    public int insertInspackage(Inspackage inspackage);

    /**
     * 修改【请填写功能名称】
     * 
     * @param inspackage 【请填写功能名称】
     * @return 结果
     */
    public int updateInspackage(Inspackage inspackage);

    /**
     * 删除【请填写功能名称】
     * 
     * @param packageId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteInspackageByPackageId(Long packageId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param packageIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteInspackageByPackageIds(Long[] packageIds);
}
