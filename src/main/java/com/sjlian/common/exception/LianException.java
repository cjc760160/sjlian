package com.sjlian.common.exception;

/**
 * 自定义异常
 * Created by lian on 17/7/12.
 */
public class LianException extends RuntimeException{
    private Integer code; //错误代码
    private String content; // 问题描述
    private String detail; // 问题细节, 内部log

    public LianException(){
        super();
    }

    public LianException(Throwable cause, Integer code, String content){
        super(cause);
        this.code = code;
        this.content = content;
    }

    public LianException(Throwable cause, Integer code, String content,String detail){
        this(cause,code,content);
        this.detail = detail;
    }

    public static LianException wrapIfNeeded(Throwable t) {
        if (t instanceof LianException) {
            return (LianException) t;
        } else {
            return LianException.INTERNAL(t, t.getMessage());
        }
    }

    public static LianException INTERNAL(Throwable ex, String detail) {
        return new LianException(ex, 100, "INTERNAL", detail);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
