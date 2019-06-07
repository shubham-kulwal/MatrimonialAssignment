package matrimonial.assignment.com.matrimonialassignment.blockUserListModule.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.viewModel.BlockUserListViewModel;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentBlockuserListLayoutBinding;

public class BlockUserListFragment extends BaseFragment {

    private FragmentBlockuserListLayoutBinding fragmentBlockuserListLayoutBinding;

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
        sendDataToViewModel();
    }

    private void sendDataToViewModel() {
        fragmentBlockuserListLayoutBinding.getViewModel().setHeaders(getHeaders());
    }

    private void init() {
        observeProgressDialog(fragmentBlockuserListLayoutBinding.getViewModel());
        observeFinishActivity(fragmentBlockuserListLayoutBinding.getViewModel());
        observeSearchResponse();
        fragmentBlockuserListLayoutBinding.getViewModel().getBlockUsersList();

    }

    private void observeSearchResponse() {
      //  fragmentBlockuserListLayoutBinding.getViewModel()
    }
}
