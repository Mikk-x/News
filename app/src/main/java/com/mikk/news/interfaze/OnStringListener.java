package com.mikk.news.interfaze;

import com.android.volley.VolleyError;

/**
 * Created by Mikk on 2017/3/23.
 */

public interface OnStringListener {


    /**
     * 网络请求成功时回调
     *
     * @param result
     */
    void onSuccess(String result);

    /**
     * 网络请求失败时回调
     *
     * @param error
     */
    void onError(VolleyError error);
}
