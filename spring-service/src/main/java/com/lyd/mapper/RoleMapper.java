package com.lyd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyd.entity.Role;
import com.lyd.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    Role getById(@Param("id") Integer id);

    void insertRolePermission(@Param("roleId") Integer roleId, @Param("permissions") List<Permission> permissions);

    void deleteRolePermission(@Param("roleId") Integer roleId);
}
