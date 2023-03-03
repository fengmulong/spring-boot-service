package com.lyd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyd.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface PermissionMapper extends BaseMapper<Permission> {

    Set<String> selectByUserId(@Param("userId") Integer userId);
}
