package com.spring.sjlian.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 提供control类的基础控制
 * Created by lian on 17/7/12.
 */
public class BaseController {
    private final String REDIRECT = "redirect:";
    private final String FORWARD = "forward:";
    private HttpServletRequest request;
    private HttpServletResponse response;
    private final String BASEPATH = "basePath";

    @ModelAttribute
    private void pre(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        initParams();
    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected void add(String key, Object value) {
        request.setAttribute(key, value);
    }

    protected void remove(String key) {
        request.removeAttribute(key);
    }

    protected void add(Map<String, Object> map) {
        for (String key : map.keySet()) {
            request.setAttribute(key, map.get(key));
        }
    }

    protected Object get(String key) {
        return request.getAttribute(key);
    }

    @SuppressWarnings("unchecked")
    protected <T> T get(String key, Class<?> T) {
        return (T) request.getAttribute(key);
    }

    protected String redirect(String path) {
        return REDIRECT.concat(path);
    }

    protected String forWard(String path) {
        return FORWARD.concat(path);
    }

    private String getBasePath() {
//        return WebUtil.getBasePath();
        return null;
    }

    private void initParams() {
        add(BASEPATH, getBasePath());
    }
}
