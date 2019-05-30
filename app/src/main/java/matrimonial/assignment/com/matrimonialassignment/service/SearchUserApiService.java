package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.exploreModule.model.ExploreModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.request.SearchUserRequestObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.SearchUserResponseObj;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.SEARCH_USER_API;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class SearchUserApiService extends ApiService {

    public void callSearchUserApi(ExploreModel exploreModel){
        retrofitApiCall(getSearchUserRequestObj(exploreModel), SearchUserResponseObj.class,
                SEARCH_USER_API, exploreModel.getServiceID(), POST_METHOD,exploreModel.getHeaders());
    }

    private SearchUserRequestObj getSearchUserRequestObj(ExploreModel exploreModel){
        SearchUserRequestObj searchUserRequestObj = new SearchUserRequestObj();
        searchUserRequestObj.setPageNo(1);
        searchUserRequestObj.setPageSize("50");
        searchUserRequestObj.setRequestUserId(exploreModel.getRequestedID());
        return searchUserRequestObj;
    }

    public void callShortListUserApi(ExploreModel exploreModel){
        retrofitApiCall(getSearchUserRequestObj(exploreModel), SearchUserResponseObj.class,
                SEARCH_USER_API, exploreModel.getServiceID(), POST_METHOD,exploreModel.getHeaders());
    }

    private SearchUserRequestObj getShortlistUserRequestObj(ExploreModel exploreModel){
        SearchUserRequestObj searchUserRequestObj = new SearchUserRequestObj();
        searchUserRequestObj.setPageNo(1);
        searchUserRequestObj.setPageSize("50");
        searchUserRequestObj.setRequestUserId(exploreModel.getRequestedID());
        return searchUserRequestObj;
    }
}
