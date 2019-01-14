package com.frank.zheng.crash_process.model;

public class Response {
    private String msg;

    public static Response success() {
        Response res = new Response();
        res.setMsg("OK");
        return res;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
