package com.even.system.controller;


import com.even.common.result.Result;
import com.even.common.result.ResultUtils;
import com.even.system.dto.MenuDTO;
import com.even.system.dto.UserDTO;
import com.even.system.service.IBsMenuService;
import com.even.system.service.IBsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
@Controller
@RequestMapping("/api")
public class BsMenuController {
    @Autowired
    private IBsUserService iBsUserService;
    @Autowired
    private IBsMenuService iBsMenuService;

    /**
     * 构建所有菜单
     * @return
     */
    @GetMapping("/menus/build")
    public Result buildMenus(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO=iBsUserService.findByUserName(userDetails.getUsername());
        List<MenuDTO> list=iBsMenuService.findByRoles(userDTO.getRoleDTOS());
        return ResultUtils.success(iBsMenuService.getMenuTree(list));
    }
}
