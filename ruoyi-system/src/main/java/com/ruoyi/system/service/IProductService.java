package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Product;

/**
 * 设备Service接口
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
public interface IProductService 
{
    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    public Product selectProductById(Long id);

    /**
     * 查询设备列表
     * 
     * @param product 设备
     * @return 设备集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * 新增设备
     * 
     * @param product 设备
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改设备
     * 
     * @param product 设备
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的设备主键集合
     * @return 结果
     */
    public int deleteProductByIds(Long[] ids);

    /**
     * 删除设备信息
     * 
     * @param id 设备主键
     * @return 结果
     */
    public int deleteProductById(Long id);
}
