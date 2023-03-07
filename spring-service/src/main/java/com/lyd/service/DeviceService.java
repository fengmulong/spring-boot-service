package com.lyd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyd.entity.Device;
import com.lyd.entity.User;
import com.lyd.svo.DeviceSvo;
import com.lyd.vo.DeviceVo;
import com.lyd.base.BaseService;
import com.lyd.mapper.DeviceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Demo 服务类
 */
@Service
@Transactional
@AllArgsConstructor
public class DeviceService extends BaseService<Device> {

    private final DeviceMapper deviceMapper;
    private final UserService userService;

    public Page<DeviceVo> selectWithPage(DeviceSvo svo) {
        return deviceMapper.selectWithPage(svo.getPage(), svo);
    }

    public DeviceVo getVoById(Integer id) {
        Device device = super.getById(id);
        DeviceVo deviceVo = device.toBean(DeviceVo.class);
        if (device.getMaintUserId() != null) {
            User user = userService.getById(device.getMaintUserId());
            if (user != null) {
                deviceVo.setMaintUserName(user.getName());
            }
        }
        return deviceVo;
    }
}
