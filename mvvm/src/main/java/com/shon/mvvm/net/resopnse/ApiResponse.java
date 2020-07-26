package com.shon.mvvm.net.resopnse;

import java.io.IOException;

import okhttp3.Headers;
import retrofit2.Response;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 18:22
 * Package name : com.shon.mvvm.net
 * Des :
 */
public class ApiResponse<T> {

    public static <T> ApiErrorResponse<T> create(Throwable error) {
        return new ApiErrorResponse(error.getMessage() == null ? "unknown error" : error.getMessage());
    }

    public  static <T> ApiResponse<T> create(Response<T> response) {
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null || response.code() == 204) {
                return new ApiEmptyResponse();
            } else {
                Headers linkHeader = response.headers();
                if (linkHeader != null) {
                    return new ApiSuccessResponse(body, linkHeader.get("link"));
                } else {
                    return new ApiSuccessResponse(body, null);
                }
            }
        } else {
            try {
                String errorMsg = null;
                if (response.errorBody() != null) {
                    String msg = response.errorBody().string();
                    if (msg == null || msg.isEmpty()) {
                        errorMsg = response.message();
                    } else {
                        errorMsg = msg;
                    }
                }
                return new ApiErrorResponse(errorMsg == null ? "unknown error" : errorMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
