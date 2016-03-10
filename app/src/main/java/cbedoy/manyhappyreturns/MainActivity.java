package cbedoy.manyhappyreturns;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import cbedoy.manyhappyreturns.fragments.FragmentController;


public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private SmartTabLayout indicator;
    private List<Integer> mLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        indicator = (SmartTabLayout)findViewById(R.id.indicator);

        mLayouts = new ArrayList<>();
        mLayouts.add(R.layout.fragment_one);
        mLayouts.add(R.layout.fragment_two);
        mLayouts.add(R.layout.fragment_three);
        mLayouts.add(R.layout.fragment_four);
        mLayouts.add(R.layout.fragment_five);
        mLayouts.add(R.layout.fragment_six);
        mLayouts.add(R.layout.fragment_seven);
        mLayouts.add(R.layout.fragment_eigth);
        mLayouts.add(R.layout.fragment_nine);
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position)
            {
                return new FragmentController(mLayouts.get(position));
            }

            @Override
            public int getCount()
            {
                return mLayouts.size();
            }
        };

        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }


}
