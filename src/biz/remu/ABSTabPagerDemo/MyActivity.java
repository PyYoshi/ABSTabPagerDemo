package biz.remu.ABSTabPagerDemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TabHost;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MyActivity extends SherlockFragmentActivity {

    TabHost mTabHost;
    ViewPager mViewPager;
    TabAdapter mTabAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTabHost = (TabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mViewPager = (ViewPager)findViewById(R.id.pager);

        mTabAdapter = new TabAdapter(this,mTabHost, mViewPager);

        mTabAdapter.addTab(mTabHost.newTabSpec("afragment").setIndicator("FragmentA"), AFragment.class, null);
        mTabAdapter.addTab(mTabHost.newTabSpec("bfragment").setIndicator("FragmentB"), BFragment.class, null);
        mTabAdapter.addTab(mTabHost.newTabSpec("cfragment").setIndicator("FragmentC"), CFragment.class, null);

        if(savedInstanceState != null){
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
    }

    Fragment getCurrentFragment(){
        return getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.pager + ":" + mViewPager.getCurrentItem());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tab", mTabHost.getCurrentTabTag());
    }
}
