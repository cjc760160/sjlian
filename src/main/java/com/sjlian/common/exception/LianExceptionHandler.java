package com.sjlian.common.exception;

import com.sjlian.common.result.ResponseHeader;
import com.sjlian.common.result.ResponseResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义异常json化处理，和数据返回格式统一化处理
 * （区分标志位code，不同异常code不同，content为前端提供异常提示信息，detail内部log）
 * Created by lian on 17/7/12.
 */
@ControllerAdvice
@EnableWebMvc
public class LianExceptionHandler {
    private static final Logger logger = Logger.getLogger(LianExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseResult handleException(Throwable t, HttpServletRequest request) {
        LianException lianException = LianException.wrapIfNeeded(t);
        boolean skipFatal = false;
        if (t instanceof HttpRequestMethodNotSupportedException) {
            skipFatal = true;
        }

        logger.info("remote addr: " + request.getRemoteAddr());
        logger.info("remote host: " + request.getRemoteHost());

        String url = request.getRequestURI();
        if (!StringUtils.isBlank(request.getQueryString())) {
            url += "?" + request.getQueryString();
        }
        logger.info(url);

        if (lianException.getCode() == -1 && !skipFatal) {
            logger.fatal(lianException.getDetail(), t);
        } else {
            logger.error(lianException.getDetail(), t);
        }

        ResponseHeader header = new ResponseHeader();
        header.setStatus(lianException.getCode());
        header.setDetail(lianException.getDetail());

        ResponseResult responseResult = new ResponseResult();
        responseResult.setHeader(header);
        return responseResult;
    }
}
