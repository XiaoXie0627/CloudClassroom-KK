package com.ymcc.service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymcc.common.result.PageList;
import com.ymcc.pojo.domain.Department;
import com.ymcc.pojo.query.DepartmentQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
public interface IDepartmentService extends IService<Department> {
    /**
     * 分页查询
     * @param query 查询条件和参数
     * @return
     */
    PageList<Department> pageQuery(DepartmentQuery query);
}
