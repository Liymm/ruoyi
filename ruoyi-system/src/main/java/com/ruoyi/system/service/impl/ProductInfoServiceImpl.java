package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProductInfoMapper;
import com.ruoyi.system.domain.ProductInfo;
import com.ruoyi.system.service.IProductInfoService;

/**
 * 设备详情列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
@Service
public class ProductInfoServiceImpl implements IProductInfoService 
{
    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 查询设备详情列表
     * 
     * @param ppid 设备详情列表主键
     * @return 设备详情列表
     */
    @Override
    public ProductInfo selectProductInfoByPpid(Long ppid)
    {
        return productInfoMapper.selectProductInfoByPpid(ppid);
    }

    /**
     * 查询设备详情列表列表
     * 
     * @param productInfo 设备详情列表
     * @return 设备详情列表
     */
    @Override
    public List<ProductInfo> selectProductInfoList(ProductInfo productInfo)
    {
        return productInfoMapper.selectProductInfoList(productInfo);
    }

    /**
     * 新增设备详情列表
     * 
     * @param productInfo 设备详情列表
     * @return 结果
     */
    @Override
    public int insertProductInfo(ProductInfo productInfo)
    {
        return productInfoMapper.insertProductInfo(productInfo);
    }

    /**
     * 修改设备详情列表
     * 
     * @param productInfo 设备详情列表
     * @return 结果
     */
    @Override
    public int updateProductInfo(ProductInfo productInfo)
    {
        return productInfoMapper.updateProductInfo(productInfo);
    }

    /**
     * 批量删除设备详情列表
     * 
     * @param ppids 需要删除的设备详情列表主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoByPpids(Long[] ppids)
    {
        return productInfoMapper.deleteProductInfoByPpids(ppids);
    }

    /**
     * 删除设备详情列表信息
     * 
     * @param ppid 设备详情列表主键
     * @return 结果
     */
    @Override
    public int deleteProductInfoByPpid(Long ppid)
    {
        return productInfoMapper.deleteProductInfoByPpid(ppid);
    }
}
