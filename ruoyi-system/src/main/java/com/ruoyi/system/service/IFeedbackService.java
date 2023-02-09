package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Feedback;

/**
 * 意见反馈Service接口
 * 
 * @author ruoyi
 * @date 2022-10-26
 */
public interface IFeedbackService 
{
    /**
     * 查询意见反馈
     * 
     * @param fid 意见反馈主键
     * @return 意见反馈
     */
    public Feedback selectFeedbackByFid(Long fid);

    /**
     * 查询意见反馈列表
     * 
     * @param feedback 意见反馈
     * @return 意见反馈集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 批量删除意见反馈
     * 
     * @param fids 需要删除的意见反馈主键集合
     * @return 结果
     */
    public int deleteFeedbackByFids(Long[] fids);

    /**
     * 删除意见反馈信息
     * 
     * @param fid 意见反馈主键
     * @return 结果
     */
    public int deleteFeedbackByFid(Long fid);
}
