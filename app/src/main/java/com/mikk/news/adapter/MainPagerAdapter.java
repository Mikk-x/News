package com.mikk.news.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mikk.news.R;
import com.mikk.news.homepage.DoubanMomeFragment;
import com.mikk.news.homepage.GuokrHandpickFragment;
import com.mikk.news.homepage.ZhihuDailyFragment;

/**
 * Created by Mikk on 2017/3/24.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private String[] titles;
    private Context mContext;

    private ZhihuDailyFragment mZhihuDailyFragment;
    private GuokrHandpickFragment mGuokrHandpickFragment;
    private DoubanMomeFragment mDoubanMomeFragment;

    public ZhihuDailyFragment getZhihuDailyFragment() {
        return mZhihuDailyFragment;
    }

    public GuokrHandpickFragment getGuokrHandpickFragment() {
        return mGuokrHandpickFragment;
    }

    public DoubanMomeFragment getDoubanMomeFragment() {
        return mDoubanMomeFragment;
    }

    public MainPagerAdapter(FragmentManager fm, Context context, ZhihuDailyFragment zhihuDailyFragment, GuokrHandpickFragment guokrHandpickFragment, DoubanMomeFragment doubanMomeFragment) {
        super(fm);
        mContext = context;

        this.titles = new String[]{
                context.getResources().getString(R.string.zhihu_daily),
                context.getResources().getString(R.string.guokr_handpick),
                context.getResources().getString(R.string.douban_moment)
        };

        mZhihuDailyFragment = zhihuDailyFragment;
        mGuokrHandpickFragment = guokrHandpickFragment;
        mDoubanMomeFragment = doubanMomeFragment;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return mGuokrHandpickFragment;
        }
        if (position == 2) {
            return mDoubanMomeFragment;
        }

        return mZhihuDailyFragment;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
