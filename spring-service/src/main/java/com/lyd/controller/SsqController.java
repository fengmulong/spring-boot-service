package com.lyd.controller;
 
import com.lyd.entity.Ssq;
import com.lyd.entity.SsqVO;
import com.lyd.entity.SsqDTO;
import com.lyd.service.SsqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import java.util.Objects;
 
/**
 * @Author lyd
 * @Desc (Ssq)表控制层
 * @Date 2023-03-02 09:42:46
 */
@Api(tags = "")
@RestController
@RequestMapping("ssq")
@RequiredArgsConstructor
public class SsqController {

    @Autowired
    private final SsqService ssqService;
 
 
    @ApiOperation("-分页查询")
    @PostMapping("/queryByPage")
    public ResponseEntity<IPage<SsqVO>> queryByPage(@RequestBody SsqDTO param) {
        return ssqService.queryByPage(param);
    }
    
 
    @ApiOperation("-根据ID查详情")
    @PostMapping("/queryById")
    public ResponseEntity<SsqVO> queryById(@RequestBody SsqDTO param) {
        return ssqService.queryById(param.getId());
    }
 
 
    @ApiOperation("-新增数据")
    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Ssq param) {
        return ssqService.insert(param);
    }
 
 
    @ApiOperation("-编辑数据")
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Ssq param) {
         if(Objects.isNull(param.getId())){
            return ResponseEntity.notFound().build();
        }
        return ssqService.update(param);
    }
 
 
    @ApiOperation("-删除数据")
    @PostMapping("/deleteById")
    public ResponseEntity deleteById(@RequestBody SsqDTO param) {
        return ssqService.deleteById(param.getId());
    }
 
}
