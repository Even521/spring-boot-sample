package com.even;

import com.even.system.dto.UserDTO;
import com.even.system.service.IBsRoleService;
import com.even.system.service.IBsUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAdminApplicationTests {
    @Resource
    private IBsUserService iBsUserService;
    @Autowired
    private IBsRoleService iBsRoleService;
    @Test
    public void contextLoads() {
        UserDTO bsUser=iBsUserService.findByUserName("even366@qq.com");

        System.out.println(bsUser.toString());
     /*iBsRoleService.findByUserId(bsUser.getId()).stream().forEach(
             o-> System.out.println(o.toString())
     );*/

    }

}

