package com.lyd.entity;
 
import java.util.Date;
import lombok.Data;
 
/**
 * (Ssq)VO类
 *
 * @author lyd
 * @since 2023-03-02 09:42:49
 */
@Data
public class SsqVO {
     
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
