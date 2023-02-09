package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ProductInfo;

/**
 * 设备详情列表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
public interface ProductInfoMapper 
{
    /**
     * 查询设备详情列表
     * 
     * @param ppid 设备详情列表主键
     * @return 设备详情列表
     */
    public ProductInfo selectProductInfoByPpid(Long ppid);

    /**
     * 查询设备详情列表列表
     * 
     * @param productInfo 设备详情列表
     * @return 设备详情列表集合
     */
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo);

    /**
     * 新增设备详情列表
     * 
     * @param productInfo 设备详情列表
     * @return 结果
     */
    public int insertProductInfo(ProductInfo productInfo);

    /**
     * 修改设备详情列表
     * 
     * @param productInfo 设备详情列表
     * @return 结果
     */
    public int updateProductInfo(ProductInfo productInfo);

    /**
     * 删除设备详情列表
     * 
     * @param ppid 设备详情列表主键
     * @return 结果
     */
    public int deleteProductInfoByPpid(Long ppid);

    /**
     * 批量删除设备详情列表
     * 
     * @param ppids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductInfoByPpids(Long[] ppids);
}
