package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserInfo;

/**
 * 用户数据表Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public interface UserInfoMapper 
{
    /**
     * 查询用户数据表
     * 
     * @param pid 用户数据表主键
     * @return 用户数据表
     */
    public UserInfo selectUserInfoByPid(Long pid);

    /**
     * 通过手机号查找用户数据
     * @param phone
     * @return
     */
    public UserInfo selectUserInfoByPhone(String phone);

    /**
     * 通过邮箱查找用户数据
     * @param email
     * @return
     */
    public UserInfo selectUserInfoByEmail(String email);


    /**
     * 查询用户数据表列表
     * 
     * @param userInfo 用户数据表
     * @return 用户数据表集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增用户数据表
     * 
     * @param userInfo 用户数据表
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户数据表
     * 
     * @param userInfo 用户数据表
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户数据表
     * 
     * @param pid 用户数据表主键
     * @return 结果
     */
    public int deleteUserInfoByPid(Long pid);


    public int deleteUserInfoByUuid(Long uuid);

    /**
     * 批量删除用户数据表
     * 
     * @param pids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserInfoByPids(Long[] pids);
}
