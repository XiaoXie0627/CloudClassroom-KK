package com.ymcc.suaa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.Permission;
import com.ymcc.suaa.mapper.PermissionMapper;
import com.ymcc.suaa.service.IPermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
