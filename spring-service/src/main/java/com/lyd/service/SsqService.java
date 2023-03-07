package com.lyd.service;
 
import com.lyd.entity.Ssq;
import com.lyd.entity.SsqDTO;
import com.lyd.entity.SsqVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
 
/**
 * @Author lyd
 * @Desc (Ssq)表服务接口
 * @Date 2023-03-02 09:42:46
 */
public interface SsqService extends IService<Ssq> {
 
    /**
     * 分页查询
     */
    ResponseEntity<IPage<SsqVO>> queryByPage(SsqDTO param);
 
    /**
     * 根据ID查详情
     */
    ResponseEntity queryById(Integer id);
    
    /**
     * 新增数据
     */
    ResponseEntity insert(Ssq ssq);
 
    /**
     * 修改数据
     */
    ResponseEntity update(Ssq ssq);
 
    /**
     * 通过主键删除数据
     */
    ResponseEntity deleteById(Integer id);
 
}
