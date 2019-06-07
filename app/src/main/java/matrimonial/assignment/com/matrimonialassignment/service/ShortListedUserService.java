package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.model.ShortListedUserModel;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.GET_SHORTLISTED_USER_LIST;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class ShortListedUserService extends ApiService {

    public void callShortListedUserListApi(ShortListedUserModel shortListedUserModel){
        retrofitApiCall(shortListedUserListRequestObj(shortListedUserModel), GetShortListedUserListResponseObj.class,
                GET_SHORTLISTED_USER_LIST, shortListedUserModel.getServiceId(), POST_METHOD, shortListedUserModel.getHeaders());
    }

    private GetShortListedUserListRequestObj shortListedUserListRequestObj(ShortListedUserModel shortListedUserModel){
        GetShortListedUserListRequestObj getShortListedUserListRequestObj = new GetShortListedUserListRequestObj();
        getShortListedUserListRequestObj.setRequestUserId(shortListedUserModel.getRequestUserId());
        return getShortListedUserListRequestObj;
    }
}
