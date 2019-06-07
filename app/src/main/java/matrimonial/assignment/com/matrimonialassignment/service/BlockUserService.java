package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.loginModule.model.LoginModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.request.LoginRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.LoginResponseObj;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.model.UserDetailModel;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.LOGIN_API;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class BlockUserService extends ApiService {

   /* public void callLoginApi(UserDetailModel userDetailModel){
        retrofitApiCall(loginApiRequestObj(userDetailModel), LoginResponseObj.class,
                LOGIN_API, userDetailModel.getServiceID(), POST_METHOD, getHeaders());
    }

    private LoginRequestObj loginApiRequestObj(UserDetailModel userDetailModel){

    }*/
}
