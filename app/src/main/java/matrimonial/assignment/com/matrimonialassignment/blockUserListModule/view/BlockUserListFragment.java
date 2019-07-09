package matrimonial.assignment.com.matrimonialassignment.blockUserListModule.view;

import android.annotation.SuppressLint;
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
import matrimonial.assignment.com.matrimonialassignment.adapter.BlockUserListAdapter;
import matrimonial.assignment.com.matrimonialassignment.adapter.ShortListedUserAdapter;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.viewModel.BlockUserListViewModel;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentBlockuserListLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse;

@SuppressLint("ValidFragment")
public class BlockUserListFragment extends BaseFragment {

    private FragmentBlockuserListLayoutBinding fragmentBlockuserListLayoutBinding;
    private List<DataResponse> blockUserList;

    @SuppressLint("ValidFragment")
    public BlockUserListFragment(List<DataResponse> blockUserList) {
        super();
        this.blockUserList = new ArrayList<>();
        this.blockUserList.addAll(blockUserList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBlockuserListLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_blockuser_list_layout, null, false);
        View view = fragmentBlockuserListLayoutBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentBlockuserListLayoutBinding.setViewModel(new BlockUserListViewModel());
        fragmentBlockuserListLayoutBinding.executePendingBindings();
        init();
    }


    private void init() {
        if (blockUserList.size() == 0) {
            fragmentBlockuserListLayoutBinding.noDataAvailableTv.setVisibility(View.VISIBLE);
            fragmentBlockuserListLayoutBinding.recyclerView.setVisibility(View.GONE);
        } else {
            fragmentBlockuserListLayoutBinding.recyclerView.setVisibility(View.VISIBLE);
            fragmentBlockuserListLayoutBinding.noDataAvailableTv.setVisibility(View.VISIBLE);
            BlockUserListAdapter mAdapter = new BlockUserListAdapter(getContext(), blockUserList);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            fragmentBlockuserListLayoutBinding.recyclerView.setLayoutManager(mLayoutManager);
            fragmentBlockuserListLayoutBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
            fragmentBlockuserListLayoutBinding.recyclerView.setAdapter(mAdapter);
        }
    }
}