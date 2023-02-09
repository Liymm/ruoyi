package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.User;

/**
 * 用户信息详情Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-07
 */
public interface UserMapper 
{
    /**
     * 查询用户信息详情
     * 
     * @param uid 用户信息详情主键
     * @return 用户信息详情
     */
    public User selectUserByUid(Long uid);

    /**
     * 查询用户信息详情列表
     * 
     * @param user 用户信息详情
     * @return 用户信息详情集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户信息详情
     * 
     * @param user 用户信息详情
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户信息详情
     * 
     * @param user 用户信息详情
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户信息详情
     * 
     * @param uid 用户信息详情主键
     * @return 结果
     */
    public int deleteUserByUid(Long uid);

    /**
     * 批量删除用户信息详情
     * 
     * @param uids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByUids(Long[] uids);
}
