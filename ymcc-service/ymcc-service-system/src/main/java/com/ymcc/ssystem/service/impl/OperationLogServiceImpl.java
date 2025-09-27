package com.ymcc.ssystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.OperationLog;
import com.ymcc.ssystem.mapper.OperationLogMapper;
import com.ymcc.ssystem.service.IOperationLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {

}
