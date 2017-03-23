package com.mikk.news.bean;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.mikk.news.app.VolleySingleton;
import com.mikk.news.interfaze.OnStringListener;

/**
 * Created by Mikk on 2017/3/23.
 */

public class StringModelImpl {

    private Context mContext;

    public StringModelImpl(Context context) {
        mContext = context;
    }

    public void load(String url, final OnStringListener listener){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            // 成功
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
            // 失败
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError);
            }
        });

        // volley默认超时时间以及重连次数
        request.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getVolleySingleton(mContext).addToRequestQueue(request);

    }

}
