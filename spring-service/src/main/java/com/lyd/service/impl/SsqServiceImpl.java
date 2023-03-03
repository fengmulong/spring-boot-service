package com.lyd.service.impl;
 
import com.lyd.entity.Ssq;
import com.lyd.entity.SsqDTO;
import com.lyd.entity.SsqVO;
import com.lyd.mapper.SsqMapper;
import com.lyd.service.SsqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
 
/**
 * @Author lyd
 * @Desc (Ssq)表服务实现类
 * @Date 2023-03-02 09:42:46
 */
@RequiredArgsConstructor
@Service("ssqService")
public class SsqServiceImpl extends ServiceImpl<SsqMapper, Ssq> implements SsqService {
 
    private final SsqMapper ssqMapper;
 
 
    @Override
    public ResponseEntity<IPage<SsqVO>> queryByPage(SsqDTO param) {
        return ResponseEntity.ok(ssqMapper.queryByPage(param, param));
    }
 
 
    @Override
    public ResponseEntity queryById(Integer id) {
        return ResponseEntity.ok(ssqMapper.queryById(id));
    }
 
 
    @Override
    public ResponseEntity insert(Ssq ssq) {
        int num = ssqMapper.insert(ssq);
        return ResponseEntity.ok(num);
    }
 
 
    @Override
    public ResponseEntity update(Ssq ssq) {
        int num = ssqMapper.update(ssq);
        return ResponseEntity.ok(num);
    }
 
 
    @Override
    public ResponseEntity deleteById(Integer id) {
        int num = ssqMapper.deleteById(id);
        return ResponseEntity.ok(num);
    }
    
}
