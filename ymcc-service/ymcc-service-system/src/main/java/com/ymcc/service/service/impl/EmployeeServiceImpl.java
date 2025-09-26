package com.ymcc.service.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.common.result.PageList;
import com.ymcc.pojo.domain.Employee;
import com.ymcc.pojo.query.EmployeeQuery;
import com.ymcc.service.mapper.EmployeeMapper;
import com.ymcc.service.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Override
    public PageList<Employee> pageQuery(EmployeeQuery query) {
        Page<Employee> employeePage= this.lambdaQuery()
                .like(query.getKeyword()!= null,Employee::getRealName, query.getKeyword())
                .orderBy(query.getSortField()!= null, "asc".equals(query.getSortType()),Employee::getRealName)
                .page(new Page<Employee>(query.getPage(),query.getRows()));
        //结果封装返回
        return new PageList<Employee>(employeePage.getTotal(),employeePage.getRecords());
    }
}
