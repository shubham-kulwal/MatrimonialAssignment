package matrimonial.assignment.com.matrimonialassignment.registrationModule.viewModel;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.RadioGroup;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.activity.DashBoardActivity;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.loginModule.view.LoginActivity;
import matrimonial.assignment.com.matrimonialassignment.registrationModule.model.RegistrationModel;
import matrimonial.assignment.com.matrimonialassignment.service.RegisterApiService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.LoginResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.registerDtos.RegisterUserResponseObj;

import static android.text.TextUtils.isEmpty;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.FINISH;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class RegistrationViewModel extends BaseViewModel {
    private RegistrationModel registrationModel;
    private RegisterApiService registerApiService;
    public static final int REGISTER_SERVICE_ID = 0;

    public RegistrationViewModel() {
        registrationModel = new RegistrationModel();
        registerApiService = new RegisterApiService();
    }


    public void setName(CharSequence s) {
        registrationModel.setName(s.toString());
    }

    public void setMiddleName(CharSequence s) {
        registrationModel.setMiddleName(s.toString());
    }

    public void setLastName(CharSequence s) {
        registrationModel.setLastName(s.toString());
    }


    public void setEmail(CharSequence s) {
        registrationModel.setEmail(s.toString());
    }


    public void setPassword(CharSequence s) {
        registrationModel.setPassword(s.toString());
    }


    public void setConfirmPassword(CharSequence s) {
        registrationModel.setConfirmPassword(s.toString());
    }


    public void setMobile(CharSequence s) {
        registrationModel.setMobile(s.toString());
    }

    public void onRegisterClick(){
        if (validateFields()){
            observeApiResult(registerApiService);
            callRegisterApi();
        }
    }

    private void callRegisterApi() {
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        registrationModel.setServiceID(REGISTER_SERVICE_ID);
        registerApiService.callRegisterApi(registrationModel);
    }

    public void onCheckChanged(RadioGroup radioGroup, int id) {

        switch (id){
            case R.id.male:
                registrationModel.setGender("M");
                break;

            case R.id.female:
                registrationModel.setGender("F");
                break;
        }
    }


    private boolean validateFields() {
        if (isEmpty(registrationModel.getName())){
            setToastMessage("Please Enter First Name");
            return false;
        }

        if (isEmpty(registrationModel.getMiddleName())){
            setToastMessage("Please Enter Middle Name");
            return false;
        }

        if (isEmpty(registrationModel.getLastName())){
            setToastMessage("Please Enter Last Name");
            return false;
        }


        if (!isEmpty(registrationModel.getEmail()) && !isValidEmail(registrationModel.getEmail())){
            setToastMessage("Please Valid Email");
            return false;
        }

        if (isEmpty(registrationModel.getMobile())){
            setToastMessage("Please Enter Mobile no");
            return false;
        }

        if (isEmpty(registrationModel.getGender())){
            setToastMessage("Please Select Gender");
            return false;
        }

        if (isEmpty(registrationModel.getPassword())){
            setToastMessage("Please Enter Password");
            return false;
        }

        if (isEmpty(registrationModel.getConfirmPassword())){
            setToastMessage("Please Enter Confirm Password");
            return false;
        }

        if (!registrationModel.getPassword().equals(registrationModel.getConfirmPassword())){
            setToastMessage("Password and confirm password should match");
            return false;
        }
        return true;
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public void responseSuccess(Result result) {

        switch (result.getServiceId()){

            case REGISTER_SERVICE_ID:
                RegisterUserResponseObj registerUserResponseObj = (RegisterUserResponseObj) result.getObject();
                setProgressDialog(DISMISS_PROGRESS_DIALOG);
                if (registerUserResponseObj != null && registerUserResponseObj.isStatus()){
                    setToastMessage(registerUserResponseObj.getErrorMessage());
                    setCallActivity(LoginActivity.class);
                    setFinishActivity(FINISH);
                }else {
                    setToastMessage(registerUserResponseObj.getErrorMessage());
                }
                break;
        }
    }
}
