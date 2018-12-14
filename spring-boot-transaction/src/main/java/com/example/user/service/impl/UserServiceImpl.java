package com.example.user.service.impl;

import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author even
 * @since 2018-12-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean saveUser() throws Exception {
        boolean success=this.insertUser(new User(null,"even","123"));
        boolean s=this.insertUser(new User(null,"even1","1234"));
        return true;
    }

    /**
     * 插入一个用户
     * @return
     */

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.MANDATORY )
    public boolean insertUser(User user) throws Exception{
      if(user.getUserName().equals("even1")){
           throw new Exception("insert user failed");
       }
        return this.baseMapper.insert(user)>0?true:false;
    }

}
