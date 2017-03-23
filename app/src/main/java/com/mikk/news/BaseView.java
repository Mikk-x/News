package com.mikk.news;

import android.view.View;

/**
 * Created by Mikk on 2017/3/23.
 */

public interface BaseView<T> {
    /**
     * 为View设置Presenter
     */
    void setPresenter(T presenter);

    /**
     * 初始化界面控件
     *
     * @param view
     */
    void initViews(View view);
}
