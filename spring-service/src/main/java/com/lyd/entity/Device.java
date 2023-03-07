package com.lyd.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lyd.base.BaseLogEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@ApiModel("DemoEntity")
@Getter
@Setter
@Accessors(chain = true)
@TableName("device")
public class Device extends BaseLogEntity {

    @ApiModelProperty("编号")
    private String no;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("型号")
    private String model;

    @ApiModelProperty("维保工，关联用户表id")
    private Integer maintUserId;
}
