package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.serviceDtos.ExpressInterestAndroid.ExpressInterestAndroidRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.ExpressInterestAndroid.ExpressInterestAndroidResponseObj;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.model.UserDetailModel;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.EXPRESS_INTEREST_USER_API;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class ExpressInterestService extends ApiService {


    public void callExpressInterestApi(UserDetailModel userDetailModel) {
        retrofitApiCall(expressInterestRequestObj(userDetailModel), ExpressInterestAndroidResponseObj.class,
                EXPRESS_INTEREST_USER_API, userDetailModel.getServiceID(), POST_METHOD, userDetailModel.getHeaders());
    }

    private ExpressInterestAndroidRequestObj expressInterestRequestObj(UserDetailModel userDetailModel) {
        ExpressInterestAndroidRequestObj expressInterestAndroidRequestObj = new ExpressInterestAndroidRequestObj();
        expressInterestAndroidRequestObj.setRequestFrom(userDetailModel.getRequestedID());
        expressInterestAndroidRequestObj.setRequestTo(userDetailModel.getrequestTo());
        return expressInterestAndroidRequestObj;
    }
}
