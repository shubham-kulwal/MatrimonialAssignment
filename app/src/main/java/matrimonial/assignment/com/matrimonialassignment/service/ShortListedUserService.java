package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.interestModule.model.InterestModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.shortListModule.model.ShortListModel;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.model.ShortListedUserModel;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.GET_SHORTLISTED_USER_LIST;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class ShortListedUserService extends ApiService {

    public void callShortListedUserListApi(ShortListModel shortListModel){
        retrofitApiCall(shortListedUserListRequestObj(shortListModel), GetShortListedUserListResponseObj.class,
                GET_SHORTLISTED_USER_LIST, shortListModel.getServiceId(), POST_METHOD, shortListModel.getHeaders());
    }

    private GetShortListedUserListRequestObj shortListedUserListRequestObj(ShortListModel shortListModel){
        GetShortListedUserListRequestObj getShortListedUserListRequestObj = new GetShortListedUserListRequestObj();
        getShortListedUserListRequestObj.setRequestUserId(shortListModel.getRequestUserId());
        return getShortListedUserListRequestObj;
    }
}
