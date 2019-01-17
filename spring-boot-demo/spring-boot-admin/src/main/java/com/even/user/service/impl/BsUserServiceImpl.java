package com.even.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.even.common.validation.AssertUtil;
import com.even.common.validation.ValidationUtil;
import com.even.user.dto.UserDTO;
import com.even.user.entity.BsUser;
import com.even.user.mapper.BsUserMapper;
import com.even.user.service.IBsUserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.ValidationUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BsUserServiceImpl extends ServiceImpl<BsUserMapper, BsUser> implements IBsUserService {

    @Override
    public BsUser findByName(String name) throws UsernameNotFoundException {
        LambdaQueryWrapper<BsUser> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(ValidationUtil.isEmail(name)){
            lambdaQueryWrapper.eq(BsUser::getEmail,name);
        }else {
            lambdaQueryWrapper.eq(BsUser::getUserName,name);
        }
        return this.baseMapper.selectOne(lambdaQueryWrapper);
    }

    @Override
    public boolean isNotExit(String name) {
        BsUser bsUser= this.findByName(name);
        return bsUser==null?true:false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserDTO createUser(BsUser user) {
        AssertUtil.success(this.isNotExit(user.getUserName()),user.getUserName()+" 用户已经存在");


        return null;
    }
}
