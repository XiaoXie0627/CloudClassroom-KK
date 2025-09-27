package com.ymcc.ssystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.common.result.PageList;
import com.ymcc.pojo.domain.Department;
import com.ymcc.pojo.query.DepartmentQuery;
import com.ymcc.ssystem.mapper.DepartmentMapper;
import com.ymcc.ssystem.service.IDepartmentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Override
    public PageList<Department> pageQuery(DepartmentQuery query) {
        //page查询 select * from department where name like %test% limit pagenum,pagesize
        Page<Department> departmentPage = this.lambdaQuery()
                .like(query.getKeyword()!= null,Department::getName, query.getKeyword())
                .orderBy(query.getSortField()!= null, "asc".equals(query.getSortType()),Department::getName)
                .page(new Page<Department>(query.getPage(),query.getRows()));
        //结果封装返回
        return new PageList<Department>(departmentPage.getTotal(),departmentPage.getRecords());
    }
}
