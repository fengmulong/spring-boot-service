package com.lyd.mapper;
 
import com.lyd.entity.LuckyBall;
import com.lyd.entity.LuckyBallVO;
import com.lyd.entity.LuckyBallDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
 
/**
 * @Author makejava  
 * @Desc (LuckyBall)表数据库访问层
 * @Date 2023-03-07 23:43:02
 */
@Mapper
public interface LuckyBallMapper extends BaseMapper<LuckyBall> {
 
    /**
     * 分页查询
     */
    IPage<LuckyBallVO> queryByPage(Page page, @Param("param") LuckyBallDTO param);
 
 
    /**
     * 根据ID查详情
     */
    LuckyBallVO queryById(Integer id);
 
 
    /**
     * 新增数据
     */
    int insert(LuckyBall luckyBall);
 
 
    /**
     * 修改数据
     */
    int update(LuckyBall luckyBall);
 
    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);
 
}
