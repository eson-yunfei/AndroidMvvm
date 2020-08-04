package com.shon.live.net.resopnse;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 18:23
 * Package name : com.shon.mvvm.net
 * Des :
 */
public class ApiErrorResponse<T> extends ApiResponse<T> {
    private String errorMessage;

    public ApiErrorResponse(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
