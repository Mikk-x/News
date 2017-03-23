package com.mikk.news.homepage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.mikk.news.R;
import com.mikk.news.bookmarks.BookmarksFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String ACTION_BOOKMARKS = "com.mikk.news.bookmarks";
    // 工具栏（代替ActionBar）
    private Toolbar toolbar;
    // 抽屉整体布局
    private DrawerLayout drawer;
    // 抽屉导航布局
    private NavigationView navigationView;

    private FrameLayout mLayoutFragment;

    // 首页Fragment
    private MainFragment mMainFragment;
    // 收藏页Fragment
    private BookmarksFragment mBookmarksFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        // 如果绑定实例不为空
        if (savedInstanceState != null) {
            // 得到实例的状态？  // TODO: 什么意思
            mMainFragment = (MainFragment) getSupportFragmentManager().getFragment(savedInstanceState, "MainFragment");
            mBookmarksFragment = (BookmarksFragment) getSupportFragmentManager().getFragment(savedInstanceState, "BookmarksFragment");
        } else { // 为空
            // 创建实例
            mMainFragment = MainFragment.newInstance();
            mBookmarksFragment = BookmarksFragment.newInstance();
        }
        // 如果首页碎片没添加
        if (!mMainFragment.isAdded()) {
            // 添加碎片在frameLayout中显示
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layout_fragment,mMainFragment,"MainFragment").commit();
        }

        if (!mBookmarksFragment.isAdded()){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layout_fragment,mBookmarksFragment,"BookmarksFragment").commit();
        }

        String action = getIntent().getAction();

        // 如果当前是收藏页面
        if (action.equals(ACTION_BOOKMARKS)){
            // 显示收藏页面
            showBookmarksFragment();
            // 默认选中
            navigationView.setCheckedItem(R.id.nav_bookmarks);
        }else {
            // 显示首页面
            showMainFragment();
            // 默认选中
            navigationView.setCheckedItem(R.id.nav_home);

        }


    }

    /**
     * 显示首页面，隐藏收藏页面
     */
    private void showMainFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 显示
        fragmentTransaction.show(mMainFragment);
        // 隐藏
        fragmentTransaction.hide(mBookmarksFragment);
        // 提交
        fragmentTransaction.commit();

        // 修改toolbar标题
        toolbar.setTitle(getResources().getString(R.string.app_name));
    }

    /**
     * 显示收藏页面，隐藏首页面
     */
    private void showBookmarksFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 显示
        fragmentTransaction.show(mBookmarksFragment);
        // 隐藏
        fragmentTransaction.hide(mMainFragment);
        // 提交
        fragmentTransaction.commit();

        // 修改toolbar标题
        toolbar.setTitle(getResources().getString(R.string.nav_bookmarks));
        // 如果收藏页面已经添加了，刷新收藏页面
//        if (mBookmarksFragment.isAdded()){
//            mBookmarksFragment.notifyDataChanged();
//        }
    }

    /**
     * 初始化视图
     */
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // 将toolbar实例传入，外观和功能和ActionBar一致
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_main);

        //操作抽屉栏开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, //activity
                drawer, // 抽屉布局
                toolbar, // toolbar
                R.string.navigation_drawer_open, // 打开内容
                R.string.navigation_drawer_close); // 关闭内容

        drawer.setDrawerListener(toggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        // 设置监听事件
        navigationView.setNavigationItemSelectedListener(this);
    }


    /**
     * 菜单项选中事件的监听
     *
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // 将滑动菜单关闭
        drawer.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            // 首页
            case R.id.nav_home:
                Toast.makeText(this, "首页", Toast.LENGTH_SHORT).show();
                showMainFragment();
                break;
            // 收藏页
            case R.id.nav_bookmarks:
                Toast.makeText(this, "收藏页", Toast.LENGTH_SHORT).show();
                showBookmarksFragment();
                break;
            // 切换主题
            case R.id.nav_chang_theme:
                Toast.makeText(this, "切换主题", Toast.LENGTH_SHORT).show();
                break;
            // 设置
            case R.id.nav_settings:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            // 关于
            case R.id.nav_about:
                Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
