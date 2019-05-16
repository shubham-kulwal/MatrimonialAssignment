package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.loginModule.model.LoginModel;
import matrimonial.assignment.com.matrimonialassignment.registrationModule.model.RegistrationModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.request.LoginRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.LoginResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.registerDtos.RegisterUserRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.registerDtos.RegisterUserResponseObj;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.LOGIN_API;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.REGISTER_USER_API;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class RegisterApiService extends ApiService {

    public void callRegisterApi(RegistrationModel registrationModel){
        retrofitApiCall(registerApiRequestObj(registrationModel), RegisterUserResponseObj.class,
                REGISTER_USER_API, registrationModel.getServiceID(), POST_METHOD,getHeaders());
    }

    private RegisterUserRequestObj registerApiRequestObj(RegistrationModel registrationModel){
        RegisterUserRequestObj registerApiRequestObj = new RegisterUserRequestObj();
        registerApiRequestObj.setFirstName(registrationModel.getName());
        registerApiRequestObj.setMiddleName(registrationModel.getMiddleName());
        registerApiRequestObj.setLastName(registrationModel.getLastName());
        registerApiRequestObj.setEmail(registrationModel.getEmail());
        registerApiRequestObj.setGender(registrationModel.getGender());
        registerApiRequestObj.setMobileNo(registrationModel.getMobile());
        registerApiRequestObj.setPassword(registrationModel.getPassword());
        registerApiRequestObj.setConfirmPassword(registrationModel.getConfirmPassword());
        registerApiRequestObj.setBehalfOf("Self");
       // registerApiRequestObj.setAgentId(registrationModel.getMiddleName());
        return registerApiRequestObj;
    }


}
