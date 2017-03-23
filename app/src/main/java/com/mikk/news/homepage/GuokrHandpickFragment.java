package com.mikk.news.homepage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikk.news.bean.GuokrHandpickNews;

import java.util.ArrayList;

/**
 * Created by Mikk on 2017/3/23.
 */

public class GuokrHandpickFragment extends Fragment implements GuokrHandpickContract.View {

    public GuokrHandpickFragment() {
    }

    public static GuokrHandpickFragment newInstance(){
        return new GuokrHandpickFragment();
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
    public void showResults(ArrayList<GuokrHandpickNews.result> list) {

    }

    @Override
    public void setPresenter(GuokrHandpickContract.Presenter presenter) {

    }

    @Override
    public void initViews(View view) {

    }
}
