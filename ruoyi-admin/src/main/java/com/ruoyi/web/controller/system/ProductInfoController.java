package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ProductInfo;
import com.ruoyi.system.service.IProductInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设备详情列表Controller
 * 
 * @author ruoyi
 * @date 2022-10-27
 */
@RestController
@RequestMapping("/system/product_info")
public class ProductInfoController extends BaseController
{
    @Autowired
    private IProductInfoService productInfoService;

    /**
     * 查询设备详情列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProductInfo productInfo)
    {
        startPage();
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备详情列表列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_info:export')")
    @Log(title = "设备详情列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductInfo productInfo)
    {
        List<ProductInfo> list = productInfoService.selectProductInfoList(productInfo);
        ExcelUtil<ProductInfo> util = new ExcelUtil<ProductInfo>(ProductInfo.class);
        util.exportExcel(response, list, "设备详情列表数据");
    }

    /**
     * 获取设备详情列表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:product_info:query')")
    @GetMapping(value = "/{ppid}")
    public AjaxResult getInfo(@PathVariable("ppid") Long ppid)
    {
        return AjaxResult.success(productInfoService.selectProductInfoByPpid(ppid));
    }

    /**
     * 新增设备详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_info:add')")
    @Log(title = "设备详情列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductInfo productInfo)
    {
        return toAjax(productInfoService.insertProductInfo(productInfo));
    }

    /**
     * 修改设备详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_info:edit')")
    @Log(title = "设备详情列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductInfo productInfo)
    {
        return toAjax(productInfoService.updateProductInfo(productInfo));
    }

    /**
     * 删除设备详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:product_info:remove')")
    @Log(title = "设备详情列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ppids}")
    public AjaxResult remove(@PathVariable Long[] ppids)
    {
        return toAjax(productInfoService.deleteProductInfoByPpids(ppids));
    }
}
