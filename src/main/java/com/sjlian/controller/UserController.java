package com.sjlian.controller;

import com.sjlian.common.VO.UserVO;
import com.sjlian.common.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sjlian.service.IUserService;

/**
 * Created by lian on 17/7/12.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private  IUserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult addUser(@RequestBody UserVO userVO){
        return ResponseResult.response(userService.addUser(userVO));
    }
}
