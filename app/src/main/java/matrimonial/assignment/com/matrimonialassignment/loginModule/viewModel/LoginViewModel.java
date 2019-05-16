package matrimonial.assignment.com.matrimonialassignment.loginModule.viewModel;

import android.text.TextUtils;

import matrimonial.assignment.com.matrimonialassignment.activity.DashBoardActivity;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.loginModule.model.LoginModel;
import matrimonial.assignment.com.matrimonialassignment.service.LoginApiService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.LoginResponseObj;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.FINISH;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class LoginViewModel extends BaseViewModel {
    private LoginModel loginModel;
    private LoginApiService loginService;
    public static final int LOGIN_API_SERVICE_ID = 0;

    public LoginViewModel() {
        loginModel = new LoginModel();
        loginService = new LoginApiService();
        observeApiResult(loginService);
    }

    public void afterMobileTextChanged(CharSequence s) {
        loginModel.setMobileNo(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        loginModel.setPassword(s.toString());
    }

    public void onSignInClicked() {
        if (validateLoginFields(loginModel.getMobileNo(), loginModel.getPassword())) {
            callLoginApi();
        }
    }

    private void callLoginApi() {
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        loginModel.setServiceID(LOGIN_API_SERVICE_ID);
        loginService.callLoginApi(loginModel);
    }

    private boolean validateLoginFields(String mobileNo, String password) {
        if (TextUtils.isEmpty(mobileNo)) {
            setToastMessage("Please entersetProgressDialog(SHOW_PROGRESS_DIALOG); mobile no");
            return false;
        }
        if (mobileNo.length() != 10) {
            setToastMessage("Please enter valid mobile no");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            setToastMessage("Please enter password");
            return false;
        }
        return true;
    }


    @Override
    public void responseSuccess(Result result) {

        switch (result.getServiceId()) {

            case LOGIN_API_SERVICE_ID:
                LoginResponseObj loginResponseObj = (LoginResponseObj) result.getObject();
                setProgressDialog(DISMISS_PROGRESS_DIALOG);
                if (loginResponseObj != null && loginResponseObj.getStatus()) {
                    SharedPrefManager.writeInt(SharedPrefManager.NAVIGATION_VALUE,1);
                    SharedPrefManager.writeInt(SharedPrefManager.USER_ID,loginResponseObj.getDataResponse().get(0).getUserId());
                    setToastMessage("Success");
                    setCallActivity(DashBoardActivity.class);
                    setFinishActivity(FINISH);
                } else {
                    setToastMessage(loginResponseObj.getErrorMessage());
                }
                break;

        }
    }
}
