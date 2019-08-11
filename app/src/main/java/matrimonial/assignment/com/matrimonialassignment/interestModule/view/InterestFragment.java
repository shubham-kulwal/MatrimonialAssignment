package matrimonial.assignment.com.matrimonialassignment.interestModule.view;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.adapter.BlockUserListAdapter;
import matrimonial.assignment.com.matrimonialassignment.adapter.InterestPagerAdapter;
import matrimonial.assignment.com.matrimonialassignment.adapter.MaleUserRequestListAdapter;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.view.BlockUserListFragment;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentInterestLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.interestModule.viewModel.InterestViewModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.view.ShortListUserListFragment;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;

public class InterestFragment extends BaseFragment {

    private View view;
    private FragmentInterestLayoutBinding binding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_interest_layout, null, false);
        view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.setViewModel(new InterestViewModel());
        binding.executePendingBindings();
        init();
    }

    private void init() {
        observeProgressDialog(binding.getViewModel());
        observeFinishActivity(binding.getViewModel());
        sendDataToViewModel();
        observeBlockUserListResponse();
        binding.getViewModel().getMaleUserRequest();
    }

    private void sendDataToViewModel() {
        binding.getViewModel().setHeaders(getHeaders());
    }


    private void observeBlockUserListResponse() {
       binding.getViewModel().getDataResponseMutableLiveData().observe(this, new Observer<List<DataResponse>>() {
           @Override
           public void onChanged(@Nullable List<DataResponse> dataResponses) {
               if (dataResponses.size()>0) {
                   binding.recyclerView.setVisibility(View.VISIBLE);
                   binding.noDataText.setVisibility(View.GONE);
                   MaleUserRequestListAdapter mAdapter = new MaleUserRequestListAdapter(getContext(), dataResponses);
                   RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                   binding.recyclerView.setLayoutManager(mLayoutManager);
                   binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
                   binding.recyclerView.setAdapter(mAdapter);
               }else {
                   binding.recyclerView.setVisibility(View.GONE);
                   binding.noDataText.setVisibility(View.VISIBLE);
               }
           }
       });
    }
}
