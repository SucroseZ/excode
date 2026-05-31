package com.example.ex5.common;

public class Response<T>{
    // 泛型表示具体的数据
    private T data;
    // 表示请求是否成功
    private boolean success;
    // 表示请求失败的错误信息
    private String errorMsg;

    // 成功返回的对象
    public static <K> Response<K> newSuccess(K data){
        Response<K> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }
    // 失败返回的对象
    public static Response<Void> newFail(String errorMsg){
        Response<Void> response = new Response<>();
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}


