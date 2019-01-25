package com.even;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.even.common.result.ResultUtils;
import com.even.system.dto.UserDTO;
import com.even.system.service.IBsMenuService;
import com.even.system.service.IBsRoleService;
import com.even.system.service.IBsUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAdminApplicationTests {
    @Resource
    private IBsUserService iBsUserService;
    @Autowired
    private IBsRoleService iBsRoleService;
    @Autowired
    private IBsMenuService iBsMenuService;
    @Test
    public void contextLoads() {


        String j="[{\"alwaysShow\":true,\"children\":[{\"alwaysShow\":true,\"children\":[],\"component\":\"system/menu/index\",\"iFrame\":0,\"icon\":\"menu\",\"meta\":{\"icon\":\"menu\",\"tile\":\"菜单管理\"},\"name\":\"菜单管理\",\"path\":\"/menu\",\"redirect\":\"noredirect\"},{\"alwaysShow\":true,\"children\":[],\"component\":\"system/user/index\",\"iFrame\":0,\"icon\":\"user\",\"meta\":{\"icon\":\"user\",\"tile\":\"用户管理\"},\"name\":\"用户管理\",\"path\":\"/user\",\"redirect\":\"noredirect\"}],\"component\":\"Layout\",\"iFrame\":0,\"icon\":\"system\",\"meta\":{\"icon\":\"system\",\"tile\":\"系统管理\"},\"name\":\"系统管理\",\"path\":\"/system\",\"redirect\":\"noredirect\"}]\n";
        String json="[{\"path\":\"https://github.com/elunez/eladmin\",\"component\":\"Layout\",\"children\":[{\"path\":\"https://github.com/elunez/eladmin\",\"meta\":{\"title\":\"项目地址\",\"icon\":\"github\"}}]},{\"name\":\"系统管理\",\"path\":\"/system\",\"redirect\":\"noredirect\",\"component\":\"Layout\",\"alwaysShow\":true,\"meta\":{\"title\":\"系统管理\",\"icon\":\"system\"},\"children\":[{\"name\":\"用户管理\",\"path\":\"user\",\"component\":\"system/user/index\",\"meta\":{\"title\":\"用户管理\",\"icon\":\"peoples\"}},{\"name\":\"角色管理\",\"path\":\"role\",\"component\":\"system/role/index\",\"meta\":{\"title\":\"角色管理\",\"icon\":\"role\"}},{\"name\":\"权限管理\",\"path\":\"permission\",\"component\":\"system/permission/index\",\"meta\":{\"title\":\"权限管理\",\"icon\":\"permission\"}},{\"name\":\"菜单管理\",\"path\":\"menu\",\"component\":\"system/menu/index\",\"meta\":{\"title\":\"菜单管理\",\"icon\":\"menu\"}},{\"name\":\"定时任务\",\"path\":\"timing\",\"component\":\"system/timing/index\",\"meta\":{\"title\":\"定时任务\",\"icon\":\"timing\"}},{\"name\":\"代码生成\",\"path\":\"generator\",\"component\":\"generator/index\",\"meta\":{\"title\":\"代码生成\",\"icon\":\"dev\"}}]},{\"name\":\"系统监控\",\"path\":\"/monitor\",\"redirect\":\"noredirect\",\"component\":\"Layout\",\"alwaysShow\":true,\"meta\":{\"title\":\"系统监控\",\"icon\":\"monitor\"},\"children\":[{\"name\":\"操作日志\",\"path\":\"logs\",\"component\":\"monitor/log/index\",\"meta\":{\"title\":\"操作日志\",\"icon\":\"log\"}},{\"name\":\"异常日志\",\"path\":\"errorLog\",\"component\":\"monitor/log/errorLog\",\"meta\":{\"title\":\"异常日志\",\"icon\":\"error\"}},{\"name\":\"系统缓存\",\"path\":\"redis\",\"component\":\"monitor/redis/index\",\"meta\":{\"title\":\"系统缓存\",\"icon\":\"redis\"}},{\"name\":\"SQL监控\",\"path\":\"http://localhost:8000/druid\",\"meta\":{\"title\":\"SQL监控\",\"icon\":\"sqlMonitor\"}},{\"name\":\"实时控制台\",\"path\":\"msg\",\"component\":\"monitor/log/msg\",\"meta\":{\"title\":\"实时控制台\",\"icon\":\"codeConsole\"}}]},{\"name\":\"三方工具\",\"path\":\"/tools\",\"redirect\":\"noredirect\",\"component\":\"Layout\",\"alwaysShow\":true,\"meta\":{\"title\":\"三方工具\",\"icon\":\"tools\"},\"children\":[{\"name\":\"邮件工具\",\"path\":\"email\",\"component\":\"tools/email/index\",\"meta\":{\"title\":\"邮件工具\",\"icon\":\"email\"}},{\"name\":\"SM.MS图床\",\"path\":\"pictures\",\"component\":\"tools/picture/index\",\"meta\":{\"title\":\"SM.MS图床\",\"icon\":\"image\"}},{\"name\":\"七牛云存储\",\"path\":\"qiniu\",\"component\":\"tools/qiniu/index\",\"meta\":{\"title\":\"七牛云存储\",\"icon\":\"qiniu\"}},{\"name\":\"支付宝工具\",\"path\":\"aliPay\",\"component\":\"tools/aliPay/index\",\"meta\":{\"title\":\"支付宝工具\",\"icon\":\"alipay\"}}]},{\"name\":\"组件管理\",\"path\":\"/components\",\"redirect\":\"noredirect\",\"component\":\"Layout\",\"alwaysShow\":true,\"meta\":{\"title\":\"组件管理\",\"icon\":\"zujian\"},\"children\":[{\"name\":\"图标库\",\"path\":\"icon\",\"component\":\"components/IconSelect\",\"meta\":{\"title\":\"图标库\",\"icon\":\"icon\"}},{\"name\":\"富文本\",\"path\":\"tinymce\",\"component\":\"components/Editor\",\"meta\":{\"title\":\"富文本\",\"icon\":\"fwb\"}}]},{\"name\":\"多级菜单\",\"path\":\"/nested\",\"redirect\":\"noredirect\",\"component\":\"Layout\",\"alwaysShow\":true,\"meta\":{\"title\":\"多级菜单\",\"icon\":\"menu\"},\"children\":[{\"name\":\"二级菜单2\",\"path\":\"menu2\",\"component\":\"nested/menu2/index\",\"meta\":{\"title\":\"二级菜单2\",\"icon\":\"menu\"}},{\"name\":\"二级菜单1\",\"path\":\"menu1\",\"redirect\":\"noredirect\",\"component\":\"nested/menu1/index\",\"alwaysShow\":true,\"meta\":{\"title\":\"二级菜单1\",\"icon\":\"menu\"},\"children\":[{\"name\":\"三级菜单2\",\"path\":\"menu1-2\",\"component\":\"nested/menu1/menu1-2\",\"meta\":{\"title\":\"三级菜单2\",\"icon\":\"menu\"}},{\"name\":\"三级菜单1\",\"path\":\"menu1-1\",\"component\":\"nested/menu1/menu1-1\",\"meta\":{\"title\":\"三级菜单1\",\"icon\":\"menu\"}}]}]}]";
        JSONArray jsonArray=JSONArray.parseArray(json);


        UserDTO userDTO=iBsUserService.findByUserName("admin");
        List list=iBsMenuService.findByRoles(userDTO.getRoleDTOS());
        System.out.println(JSON.toJSONString(list));

    }

}

