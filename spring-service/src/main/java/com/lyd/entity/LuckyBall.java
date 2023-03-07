package com.lyd.entity;
 
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
 
/**
 * (LuckyBall)实体类
 *
 * @author makejava
 * @since 2023-03-07 22:45:55
 */
@Data
@TableName(value = "lucky_ball")
public class LuckyBall {
     
    private Integer id;
     
    private String red1;
     
    private String red2;
     
    private String red3;
     
    private String red4;
     
    private String red5;
     
    private String red6;
     
    private String blue;
     
    private String time;
 
}
