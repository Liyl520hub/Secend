package com.bwei.day_test.persenter;

import com.bwei.day_test.moudl.Main_bean;
import com.bwei.day_test.moudl.utils.Utils;
import com.bwei.day_test.view.iview.Main_interface;

/**
 * 作者：李亚雷
 * 时间：2017/5/19
 * 类用途：
 * 思路：
 */

public class Main_persenter extends Base_Persenter<Main_interface> {


    private String url = "http://result.eolinker.com/k2BaduF2a6caa275f395919a66ab1dfe4b584cc60685573?uri=gj";

    public void getData() {

        Utils.httpGet(url, Main_bean.class, new Utils.UtilsInterface() {
            @Override
            public void CallBackData(Object o) {
                getImvpview().CallBack((Main_bean) o);
            }
        });

    }


}
