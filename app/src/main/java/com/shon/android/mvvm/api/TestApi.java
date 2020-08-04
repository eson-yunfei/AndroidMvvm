//package com.shon.android.mvvm.api;
//
//import androidx.lifecycle.Observer;
//
//import com.shon.mvvm.net.BaseApi;
//import com.shon.live.net.resopnse.ApiResponse;
//import com.shon.live.net.resopnse.ResultObserver;
//
///**
// * Auth : xiao_yun_fei
// * Date : 2020/7/26 18:47
// * Package name : com.shon.android.mvvm.api
// * Des :
// */
//class TestApi extends BaseApi<Api> {
//    public TestApi() {
//        super("baseUrl");
//    }
//
//    @Override
//    protected Class<Api> getApiInterface() {
//        return Api.class;
//    }
//
//    public void startLogin(){
//        apiInterface.login().observeForever(new Observer<ApiResponse<String>>() {
//            @Override
//            public void onChanged(ApiResponse<String> stringApiResponse) {
//
//            }
//        });
//
//        apiInterface.login().observeForever(new ResultObserver<String>() {
//            @Override
//            protected void onSuccess(String s) {
//
//
//            }
//        });
//    }
//}
