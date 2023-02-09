package com.ruoyi.system.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ProductMapper;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IProductService;

/**
 * 设备Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-06
 */
@Service
public class ProductServiceImpl implements IProductService 
{
    @Autowired
    private ProductMapper productMapper;

    @Value("${ruoyi.profile}")
    private String filePath;
    /**
     * 查询设备
     * 
     * @param id 设备主键
     * @return 设备
     */
    @Override
    public Product selectProductById(Long id)
    {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询设备列表
     * 
     * @param product 设备
     * @return 设备
     */
    @Override
    public List<Product> selectProductList(Product product)
    {
        return productMapper.selectProductList(product);
    }

    /**
     * 新增设备
     * 
     * @param product 设备
     * @return 结果
     */
    @Override
    public int insertProduct(Product product)
    {
        return productMapper.insertProduct(product);
    }

    /**
     * 修改设备
     * 
     * @param product 设备
     * @return 结果
     */
    @Override
    public int updateProduct(Product product)
    {
        delectFile(product.getId());
        return productMapper.updateProduct(product);
    }

    /**
     * 批量删除设备
     * 
     * @param ids 需要删除的设备主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids)
    {
        for (int i=ids.length-1;i>=0;i--){
            delectFile(ids[i]);
        }
        return productMapper.deleteProductByIds(ids);
    }

    /**
     * 删除设备信息
     * 
     * @param id 设备主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id)
    {
        delectFile(id);
        return productMapper.deleteProductById(id);
    }


    private void delectFile(Long id){
        Product p = productMapper.selectProductById(id);
        System.out.println("id:"+id);
        String proImg = p.getProImg();
        String[] split = proImg.split("/");
        Map<Integer, String> map=new HashMap<>();
        for (int i=split.length-1;i>=0;i--){
            String trim = split[i].trim();
            map.put(i,trim);
        }
        String s1 = map.get(3);
        System.out.println("s1:"+s1);
        String s2 = map.get(2);
        String fileName=filePath+"/"+s2+"/"+s1;

        boolean running=false;
        if (!running){
            System.out.println("删除图片开始!路径为:"+fileName);
            File fl=new File(fileName);
            if (fl.exists()==true){
                System.out.println("图片存在，可执行删除！");
                Boolean flag=false;
                flag=fl.delete();
                if (flag){
                    System.out.println("成功删除图片"+fl.getName());
                }else {
                    System.out.println("删除失败");
                }
            }
        }
    }
}
