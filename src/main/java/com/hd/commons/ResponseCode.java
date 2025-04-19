package com.hd.commons;

public enum ResponseCode {
    SYS_SUCCESS("20000", "成功"),

    SYS_FAILURE("00000", "失败"),

    OPERATE_DATA_SUCCESS("20000", "操作成功"),

    OPERATE_DATA_FAILURE("50000", "数据操作失败"),

    SYS_PARAM_NOT_RIGHT("50001", "传入参数不合法"),

    SYS_PARAM_NOT_NULL("50002", "必要参数不能为空"),

    QUERY_DATA_NOT_EXIST("50003", "查询数据不存在"),

    USER_OR_PASSWORD_ERROR("50004", "用户名或者密码错误"),

    ACCESS_TOKEN_VALID_FAILED("40001", "Token 校验失败"),

    SYSTEM_EXCEPTION("50250", "系统繁忙，请稍候重试");

    private String code;

    private String message;

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(String detailDesc) {
        return message + ":" + detailDesc;
    }
}
