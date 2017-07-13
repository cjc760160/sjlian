package com.spring.sjlian.controller;

import com.spring.sjlian.common.result.ResponseResult;
import com.spring.sjlian.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器,返回json格式数据/ModelAndView/String
 * Created by lian on 17/7/13.
 */
@Controller
@RequestMapping("/book")
public class BookController extends BaseController {
    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult queryAll() {
        return ResponseResult.response(bookService.queryAll(1, 100));
    }

}
