package com.ruoyi.system.domain;

import java.io.Serializable;

/**
 * @author: MM
 * @date: 2022-06-20 14:12
 */
public class RespBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Object data;

    private static Integer code ;

    private static Integer status ;

    /**
     * 响应消息
     * */
    private String msg =ResponseStatus.OK.getMsg();


    public RespBean(ResponseStatus responseStatus, Object data) {
        this.data = data;
        this.code = responseStatus.getCode();
        this.status=responseStatus.getStatus();
        this.msg = responseStatus.getMsg();

    }

    public static RespBean build() {
        return new RespBean();
    }


    private RespBean() {
    }

    public RespBean(ResponseStatus ResponseStatus) {
        this.status=ResponseStatus.getStatus();
        this.code = ResponseStatus.getCode();
        this.msg = ResponseStatus.getMsg();
    }

    public static RespBean ok(ResponseStatus ResponseStatus) {
        return new RespBean(ResponseStatus, null);
    }

    public static RespBean ok(ResponseStatus ResponseStatus, Object data) {
        return new RespBean(ResponseStatus, data);
    }

    public static RespBean fail(ResponseStatus ResponseStatus) {
        return new RespBean(ResponseStatus);
    }

    public  Integer getCode() {
        return code;
    }

    public RespBean setCode(Integer code) {
        this.code = code;
        return this;
    }

    public  Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RespBean setData(Object data) {
        this.data = data;
        return this;
    }

}
