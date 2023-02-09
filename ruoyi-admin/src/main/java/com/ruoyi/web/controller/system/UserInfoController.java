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
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户数据表Controller
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@RestController
@RequestMapping("/system/user_info")
public class UserInfoController extends BaseController
{
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 查询用户数据表列表
     */
    @GetMapping("hello")
    public String hello(){
        return "OK";
    }
    @PreAuthorize("@ss.hasPermi('system:user_info:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserInfo userInfo)
    {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户数据表列表
     */
    @PreAuthorize("@ss.hasPermi('system:user_info:export')")
    @Log(title = "用户数据表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserInfo userInfo)
    {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        util.exportExcel(response, list, "用户数据表数据");
    }

    /**
     * 获取用户数据表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user_info:query')")
    @GetMapping(value = "/{pid}")
    public AjaxResult getInfo(@PathVariable("pid") Long pid)
    {
        return AjaxResult.success(userInfoService.selectUserInfoByPid(pid));
    }

    /**
     * 新增用户数据表
     */
    @PreAuthorize("@ss.hasPermi('system:user_info:add')")
    @Log(title = "用户数据表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改用户数据表
     */
    @PreAuthorize("@ss.hasPermi('system:user_info:edit')")
    @Log(title = "用户数据表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserInfo userInfo)
    {
        return toAjax(userInfoService.updateUserInfo(userInfo));
    }


    /**
     * 删除用户数据表
     */
    @PreAuthorize("@ss.hasPermi('system:user_info:remove')")
    @Log(title = "用户数据表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pids}")
    public AjaxResult remove(@PathVariable Long[] pids)
    {
        return toAjax(userInfoService.deleteUserInfoByPids(pids));
    }
}
