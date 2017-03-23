package com.mikk.news.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Mikk on 2017/3/23.
 * 判断当前的网络状态，是否有网络连接
 * wifi或者移动数据
 */

public class NetworkState {

    /**
     * 检查是否连接到网络
     * @param context
     * @return
     */
    public static boolean networkConnected(Context context){
        // 如果上下文不等于null
        if (context != null) {
            // 连接管理器？          从系统服务中得到连接服务
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            // 得到网络信息
            NetworkInfo info = manager.getActiveNetworkInfo();
            // 如果网络信息不为空
            if (info != null) {
                // 网络是可用的
                return info.isAvailable();
            }
        }
        // 如果上下文为空，返回false
        return false;
    }

    /**
     * 检查WiFi是否连接
     * @param context
     * @return
     */
    public static boolean wifiConnected(Context context){

        // 如果上下文不等于null
        if (context != null) {
            // 连接管理器？          从系统服务中得到连接服务
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            // 得到网络信息
            NetworkInfo info = manager.getActiveNetworkInfo();
            // 如果网络信息不为空
            if (info != null) {
                // 如果网络信息类型是WiFi
                if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    // 网络是可用的
                    return info.isAvailable();
                }
            }
        }
        // 如果上下文为空，返回false
        return false;
    }

    /**
     * 检查移动网络是否连接
     * @param context
     * @return
     */
    public static boolean mobileDataConnected(Context context){

        // 如果上下文不等于null
        if (context != null) {
            // 连接管理器？          从系统服务中得到连接服务
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            // 得到网络信息
            NetworkInfo info = manager.getActiveNetworkInfo();
            // 如果网络信息不为空
            if (info != null) {
                // 如果网络信息类型是WiFi
                if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // 网络是可用的
                    return info.isAvailable();
                }
            }
        }
        // 如果上下文为空，返回false
        return false;
    }

}
