package com.bwei.day_test.moudl.utils;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 作者：李亚雷
 * 时间：2017/5/19
 * 类用途：
 * 思路：
 */

public class Utils {



    public static <T>void httpGet(String url, final Class<T> mclass, final UtilsInterface utilsInterface){

        RequestParams requestParams = new RequestParams(url);


        x.http().get(requestParams, new Callback.CommonCallback<String >() {

            @Override
            public void onSuccess(String result) {

                Gson gson = new Gson();
                T t = gson.fromJson(result, mclass);

                utilsInterface.CallBackData(t);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });





    }



    public interface UtilsInterface<T>{

        void CallBackData(T t);

    }




}
