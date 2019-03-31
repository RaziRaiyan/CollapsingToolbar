package com.example.collapsingtoolbar;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private NestedScrollView mNestedScrollView;
    private ImageView mImageViewAppbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    private RestaurantFragment mRestaurantFragment;
    private ResortsFragment mResortsFragment;
    private MuseumFragment mMuseumFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNestedScrollView = findViewById(R.id.nested_scroll_view_main);
//        mNestedScrollView.setFillViewport(true);

        mTabLayout = findViewById(R.id.tab_layout_main);
        mViewPager = findViewById(R.id.viewpager_main);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mImageViewAppbar = findViewById(R.id.appbar_image_main);
        mCollapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_main);

        mRestaurantFragment = new RestaurantFragment();
        mResortsFragment = new ResortsFragment();
        mMuseumFragment = new MuseumFragment();

        mViewPagerAdapter.addFragment(mRestaurantFragment, "Restaurants");
        mViewPagerAdapter.addFragment(mResortsFragment, "Resorts");
        mViewPagerAdapter.addFragment(mMuseumFragment, "Museums");

        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText("Restaurants");
        mTabLayout.getTabAt(1).setText("Resorts");
        mTabLayout.getTabAt(2).setText("Museums");

        final Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        Glide.with(MainActivity.this).load(R.drawable.bg_yellow_dark)
                                .centerCrop().transition(DrawableTransitionOptions.withCrossFade())
                                .into(mImageViewAppbar);
                        window.setStatusBarColor(getColor(R.color.colorPrimaryDark));
                        mCollapsingToolbarLayout.setContentScrimColor(getColor(R.color.colorPrimary));
                        mTabLayout.setBackground(getDrawable(R.drawable.bg_tab_restaurant));
                        break;
                    case 1:
                        Glide.with(MainActivity.this).load(R.drawable.bg_appbar_resorts)
                                .centerCrop().transition(DrawableTransitionOptions.withCrossFade())
                                .into(mImageViewAppbar);
                        window.setStatusBarColor(getColor(R.color.colorMaterialLightBlue700));
                        mCollapsingToolbarLayout.setContentScrimColor(getColor(R.color.colorMaterialLightBlue500));
                        mTabLayout.setBackground(getDrawable(R.drawable.bg_tab_resorts));
                        break;
                    case 2:
                        Glide.with(MainActivity.this).load(R.drawable.bg_appbar_museum)
                                .centerCrop().transition(DrawableTransitionOptions.withCrossFade())
                                .into(mImageViewAppbar);
                        window.setStatusBarColor(getColor(R.color.colorMaterialPurple700));
                        mCollapsingToolbarLayout.setContentScrimColor(getColor(R.color.colorMaterialPurple500));
                        mTabLayout.setBackground(getDrawable(R.drawable.bg_tab_meuseum));
                        break;
                }
                Toast.makeText(MainActivity.this, "Tab position: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
