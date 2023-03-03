package com.lyd.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyd.base.BaseSvo;
import com.lyd.entity.Role;
import com.lyd.config.annotation.Auth;
import com.lyd.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色")
@AllArgsConstructor
@RestController
@RequestMapping("roles")
public class RoleController {

    private final RoleService roleService;

    @Auth("role:query")
    @ApiOperation("获取列表")
    @GetMapping
    public IPage<Role> findWithPage(BaseSvo svo) {
        return roleService.page(new Page<>(svo.getPageNum(), svo.getPageSize()));
    }

    @Auth("role:query")
    @ApiOperation("获取全部列表")
    @GetMapping("all")
    public List<Role> selectAll() {
        return roleService.list();
    }

    @Auth("role:query")
    @ApiOperation("获取详情")
    @GetMapping("{id}")
    public Role selectById(@PathVariable Integer id) {
        return roleService.selectById(id);
    }

    @Auth("role:edit")
    @ApiOperation("创建")
    @PostMapping
    public void insert(@RequestBody Role role) {
        roleService.insertRole(role);
    }

    @Auth("role:edit")
    @ApiOperation("编辑")
    @PutMapping
    public void updateByPrimaryKey(@RequestBody Role role) {
        roleService.updateRole(role);
    }

    @Auth("role:edit")
    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public void deleteByPrimaryKey(@PathVariable Integer id) {
        roleService.deleteRole(id);
    }
}
