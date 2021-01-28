package com.even.user;

import com.even.auth.model.UserRole;
import com.even.auth.model.UserStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:18
 * @describe
 */
@Component
public class UserRepository {
   public static Map<String,Users> map=new ConcurrentHashMap();



    public Users findByUserIdAndState(String userId, UserStatus state){
        Users users = map.get(userId);
        if (users!=null&&users.getState().equals(state)){
            return users;
        }
        return null;
    }
    public Users save(Users users){
        map.put(users.getUserId(),users);
        return users;
    }
}
