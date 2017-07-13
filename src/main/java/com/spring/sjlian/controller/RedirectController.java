package com.spring.sjlian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 跳转控制
 * Created by lian on 17/7/13.
 */
@Controller
public class RedirectController {
    @RequestMapping(value = {"/index", "/index.html"}, method = RequestMethod.GET)
    public String redirectIndex() {
        return "/index";
    }
}
