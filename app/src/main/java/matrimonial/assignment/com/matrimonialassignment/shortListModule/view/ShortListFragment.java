package matrimonial.assignment.com.matrimonialassignment.shortListModule.view;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
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
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.view.BlockUserListFragment;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentShortlistLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.interestModule.view.InterestFragment;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.shortListModule.viewModel.ShortListViewModel;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.view.ShortListUserListFragment;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;

public class ShortListFragment extends BaseFragment {

    private View view;
    private BlockUserListFragment blockUserListFragment;
    private ShortListUserListFragment shortListUserListFragment;
    private List<DataResponse> shortListUserList;
    private List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse> blockUserList;
    private FragmentShortlistLayoutBinding fragmentShortListLayoutBinding;
    private ShortListViewModel shortListViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentShortListLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shortlist_layout, null, false);
        view = fragmentShortListLayoutBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        shortListViewModel = new ShortListViewModel();
        fragmentShortListLayoutBinding.setViewModel(shortListViewModel);
        fragmentShortListLayoutBinding.executePendingBindings();
        init();
    }

    private void init() {
        observeProgressDialog(shortListViewModel);
        observeFinishActivity(shortListViewModel);
        observeShortListResponse();
        sendDataToViewModel();
        observeBlockUserListResponse();
        shortListViewModel.getBlockUsersList();
    }

    private void observeBlockUserListResponse() {
        shortListViewModel.getBlockUserListMutableLiveData().observe(this, new Observer<List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse>>() {
            @Override
            public void onChanged(@Nullable List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse> dataResponses) {
                blockUserList = new ArrayList<>();
                blockUserList.addAll(dataResponses);
            }
        });

    }

    private void sendDataToViewModel() {
        shortListViewModel.setHeaders(getHeaders());
    }

    private void observeShortListResponse() {
        shortListViewModel.getDataResponseMutableLiveData().observe(this, new Observer<List<DataResponse>>() {
            @Override
            public void onChanged(@Nullable List<DataResponse> dataResponses) {
                shortListUserList = new ArrayList<>();
                shortListUserList.addAll(dataResponses);
                setTabLayout();
                shortListViewModel.setProgressDialog(DISMISS_PROGRESS_DIALOG);
            }
        });
    }

    private void setTabLayout() {
        ViewPager viewPager = fragmentShortListLayoutBinding.viewPager;
        blockUserListFragment = new BlockUserListFragment(blockUserList);
        shortListUserListFragment = new ShortListUserListFragment(shortListUserList);
        List<Fragment> tabFragmentList = new ArrayList<>();
        tabFragmentList.clear();
        tabFragmentList.add(blockUserListFragment);
        tabFragmentList.add(shortListUserListFragment);
        TabLayout tabLayout = fragmentShortListLayoutBinding.tabLayout;
        tabLayout.setVisibility(View.VISIBLE);
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
