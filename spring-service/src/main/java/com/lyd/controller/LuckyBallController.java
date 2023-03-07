package com.lyd.controller;
 
import com.lyd.config.annotation.NoAuth;
import com.lyd.entity.LuckyBall;
import com.lyd.entity.LuckyBallVO;
import com.lyd.entity.LuckyBallDTO;
import com.lyd.service.LuckyBallService;
import com.lyd.util.SSQUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lyd.base.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
 
/**
 * @Author makejava
 * @Desc (LuckyBall)表控制层
 * @Date 2023-03-07 22:46:49
 */
@Api(tags = "")
@RestController
@RequestMapping("luckyBall")
@RequiredArgsConstructor
public class LuckyBallController {
 
    private final LuckyBallService luckyBallService;
 
 
    @ApiOperation("-分页查询")
    @PostMapping("/queryByPage")
    public R<IPage<LuckyBallVO>> queryByPage(@RequestBody LuckyBallDTO param) {
        return luckyBallService.queryByPage(param);
    }
    
 
    @ApiOperation("-根据ID查详情")
    @PostMapping("/queryById")
    public R<LuckyBallVO> queryById(@RequestBody LuckyBallDTO param) {
        return luckyBallService.queryById(param.getId());
    }
 
 
    @ApiOperation("-新增数据")
    @PostMapping("/insert")
    public R insert(@RequestBody LuckyBall param) {
        return luckyBallService.insert(param);
    }

    @ApiOperation("-获取所有双色球数据")
    @GetMapping("/getAllData")
    @NoAuth
    public void getAllData() {
         luckyBallService.getAllData("23025");
    }
 
 
    @ApiOperation("-编辑数据")
    @PostMapping("/update")
    public R update(@RequestBody LuckyBall param) {
        if(Objects.isNull(param.getId())){
            return R.failed("ID不能为空");
        }
        return luckyBallService.update(param);
    }
 
 
    @ApiOperation("-删除数据")
    @PostMapping("/deleteById")
    public R deleteById(@RequestBody LuckyBallDTO param) {
        return luckyBallService.deleteById(param.getId());
    }
 
}
