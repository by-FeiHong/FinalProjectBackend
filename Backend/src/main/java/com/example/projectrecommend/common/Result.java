package com.example.projectrecommend.common;

public class Result<T> {

    private static final String SUCCESS = "0";
    private static final String ERROR = "-1";

    private String code;
    private String msg;
    private T data;
    private Integer total;

    public Result() {}

    public Result(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> Result<T> success() {
        return new Result<>(SUCCESS, null, "SUCCESS");
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, data, "SUCCESS");
    }

    public static <T> Result<T> success(T data, Integer total) {
        Result<T> result = new Result<>(SUCCESS, data, "SUCCESS");
        result.setTotal(total);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(ERROR, null, msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}