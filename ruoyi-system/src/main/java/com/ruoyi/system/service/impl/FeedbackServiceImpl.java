package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FeedbackMapper;
import com.ruoyi.system.domain.Feedback;
import com.ruoyi.system.service.IFeedbackService;

/**
 * 意见反馈Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-26
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService 
{
    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 查询意见反馈
     * 
     * @param fid 意见反馈主键
     * @return 意见反馈
     */
    @Override
    public Feedback selectFeedbackByFid(Long fid)
    {
        return feedbackMapper.selectFeedbackByFid(fid);
    }

    /**
     * 查询意见反馈列表
     * 
     * @param feedback 意见反馈
     * @return 意见反馈
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback)
    {
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback)
    {
        return feedbackMapper.insertFeedback(feedback);
    }

    /**
     * 修改意见反馈
     * 
     * @param feedback 意见反馈
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback)
    {
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 批量删除意见反馈
     * 
     * @param fids 需要删除的意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByFids(Long[] fids)
    {
        return feedbackMapper.deleteFeedbackByFids(fids);
    }

    /**
     * 删除意见反馈信息
     * 
     * @param fid 意见反馈主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByFid(Long fid)
    {
        return feedbackMapper.deleteFeedbackByFid(fid);
    }
}
