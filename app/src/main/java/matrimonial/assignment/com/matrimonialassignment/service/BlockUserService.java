package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.model.UserDetailModel;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.LOGIN_API;

public class BlockUserService extends ApiService {

    public void callLoginApi(UserDetailModel userDetailModel){
        retrofitApiCall(loginApiRequestObj(userDetailModel), LoginResponseObj.class,
                LOGIN_API, loginModel.getServiceID(), POST_METHOD, getHeaders());
    }

    private LoginRequestObj loginApiRequestObj(LoginModel loginModel){
        LoginRequestObj loginRequestObj = new LoginRequestObj();
        loginRequestObj.setMobileNo(loginModel.getMobileNo());
        loginRequestObj.setPassword(loginModel.getPassword());
        return loginRequestObj;
    }
}
