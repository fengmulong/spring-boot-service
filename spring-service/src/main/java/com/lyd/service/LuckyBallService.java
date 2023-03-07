package com.lyd.service;
 
import com.lyd.entity.LuckyBall;
import com.lyd.entity.LuckyBallDTO;
import com.lyd.entity.LuckyBallVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyd.base.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
 
/**
 * @Author makejava
 * @Desc (LuckyBall)表服务接口
 * @Date 2023-03-07 22:45:55
 */
public interface LuckyBallService extends IService<LuckyBall> {
 
    /**
     * 分页查询
     */
    R<IPage<LuckyBallVO>> queryByPage(LuckyBallDTO param);
 
    /**
     * 根据ID查详情
     */
    R queryById(Integer id);
    
    /**
     * 新增数据
     */
    R insert(LuckyBall luckyBall);

    void getAllData(String dateNum);
 
    /**
     * 修改数据
     */
    R update(LuckyBall luckyBall);
 
    /**
     * 通过主键删除数据
     */
    R deleteById(Integer id);
 
}
