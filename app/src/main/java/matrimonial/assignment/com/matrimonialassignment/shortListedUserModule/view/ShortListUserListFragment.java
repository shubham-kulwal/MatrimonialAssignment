package matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.view;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.adapter.ShortListedUserAdapter;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentShortlistuserListLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.viewModel.ShortListedUserListViewModel;

@SuppressLint("ValidFragment")
public class ShortListUserListFragment extends BaseFragment {

    private FragmentShortlistuserListLayoutBinding fragmentShortlistuserListLayoutBinding;
    private List<DataResponse> shortListUserList;



    @SuppressLint("ValidFragment")
    public ShortListUserListFragment(List<DataResponse> shortListUserList) {
        super();
        this.shortListUserList = new ArrayList<>();
        this.shortListUserList.addAll(shortListUserList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentShortlistuserListLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shortlistuser_list_layout, null, false);
        View view = fragmentShortlistuserListLayoutBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentShortlistuserListLayoutBinding.setViewModel(new ShortListedUserListViewModel());
        fragmentShortlistuserListLayoutBinding.executePendingBindings();
        init();
    }

    private void init() {
       /* observeProgressDialog(fragmentShortlistuserListLayoutBinding.getViewModel());
        observeFinishActivity(fragmentShortlistuserListLayoutBinding.getViewModel());
        observeApiResponse();
        sendDataToViewModel();
        fragmentShortlistuserListLayoutBinding.getViewModel().getShortListedUsers();*/

        if (shortListUserList.size()==0){
            fragmentShortlistuserListLayoutBinding.noDataAvailableTv.setVisibility(View.VISIBLE);
            fragmentShortlistuserListLayoutBinding.recyclerView.setVisibility(View.GONE);
        }else {
            fragmentShortlistuserListLayoutBinding.recyclerView.setVisibility(View.VISIBLE);
            fragmentShortlistuserListLayoutBinding.noDataAvailableTv.setVisibility(View.VISIBLE);
            ShortListedUserAdapter mAdapter = new ShortListedUserAdapter(getContext(), shortListUserList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            fragmentShortlistuserListLayoutBinding.recyclerView.setLayoutManager(mLayoutManager);
            fragmentShortlistuserListLayoutBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
            fragmentShortlistuserListLayoutBinding.recyclerView.setAdapter(mAdapter);
        }
    }

   /* private void sendDataToViewModel() {
        fragmentShortlistuserListLayoutBinding.getViewModel().setHeaders(getHeaders());
    }*/

   /* private void observeApiResponse() {
        fragmentShortlistuserListLayoutBinding.getViewModel().getDataResponseMutableLiveData().observe(this, new Observer<List<DataResponse>>() {
            @Override
            public void onChanged(@Nullable List<DataResponse> dataResponses) {

            }
        });
    }*/

}
