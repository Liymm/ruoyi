package com.ruoyi.web.controller.system;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.vo.FileVO;
import com.ruoyi.system.domain.vo.InspackageVO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Inspackage;
import com.ruoyi.system.service.IInspackageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-09-02
 */
@RestController
@RequestMapping("/system/inspackage")
public class InspackageController extends BaseController
{
    @Autowired
    private IInspackageService inspackageService;


    @PostMapping("/Fileadd")
    @ResponseBody
    public String Fileadd(@RequestBody Map<String,String> params)  {
        System.out.println("params:"+params);
        InspackageVO inspackagevo = JSONObject.parseObject(JSONObject.toJSONString(params), InspackageVO.class);
        System.out.println("===程序在执行===");
        inspackageService.add(inspackagevo);
        return "OK";
//        return new RespBean(ResponseStatus.OK);
    }

    @PostMapping("/upload")
    public FileVO upload(MultipartFile file) throws IOException {

        //调用service中的业务方法
        FileVO fileVO = inspackageService.upload(file);
        System.out.println("fileVO:"+fileVO);
        return fileVO;
    }


    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:inspackage:list')")
    @GetMapping("/list")
    public TableDataInfo list(Inspackage inspackage)
    {
        startPage();
        List<Inspackage> list = inspackageService.selectInspackageList(inspackage);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:inspackage:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Inspackage inspackage)
    {
        List<Inspackage> list = inspackageService.selectInspackageList(inspackage);
        ExcelUtil<Inspackage> util = new ExcelUtil<Inspackage>(Inspackage.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:inspackage:query')")
    @GetMapping(value = "/{packageId}")
    public AjaxResult getInfo(@PathVariable("packageId") Long packageId)
    {
        return AjaxResult.success(inspackageService.selectInspackageByPackageId(packageId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:inspackage:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Inspackage inspackage)
    {
        return toAjax(inspackageService.insertInspackage(inspackage));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:inspackage:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Inspackage inspackage)
    {
        return toAjax(inspackageService.updateInspackage(inspackage));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:inspackage:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{packageIds}")
    public AjaxResult remove(@PathVariable Long[] packageIds)
    {
        return toAjax(inspackageService.deleteInspackageByPackageIds(packageIds));
    }
}
