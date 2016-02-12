package com.coolweather.app.util;

/**
 * Created by doudou on 2016/2/10.
 */
public interface HttpCallbackListener {

    void onFinish(String response);
    void onError(Exception e);

}
