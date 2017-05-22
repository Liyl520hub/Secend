package com.bwei.day_test.persenter;

import com.bwei.day_test.view.iview.IMvpView;

/**
 * 作者：李亚雷
 * 时间：2017/5/19
 * 类用途：
 * 思路：
 */

public class Base_Persenter<T extends IMvpView> {

    private T imvpview;


    public T getImvpview() {
        return imvpview;
    }

    public void setImvpview(T imvpview) {
        this.imvpview = imvpview;
    }
}
