package com.lyd.entity;
 
import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
 
/**
 * (Ssq)实体类
 *
 * @author lyd
 * @since 2023-03-02 09:42:46
 */
@Data
@TableName(value = "ssq")
public class Ssq {
     
    private Integer id;
     
    private Integer numRed1;
     
    private Integer numRed2;
     
    private Integer numRed3;
     
    private Integer numRed4;
     
    private Integer numRed5;
     
    private Integer numRed6;
     
    private Integer numBlue;
     
    private String createUser;
     
    private Date createTime;
     
    private String status;
 
}
