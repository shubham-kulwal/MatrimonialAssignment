package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.loginModule.model.LoginModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.request.LoginRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.LoginResponseObj;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.LOGIN_API;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class LoginApiService extends ApiService {

    public void callLoginApi(LoginModel loginModel){
        retrofitApiCall(loginApiRequestObj(loginModel), LoginResponseObj.class,
                LOGIN_API, loginModel.getServiceID(), POST_METHOD, getHeaders());
    }

    private LoginRequestObj loginApiRequestObj(LoginModel loginModel){
        LoginRequestObj loginRequestObj = new LoginRequestObj();
        loginRequestObj.setMobileNo(loginModel.getMobileNo());
        loginRequestObj.setPassword(loginModel.getPassword());
        return loginRequestObj;
    }

}
