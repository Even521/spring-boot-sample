package com.even.system.controller;


import com.even.common.result.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/system/bs-menu")
public class BsMenuController {

    public Result buildMenus(){
        return null;
       // UserDetails userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
