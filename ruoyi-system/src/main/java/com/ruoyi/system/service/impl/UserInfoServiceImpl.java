package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserInfoMapper;
import com.ruoyi.system.domain.UserInfo;
import com.ruoyi.system.service.IUserInfoService;

/**
 * 用户数据表Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService 
{
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户数据表
     * 
     * @param pid 用户数据表主键
     * @return 用户数据表
     */
    @Override
    public UserInfo selectUserInfoByPid(Long pid)
    {
        return userInfoMapper.selectUserInfoByPid(pid);
    }

    @Override
    public UserInfo selectUserInfoByPhone(String phone) {
        return userInfoMapper.selectUserInfoByPhone(phone);
    }

    @Override
    public UserInfo selectUserInfoByEmail(String email) {
        return userInfoMapper.selectUserInfoByEmail(email);
    }

    /**
     * 查询用户数据表列表
     * 
     * @param userInfo 用户数据表
     * @return 用户数据表
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo)
    {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增用户数据表
     * 
     * @param userInfo 用户数据表
     * @return 结果
     */
    @Override
    public int insertUserInfo(UserInfo userInfo)
    {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改用户数据表
     * 
     * @param userInfo 用户数据表
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo)
    {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除用户数据表
     * 
     * @param pids 需要删除的用户数据表主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByPids(Long[] pids)
    {

        for (int i=pids.length-1;i>=0;i--){
            UserInfo userInfo = userInfoMapper.selectUserInfoByPid(pids[i]);
            System.out.println("userInfo.getUuid():"+userInfo.getUuid());
            userMapper.deleteUserByUid(userInfo.getUuid());
        }
        return userInfoMapper.deleteUserInfoByPids(pids);
    }

    /**
     * 删除用户数据表信息
     * 
     * @param pid 用户数据表主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByPid(Long pid)
    {
        UserInfo userInfo = userInfoMapper.selectUserInfoByPid(pid);
        System.out.println("userInfo.getUuid():"+userInfo.getUuid());
        userMapper.deleteUserByUid(userInfo.getUuid());

        return userInfoMapper.deleteUserInfoByPid(pid);
    }

    @Override
    public int deleteUserInfoByUuid(Long uuid) {
        return userInfoMapper.deleteUserInfoByUuid(uuid);
    }
}
