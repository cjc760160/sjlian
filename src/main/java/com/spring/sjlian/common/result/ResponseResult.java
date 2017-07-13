package com.spring.sjlian.common.result;

import java.io.Serializable;

/**
 * 封装返回给用户的json数据（包含异常信息）
 * Created by lian on 17/7/12.
 */
public class ResponseResult implements Serializable {
    private ResponseHeader header;
    private Object data;

    public static ResponseResult response(Object data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setHeader(ResponseHeader.successHeader());
        responseResult.setData(data);
        return responseResult;
    }

    public static ResponseResult fail(Object data){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setHeader(ResponseHeader.errorHeader(null));
        responseResult.setData(data);
        return responseResult;
    }

    public ResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ResponseHeader header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
