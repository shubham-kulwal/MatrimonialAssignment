package matrimonial.assignment.com.matrimonialassignment.userDetailsModule.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view.UserDetailsActivity;
import matrimonial.assignment.com.matrimonialassignment.utils.CommonMethods;

public class UserDetailsViewModel extends BaseViewModel {

    public String name;
    private Activity activity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetailsViewModel(UserDetailsActivity activity) {
        this.activity = activity;
    }

    public void blockUserClick() {
        showDialog("Are you sure you want to block this user?", "Block");
    }

    private void callBlockUserApi() {
        observeApiResult();
    }

    public void expressInterestClick() {
        showDialog("Are you sure you want to express interest to this user?", "Express Interest");
    }

    private void showDialog(String message, final String positiveLabel) {
        CommonMethods.showDialog(activity, message, positiveLabel, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (positiveLabel.equalsIgnoreCase("Block"))
                    callBlockUserApi();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }, false);
    }

    @Override
    public void responseSuccess(Result result) {

    }
}
