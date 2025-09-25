package com.ymcc.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.Employee;
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

}
