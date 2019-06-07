package matrimonial.assignment.com.matrimonialassignment.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.adapter.InterestPagerAdapter;
import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.view.BlockUserListFragment;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.view.ShortListUserListFragment;

public class InterestFragment extends Fragment {

    private View view;
    private BlockUserListFragment blockUserListFragment;
    private ShortListUserListFragment shortListUserListFragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_interest_layout, null);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewPager = this.view.findViewById(R.id.viewPager);
        blockUserListFragment = new BlockUserListFragment();
        shortListUserListFragment = new ShortListUserListFragment();
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.clear();
        tabFragmentList.add(blockUserListFragment);
        tabFragmentList.add(shortListUserListFragment);
        TabLayout tabLayout = this.view.findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        InterestPagerAdapter interestPagerAdapter = new InterestPagerAdapter(getChildFragmentManager(), tabFragmentList);
        viewPager.setAdapter(interestPagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
