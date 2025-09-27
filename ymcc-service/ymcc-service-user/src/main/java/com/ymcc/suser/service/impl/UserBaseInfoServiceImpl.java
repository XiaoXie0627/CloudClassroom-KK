package com.ymcc.suser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymcc.pojo.domain.UserBaseInfo;
import com.ymcc.suser.mapper.UserBaseInfoMapper;
import com.ymcc.suser.service.IUserBaseInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员基本信息 服务实现类
 * </p>
 *
 * @author xhh
 * @since 2025-09-27
 */
@Service
public class UserBaseInfoServiceImpl extends ServiceImpl<UserBaseInfoMapper, UserBaseInfo> implements IUserBaseInfoService {

}
