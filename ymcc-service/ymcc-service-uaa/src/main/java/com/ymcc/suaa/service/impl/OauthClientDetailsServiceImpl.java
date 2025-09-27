package com.ymcc.suaa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.OauthClientDetails;
import com.ymcc.suaa.mapper.OauthClientDetailsMapper;
import com.ymcc.suaa.service.IOauthClientDetailsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * oauth2客户端详情配置 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements IOauthClientDetailsService {

}
