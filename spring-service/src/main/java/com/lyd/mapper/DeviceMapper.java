package com.lyd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyd.entity.Device;
import com.lyd.svo.DeviceSvo;
import com.lyd.vo.DeviceVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

public interface DeviceMapper extends BaseMapper<Device> {
    Page<DeviceVo> selectWithPage(Page<Device> page, @Param("svo") DeviceSvo svo);
}
