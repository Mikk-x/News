package com.mikk.news.homepage;

import com.mikk.news.BasePresenter;
import com.mikk.news.BaseView;
import com.mikk.news.bean.ZhihuDailyNews;

import java.util.ArrayList;

/**
 * Created by Mikk on 2017/3/23.
 */

public interface ZhihuDailyContract {

    interface View extends BaseView<Presenter> {

        /**
         * 显示加载或其他类型的错误
         */
        void showError();

        /**
         * 显示正在加载
         */
        void showLoading();

        /**
         * 停止显示正在加载
         */
        void stopLoading();

        /**
         * 成功获取到数据后，在界面中显示
         * @param list
         */
        void showResults(ArrayList<ZhihuDailyNews.Question> list);

    }


    interface Presenter extends BasePresenter {

        /**
         * 请求数据
         * @param date
         * @param clearing
         */
        void loadPosts(long date, boolean clearing);

        /**
         * 刷新数据
         */
        void refresh();

        /**
         * 加载更多文章
         * @param date
         */
        void loadMore(long date);

        /**
         * 显示详情
         * @param position
         */
        void startReading(int position);

        /**
         * 随便看看
         */
        void feelLucky();

    }
}
