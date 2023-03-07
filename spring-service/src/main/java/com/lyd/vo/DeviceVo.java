package com.lyd.vo;

import com.lyd.entity.Device;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceVo extends Device {

    @ApiModelProperty("维保工名字")
    private String maintUserName;
}
