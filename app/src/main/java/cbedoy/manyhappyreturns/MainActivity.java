package cbedoy.manyhappyreturns;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import cbedoy.manyhappyreturns.fragments.FragmentController;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private List<FragmentController> fragmentControllers;
    private FragmentStatePagerAdapter statePagerAdapter;
    private ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        smartTabLayout = (SmartTabLayout)findViewById(R.id.smartTabLayout);

        fragmentControllers = new ArrayList<>();

        fragmentControllers.add(new FragmentController(R.string.page_one_description, R.drawable.img_1));
        fragmentControllers.add(new FragmentController(R.string.page_two_description, R.drawable.img_2));
        fragmentControllers.add(new FragmentController(R.string.page_three_description, R.drawable.img_3));
        fragmentControllers.add(new FragmentController(R.string.page_four_description, R.drawable.img_4));
        fragmentControllers.add(new FragmentController(R.string.page_five_description, R.drawable.img_5));
        fragmentControllers.add(new FragmentController(R.string.page_six_description, R.drawable.img_6));
        fragmentControllers.add(new FragmentController(R.string.page_seven_description, R.drawable.img_7));
        fragmentControllers.add(new FragmentController(R.string.page_eight_description, R.drawable.img_8));
        fragmentControllers.add(new FragmentController(R.string.page_nine_description, R.drawable.img_9));

        statePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position)
            {
                return fragmentControllers.get(position);
            }

            @Override
            public int getCount()
            {
                return fragmentControllers.size();
            }
        };

        viewPager.setAdapter(statePagerAdapter);
        viewPager.addOnPageChangeListener(this);
        viewPager.setPageTransformer(false, this);
        smartTabLayout.setViewPager(viewPager);

        colors = new int[]{
                ContextCompat.getColor(getApplicationContext(), R.color.color_01),
                ContextCompat.getColor(getApplicationContext(), R.color.color_02),
                ContextCompat.getColor(getApplicationContext(), R.color.color_03),
                ContextCompat.getColor(getApplicationContext(), R.color.color_04),
                ContextCompat.getColor(getApplicationContext(), R.color.color_05),
                ContextCompat.getColor(getApplicationContext(), R.color.color_06),
                ContextCompat.getColor(getApplicationContext(), R.color.color_07),
                ContextCompat.getColor(getApplicationContext(), R.color.color_08),
                ContextCompat.getColor(getApplicationContext(), R.color.color_09),
        };

    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        FragmentController fragmentController = fragmentControllers.get(position);

        if(position < (statePagerAdapter.getCount() -1) && position < (colors.length - 1)) {

            Object evaluate = argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]);

            viewPager.setBackgroundColor((Integer) evaluate);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor((Integer) evaluate);
            }



            fragmentController.setHolderColor((Integer) evaluate);

        } else {

            // the last page color
            int color = colors[colors.length - 1];

            viewPager.setBackgroundColor(color);

            fragmentController.setHolderColor(color);

        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void transformPage(View view, float position) {
        if (position < -1 || position > 1) {
            view.setAlpha(0);
        }
        else if (position <= 0 || position <= 1) {
            // Calculate alpha. Position is decimal in [-1,0] or [0,1]
            float alpha = (position <= 0) ? position + 1 : 1 - position;
            view.setAlpha(alpha);
        }
        else if (position == 0) {
            view.setAlpha(1);
        }

    }
}
