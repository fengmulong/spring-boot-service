package com.lyd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyd.entity.Role;
import com.lyd.entity.User;
import com.lyd.svo.UserSvo;
import com.lyd.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    Page<UserVo> selectWithPage(Page<UserVo> page, @Param("svo") UserSvo svo);

    UserVo getVoById(@Param("id") Integer id);

    void insertUserRole(@Param("userId") Integer userId, @Param("roles") List<Role> roles);

    void deleteUserRole(@Param("userId") Integer userId);
}
