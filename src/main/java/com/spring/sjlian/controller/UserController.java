package com.spring.sjlian.controller;

import com.spring.sjlian.common.VO.UserVO;
import com.spring.sjlian.common.result.ResponseResult;
import com.spring.sjlian.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lian on 17/7/12.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addUser(@RequestBody UserVO userVO){
        return ResponseResult.response(userService.addUser(userVO));
    }
}
