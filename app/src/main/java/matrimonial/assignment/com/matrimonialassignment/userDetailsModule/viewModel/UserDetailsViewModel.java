package matrimonial.assignment.com.matrimonialassignment.userDetailsModule.viewModel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.view.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.service.ExpressInterestService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.ExpressInterestAndroid.ExpressInterestAndroidResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.model.UserDetailModel;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view.UserDetailsActivity;
import matrimonial.assignment.com.matrimonialassignment.utils.CommonMethods;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class UserDetailsViewModel extends BaseViewModel {

    public String name;
    private UserDetailsActivity activity;
    private ExpressInterestService expressInterestService;
    private UserDetailModel userDetailModel;
    private final int EXPRESS_INTEREST_SERVICEID = 1;
    public boolean hideExpressInterest = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetailsViewModel(UserDetailsActivity activity) {
        this.activity = activity;
        expressInterestService = new ExpressInterestService();
        userDetailModel = new UserDetailModel();
    }

    public void blockUserClick() {
        showDialog("Are you sure you want to block this user?", "Block");
    }

    private void callBlockUserApi() {

    }

    private void callExpressInterestApi() {
        observeApiResult(expressInterestService);
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        userDetailModel.setServiceID(EXPRESS_INTEREST_SERVICEID);
        userDetailModel.setRequestedID(readInt(USER_ID));
        userDetailModel.setrequestTo(ExploreFragment.dataResponse.getUserId());
        expressInterestService.callExpressInterestApi(userDetailModel);
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        userDetailModel.setHeaders(headers);
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
                else
                    callExpressInterestApi();
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

        switch (result.getServiceId()) {

            case EXPRESS_INTEREST_SERVICEID:
                ExpressInterestAndroidResponseObj expressInterestAndroidResponseObj = (ExpressInterestAndroidResponseObj) result.getObject();
                if (expressInterestAndroidResponseObj.getStatus())
                    setToastMessage("Request Send");
                activity.hideExpressInterest();
                setProgressDialog(DISMISS_PROGRESS_DIALOG);
                break;
        }
    }
}
