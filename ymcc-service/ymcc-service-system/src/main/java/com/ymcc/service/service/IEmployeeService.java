package com.ymcc.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymcc.common.result.PageList;
import com.ymcc.pojo.domain.Employee;
import com.ymcc.pojo.query.EmployeeQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
public interface IEmployeeService extends IService<Employee> {

    PageList<Employee> pageQuery(EmployeeQuery query);
}
