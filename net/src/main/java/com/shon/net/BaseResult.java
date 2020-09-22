package com.shon.net;

/**
 * Auth : xiao.yunfei
 * Date : 2020/7/21 19:50
 * Package name : net.yt.whale.net
 * Des :
 */
public class BaseResult<T> {
    private int code;
    private long t;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", t='" + t + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
