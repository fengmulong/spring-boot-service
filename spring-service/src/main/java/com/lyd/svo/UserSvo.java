package com.lyd.svo;

import com.lyd.base.BaseSvo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSvo extends BaseSvo {

    @ApiModelProperty("搜索-手机号")
    private String phone;

    @ApiModelProperty("搜索-用户姓名")
    private String name;
}
