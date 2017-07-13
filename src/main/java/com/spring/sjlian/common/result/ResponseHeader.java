package com.spring.sjlian.common.result;

/**
 * 封装返回给用户的json数据头（包含异常信息）
 * Created by lian on 17/7/12.
 */
public class ResponseHeader {
    public static final Integer SUCCESS_STATUS = 0;
    public static final Integer ERROR_STATUS = 1;

    private Integer status = null;
    private String detail = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ResponseHeader successHeader() {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setStatus(SUCCESS_STATUS);
        return responseHeader;
    }

    public static ResponseHeader errorHeader(String detail) {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setStatus(ERROR_STATUS);
        responseHeader.setDetail(detail);
        return responseHeader;
    }

    public static ResponseHeader errorHeader(Integer status ,String detail) {
        ResponseHeader responseHeader = new ResponseHeader();
        responseHeader.setStatus(status);
        responseHeader.setDetail(detail);
        return responseHeader;
    }
}
