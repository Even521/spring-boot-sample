package com.even.system.controller;


import com.even.common.result.Result;
import com.even.system.dto.UserDTO;
import com.even.system.service.IBsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
@Controller
@RequestMapping("/system")
public class BsMenuController {
    @Autowired
    private IBsUserService iBsUserService;

    @GetMapping("/menus/build")
    public Result buildMenus(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDTO userDTO=iBsUserService.findByUserName(userDetails.getUsername());
        return null;
       //
    }
}
