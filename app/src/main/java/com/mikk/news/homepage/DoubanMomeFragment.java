package com.mikk.news.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikk.news.bean.DoubanMomenNews;

import java.util.ArrayList;

/**
 * Created by Mikk on 2017/3/23.
 */

public class DoubanMomeFragment extends Fragment implements DoubanMomeContract.View {

    public DoubanMomeFragment() {
    }

    public static DoubanMomeFragment newInstance(){
        return new DoubanMomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(ArrayList<DoubanMomenNews.posts> list) {

    }

    @Override
    public void setPresenter(DoubanMomeContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}
