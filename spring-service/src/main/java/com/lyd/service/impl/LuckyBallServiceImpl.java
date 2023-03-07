package com.lyd.service.impl;
 
import com.lyd.entity.LuckyBall;
import com.lyd.entity.LuckyBallDTO;
import com.lyd.entity.LuckyBallVO;
import com.lyd.mapper.LuckyBallMapper;
import com.lyd.service.LuckyBallService;
import com.lyd.util.SSQUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lyd.base.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Author makejava
 * @Desc (LuckyBall)表服务实现类
 * @Date 2023-03-07 22:45:56
 */
@RequiredArgsConstructor
@Service("luckyBallService")
public class LuckyBallServiceImpl extends ServiceImpl<LuckyBallMapper, LuckyBall> implements LuckyBallService {

    @Autowired
    private final LuckyBallMapper luckyBallMapper;
 
 
    @Override
    public R<IPage<LuckyBallVO>> queryByPage(LuckyBallDTO param) {
        return R.ok(luckyBallMapper.queryByPage(param, param));
    }
 
 
    @Override
    public R queryById(Integer id) {
        return R.ok(luckyBallMapper.queryById(id));
    }
 
 
    @Override
    public R insert(LuckyBall luckyBall) {
        int num = luckyBallMapper.insert(luckyBall);
        return R.ok(num);
    }

    @Override
    public void getAllData(String dateNum) {
        SSQUtils ssqUtils=new SSQUtils();
        List<LuckyBall> luckyBalls=ssqUtils.historyList(dateNum);
        for(LuckyBall luckyBall:luckyBalls){
            luckyBallMapper.insert(luckyBall);
        }
    }


 
    @Override
    public R update(LuckyBall luckyBall) {
        int num = luckyBallMapper.update(luckyBall);
        return R.ok(num);
    }
 
 
    @Override
    public R deleteById(Integer id) {
        int num = luckyBallMapper.deleteById(id);
        return R.ok(num);
    }
    
}
