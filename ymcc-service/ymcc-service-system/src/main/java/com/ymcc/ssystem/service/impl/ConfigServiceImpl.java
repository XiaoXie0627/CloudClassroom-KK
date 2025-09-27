package com.ymcc.ssystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.Config;
import com.ymcc.ssystem.mapper.ConfigMapper;
import com.ymcc.ssystem.service.IConfigService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-25
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
