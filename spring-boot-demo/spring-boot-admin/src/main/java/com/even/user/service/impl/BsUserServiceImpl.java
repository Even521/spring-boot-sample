package com.even.user.service.impl;

import com.even.user.entity.BsUser;
import com.even.user.mapper.BsUserMapper;
import com.even.user.service.IBsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
@Service
public class BsUserServiceImpl extends ServiceImpl<BsUserMapper, BsUser> implements IBsUserService {

}
