package com.lyd.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lyd.entity.Dept;
import com.lyd.exception.MyException;
import com.lyd.vo.TreeNode;
import com.lyd.base.BaseService;
import com.lyd.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门 服务类
 */
@Service
@Transactional
public class DeptService extends BaseService<Dept> {

    public List<TreeNode> selectAll() {
        List<Dept> depts = super.list();
        //转化为TreeNodeList
        List<TreeNode> treeNodes = depts.stream().map(item -> new TreeNode(item.getId(), item.getParentId(), item.getName(), item)).collect(Collectors.toList());
        //转化为树
        return CommonUtil.listToTree(treeNodes);
    }

    public void deleteById(int id) {
        int childrenCount = super.count(new LambdaQueryWrapper<Dept>().eq(Dept::getParentId, id));
        if (childrenCount > 0) {
            throw new MyException("该部门有下级部门，无法删除");
        }
        super.removeById(id);
    }
}
