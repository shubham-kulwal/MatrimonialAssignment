package matrimonial.assignment.com.matrimonialassignment.exploreModule.view;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.adapter.ListAdapter;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.callbacks.OnItemClickListener;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentExploreLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.viewModel.ExploreViewModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view.UserDetailsActivity;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;

public class ExploreFragment extends BaseFragment {

    private FragmentExploreLayoutBinding fragmentExploreLayoutBinding;
    public static DataResponse dataResponse;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentExploreLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore_layout, null, false);
        View view = fragmentExploreLayoutBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentExploreLayoutBinding.setViewModel(new ExploreViewModel());
        fragmentExploreLayoutBinding.executePendingBindings();
        init();
        fragmentExploreLayoutBinding.getViewModel().getUsers();
    }

    private void init() {
        observeProgressDialog(fragmentExploreLayoutBinding.getViewModel());
        observeFinishActivity(fragmentExploreLayoutBinding.getViewModel());
        observeSearchResponse();
        sendDataToViewModel();
    }

    private void observeSearchResponse() {
        fragmentExploreLayoutBinding.getViewModel().getDataResponseMutableLiveData().observe(this, new Observer<List<DataResponse>>() {
            @Override
            public void onChanged(@Nullable List<DataResponse> dataResponses) {
                ListAdapter mAdapter = new ListAdapter(getContext(), dataResponses,onItemClickListener);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                fragmentExploreLayoutBinding.recyclerView.setLayoutManager(mLayoutManager);
                fragmentExploreLayoutBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
                fragmentExploreLayoutBinding.recyclerView.setAdapter(mAdapter);
                fragmentExploreLayoutBinding.getViewModel().setProgressDialog(DISMISS_PROGRESS_DIALOG);
            }
        });
    }

    private void sendDataToViewModel() {
        fragmentExploreLayoutBinding.getViewModel().setHeaders(getHeaders());
    }

    OnItemClickListener onItemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(DataResponse dataResp) {
            dataResponse = dataResp;
            callActivity(getContext(), UserDetailsActivity.class);
        }
    };

}