package com.shon.live.net.resopnse;

import androidx.lifecycle.Observer;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 19:40
 * Package name : com.shon.live.net.resopnse
 * Des :
 */
public abstract class ResultObserver<T> implements Observer<ApiResponse<T>> {

    @Override
    public void onChanged(ApiResponse<T> apiResponse) {

        if (apiResponse instanceof ApiSuccessResponse){
           T t = (T) ((ApiSuccessResponse)apiResponse).getBody();
           onSuccess(t);
        }
        if (apiResponse instanceof ApiErrorResponse){
            String error = ((ApiErrorResponse)apiResponse).getErrorMessage();
            onError(error);
        }
        if (apiResponse instanceof ApiEmptyResponse){

        }
    }

    protected abstract  void onSuccess(T t);

    protected void onError(String error){}

}
