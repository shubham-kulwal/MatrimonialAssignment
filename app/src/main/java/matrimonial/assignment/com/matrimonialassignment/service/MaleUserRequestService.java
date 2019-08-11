package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.interestModule.model.InterestModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos.MaleUserRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos.MaleUserRequestResponseObj;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.GET_MALE_USER_REQUEST_LIST;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class MaleUserRequestService extends ApiService {

    public void callMaleRequestApi(InterestModel interestModel){
        retrofitApiCall(maleUserRequestObj(interestModel), MaleUserRequestResponseObj.class,
                GET_MALE_USER_REQUEST_LIST, interestModel.getServiceId(), POST_METHOD, interestModel.getHeaders());
    }

    private MaleUserRequestObj maleUserRequestObj(InterestModel interestModel){
        MaleUserRequestObj maleUserRequestObj = new MaleUserRequestObj();
        maleUserRequestObj.setRequestUserId(interestModel.getRequestUserId());
        return maleUserRequestObj;
    }
}
