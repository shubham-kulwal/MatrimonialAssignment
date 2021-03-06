package matrimonial.assignment.com.matrimonialassignment.exploreModule.view;

import android.arch.lifecycle.Observer;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
import matrimonial.assignment.com.matrimonialassignment.utils.CommonMethods;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;

public class ExploreFragment extends BaseFragment {

    private FragmentExploreLayoutBinding binding;
    public static DataResponse dataResponse;
    private ListAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore_layout, null, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.setViewModel(new ExploreViewModel());
        binding.executePendingBindings();
        init();
    }

    private void init() {
        observeProgressDialog(binding.getViewModel());
        observeFinishActivity(binding.getViewModel());
        observeSearchResponse();
        sendDataToViewModel();
        binding.searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mAdapter != null) {
                    mAdapter.filterSearch(String.valueOf(s));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void observeSearchResponse() {
        binding.getViewModel().getDataResponseMutableLiveData().observe(this, new Observer<List<DataResponse>>() {
            @Override
            public void onChanged(@Nullable List<DataResponse> dataResponses) {
                mAdapter = new ListAdapter(getContext(), dataResponses, onItemClickListener);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
                binding.recyclerView.setLayoutManager(mLayoutManager);
                binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
                binding.recyclerView.setAdapter(mAdapter);
                binding.getViewModel().setProgressDialog(DISMISS_PROGRESS_DIALOG);
                binding.searchingLl.setVisibility(View.VISIBLE);
            }
        });
    }

    private void sendDataToViewModel() {
        binding.getViewModel().setHeaders(getHeaders());
    }

    OnItemClickListener onItemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(DataResponse dataResp) {
            dataResponse = dataResp;
            callActivity(getContext(), UserDetailsActivity.class);
        }

        @Override
        public void onMarkAsFavouriteClick(final DataResponse dataResp, final String tag, final int position) {
            String message = "Are you sure, you want to mark this user as " + tag;
            CommonMethods.showDialog(getActivity(), message, "YES", "CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    binding.getViewModel().callShortlistUser(dataResp.getUserId());
                }
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }, false);
        }

        @Override
        public void onExpressInterestClick(DataResponse dataResp) {
            showDialog("Are you sure you want to express interest to this user?", "Express Interest", dataResp.getUserId());
        }

        @Override
        public void blockUser(DataResponse dataResp) {
            showDialog("Are you sure you want to block this user?", "Block", dataResp.getUserId());
        }
    };

    private void showDialog(String message, final String positiveLabel, final int userId) {
        CommonMethods.showDialog(getActivity(), message, positiveLabel, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (positiveLabel.equalsIgnoreCase("Block")){
                    binding.getViewModel().callBlockUserApi(userId);
                }else {
                    binding.getViewModel().callExpressInterestApi(userId);
                }
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.getViewModel().getUsers();
    }


}
