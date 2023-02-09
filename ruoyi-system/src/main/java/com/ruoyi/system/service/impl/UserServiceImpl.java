package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.domain.User;
import com.ruoyi.system.service.IUserService;

/**
 * 用户信息详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
@Service
public class UserServiceImpl implements IUserService 
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户信息详情
     * 
     * @param uid 用户信息详情主键
     * @return 用户信息详情
     */
    @Override
    public User selectUserByUid(Long uid)
    {
        return userMapper.selectUserByUid(uid);
    }

    /**
     * 查询用户信息详情列表
     * 
     * @param user 用户信息详情
     * @return 用户信息详情
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户信息详情
     * 
     * @param user 用户信息详情
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户信息详情
     * 
     * @param user 用户信息详情
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户信息详情
     * 
     * @param uids 需要删除的用户信息详情主键
     * @return 结果
     */
    @Override
    public int deleteUserByUids(Long[] uids)
    {
        return userMapper.deleteUserByUids(uids);
    }

    /**
     * 删除用户信息详情信息
     * 
     * @param uid 用户信息详情主键
     * @return 结果
     */
    @Override
    public int deleteUserByUid(Long uid)
    {
        return userMapper.deleteUserByUid(uid);
    }
}
