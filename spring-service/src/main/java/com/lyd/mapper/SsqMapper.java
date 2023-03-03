package com.lyd.mapper;
 
import com.lyd.entity.Ssq;
import com.lyd.entity.SsqVO;
import com.lyd.entity.SsqDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
 
/**
 * @Author lyd  
 * @Desc (Ssq)表数据库访问层
 * @Date 2023-03-02 09:42:46
 */
public interface SsqMapper extends BaseMapper<Ssq> {
 
    /**
     * 分页查询
     */
    IPage<SsqVO> queryByPage(Page page, @Param("param") SsqDTO param);
 
 
    /**
     * 根据ID查详情
     */
    SsqVO queryById(Integer id);
 
 
    /**
     * 新增数据
     */
    int insertOne(Ssq ssq);
 /**
     * 新增实体属性不为null的数据,进数据库里
     * ps:
     *      单条数的插入
     * @param ssq
     * @return
     */
    int insertSelect(Ssq ssq);
   /**
     * 批量新增所有列，列表长度不能为0，且列表id统一为null或者统一不为null-
     * ps:
     *      多条数据的插入
     *      缺点:
     *      数据量大的话拼接成一条sql语句,会出现就会很长,导致执行数据库差
     *      列如:1,2,3,,4,5拼接成一条sql的insert执行
     * @param list
     * @return
     */
 
    int insertBatch(List<Ssq> list);
 
    /**
     * 修改数据
     */
    int update(Ssq ssq);
 
    /**
     * 通过主键删除数据
     */
    int deleteById(Integer id);
 
}
