package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.exploreModule.model.ExploreModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.BlockUserAndroidDtos.BlockUserAndroidRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.BlockUserAndroidDtos.BlockUserResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.request.SearchUserRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.SearchUserResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortlistUserDtos.ShortlistAndroidRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortlistUserDtos.ShortlistAndroidResponseObj;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.BLOCK_USER_API;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.SEARCH_USER_API;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.SHORLIST_USER_API;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class SearchUserApiService extends ApiService {

    public void callSearchUserApi(ExploreModel exploreModel){
        retrofitApiCall(getSearchUserRequestObj(exploreModel), SearchUserResponseObj.class,
                SEARCH_USER_API, exploreModel.getServiceID(), POST_METHOD,exploreModel.getHeaders());
    }

    private SearchUserRequestObj getSearchUserRequestObj(ExploreModel exploreModel){
        SearchUserRequestObj searchUserRequestObj = new SearchUserRequestObj();
        searchUserRequestObj.setRequestUserId(exploreModel.getRequestedID());
        return searchUserRequestObj;
    }

    public void callShortListUserApi(ExploreModel exploreModel){
        retrofitApiCall(getShortlistUserRequestObj(exploreModel), ShortlistAndroidResponseObj.class,
                SHORLIST_USER_API, exploreModel.getServiceID(), POST_METHOD,exploreModel.getHeaders());
    }

    private ShortlistAndroidRequestObj getShortlistUserRequestObj(ExploreModel exploreModel){
        ShortlistAndroidRequestObj shortlistAndroidRequestObj=new ShortlistAndroidRequestObj();
        shortlistAndroidRequestObj.setUserId(exploreModel.getUserID());
        shortlistAndroidRequestObj.setRequestUserId(exploreModel.getRequestedID());
        return shortlistAndroidRequestObj;
    }

    public void callBlockUserApi(ExploreModel exploreModel){
        retrofitApiCall(getBlockUserAndroid(exploreModel), BlockUserResponseObj.class,
                BLOCK_USER_API, exploreModel.getServiceID(), POST_METHOD,exploreModel.getHeaders());
    }

    private BlockUserAndroidRequestObj getBlockUserAndroid(ExploreModel exploreModel){
        BlockUserAndroidRequestObj blockUserAndroidRequestObj=new BlockUserAndroidRequestObj();
        blockUserAndroidRequestObj.setBlockUserId(exploreModel.getrequestTo());
        blockUserAndroidRequestObj.setRequestUserId(exploreModel.getRequestedID());
        return blockUserAndroidRequestObj;
    }
}
