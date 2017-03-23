package com.mikk.news.homepage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mikk.news.R;
import com.mikk.news.adapter.MainPagerAdapter;

import java.util.Random;

/**
 * Created by Mikk on 2017/3/23.
 */

public class MainFragment extends Fragment {

    // 上下文
    private Context mContext;
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private MainPagerAdapter mAdapter;

    private ZhihuDailyFragment mZhihuDailyFragment;
    private GuokrHandpickFragment mGuokrHandpickFragment;
    private DoubanMomeFragment mDoubanMomeFragment;

    private ZhihuDailyPresenter mZhihuDailyPresenter;
    private GuokrHandpickPresenter mGuokrHandpickPresenter;
    private DoubanMomePresenter mDoubanMomePresenter;


    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();

        // Fragment 状态恢复
        if (savedInstanceState != null) {
            FragmentManager manager = getChildFragmentManager();
            mZhihuDailyFragment = (ZhihuDailyFragment) manager.getFragment(savedInstanceState, "zhihu");
            mGuokrHandpickFragment = (GuokrHandpickFragment) manager.getFragment(savedInstanceState, "guokr");
            mDoubanMomeFragment = (DoubanMomeFragment) manager.getFragment(savedInstanceState, "douban");
        } else {
            // 创建View实例
            mZhihuDailyFragment = ZhihuDailyFragment.newInstance();
            mGuokrHandpickFragment = GuokrHandpickFragment.newInstance();
            mDoubanMomeFragment = DoubanMomeFragment.newInstance();
        }

        // 创建Presenter实例
        mZhihuDailyPresenter = new ZhihuDailyPresenter(mContext, mZhihuDailyFragment);
        mGuokrHandpickPresenter = new GuokrHandpickPresenter(mContext, mGuokrHandpickFragment);
        mDoubanMomePresenter = new DoubanMomePresenter(mContext, mDoubanMomeFragment);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // 初始化控件
        initViews(view);

        // 显示菜单
        setHasOptionsMenu(true);

        // 当tablayout位置为果壳精选时，隐藏fab
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
                if (tab.getPosition() == 1) {
                    fab.hide();
                } else {
                    fab.show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private void initViews(View view) {

        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        // 设置离线数为3
        viewPager.setOffscreenPageLimit(3);

        mAdapter = new MainPagerAdapter(
                getChildFragmentManager(),
                mContext,
                mZhihuDailyFragment,
                mGuokrHandpickFragment,
                mDoubanMomeFragment);
        
        viewPager.setAdapter(mAdapter);
        // 将TabLayout和ViewPager关联起来
        mTabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_feel_lucky:
                feelLucky();
                break;
        }

        return true;
    }

    /**
     * 保存状态
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager manager = getChildFragmentManager();
        manager.putFragment(outState,"zhihu",mZhihuDailyFragment);
        manager.putFragment(outState,"guokr",mGuokrHandpickFragment);
        manager.putFragment(outState,"douban",mDoubanMomeFragment);
    }

    /**
     * 随便看看
     */
    private void feelLucky() {
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                mZhihuDailyPresenter.feelLucky();
                break;
            case 1:
                mGuokrHandpickPresenter.feelLucky();
                break;
            case 2:
                mDoubanMomePresenter.feelLucky();
                break;
        }
    }

    public MainPagerAdapter getAdapter() {
        return mAdapter;
    }
}
