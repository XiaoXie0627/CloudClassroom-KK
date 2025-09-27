package com.ymcc.suaa.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.OauthCode;
import com.ymcc.suaa.mapper.OauthCodeMapper;
import com.ymcc.suaa.service.IOauthCodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 授权码 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class OauthCodeServiceImpl extends ServiceImpl<OauthCodeMapper, OauthCode> implements IOauthCodeService {

}
