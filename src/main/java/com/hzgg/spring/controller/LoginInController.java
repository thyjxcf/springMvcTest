package com.hzgg.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by luf on 2018/11/6.
 */
@Controller
@RequestMapping("/login/index")
public class LoginInController {
    @RequestMapping("/page")
    public String login(){
        ModelAndView view = new ModelAndView("");
        return "index";
    }
}
