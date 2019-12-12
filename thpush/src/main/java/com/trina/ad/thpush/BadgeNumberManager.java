package com.trina.ad.thpush;

import android.content.Context;
import android.os.Build;

/**
 * 应用桌面角标设置的管理类
 * Created by zlq on 2017 17/8/23 14:50.
 */

public class BadgeNumberManager {

    private Context mContext;

    private BadgeNumberManager(Context context) {
        mContext = context;
    }

    public static BadgeNumberManager from(Context context) {
        return new BadgeNumberManager(context);
    }

    private static final BadgeNumberManager.Impl IMPL;


    /**
     * 设置应用在桌面上显示的角标数字
     *
     * @param number 显示的数字
     */
    public void setBadgeNumber(int number) {
        IMPL.setBadgeNumber(mContext, number);
    }

    interface Impl {

        void setBadgeNumber(Context context, int number);

    }

    static class ImplHuaWei implements Impl {

        @Override
        public void setBadgeNumber(Context context, int number) {
            BadgeNumberManagerHuaWei.setBadgeNumber(context, number);
        }
    }





    static class ImplBase implements Impl {

        @Override
        public void setBadgeNumber(Context context, int number) {
            //do nothing
        }
    }

    static {
        String manufacturer = Build.MANUFACTURER;
        IMPL = new ImplHuaWei();
//        if (manufacturer.equalsIgnoreCase(MobileBrand.HUAWEI)) {
//            IMPL = new ImplHuaWei();
//        }  else {
//            IMPL = new ImplBase();
//        }
    }
}
