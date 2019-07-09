package matrimonial.assignment.com.matrimonialassignment.exploreModule.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.Bindable;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.callbacks.OnItemClickListener;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.model.ExploreModel;
import matrimonial.assignment.com.matrimonialassignment.service.SearchUserApiService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.SearchUserResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortlistUserDtos.ShortlistAndroidResponseObj;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view.UserDetailsActivity;
import savysoft.accl.interfaces.InternetConnectionInterface;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class ExploreViewModel extends BaseViewModel {

    private ExploreModel exploreModel;
    private SearchUserApiService searchUserApiService;
    private final int SEARCH_USER_LIST = 1;
    private final int SHORTLIST_USER_LIST = 2;
    private MutableLiveData<List<DataResponse>> dataResponseMutableLiveData;
    private MutableLiveData<Boolean> isFavouriteLiveData;

    public ExploreViewModel() {
        exploreModel = new ExploreModel();
        searchUserApiService = new SearchUserApiService();
        dataResponseMutableLiveData = new MutableLiveData<>();
        isFavouriteLiveData = new MutableLiveData<>();
       // super.internetConnectionInterface = internetConnectionInterface;
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        exploreModel.setHeaders(headers);
    }

    public void getUsers() {
        observeApiResult(searchUserApiService);
        callSearchUsersApi();
    }

    public void callShortlistUser(int userId){
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        exploreModel.setServiceID(SHORTLIST_USER_LIST);
        exploreModel.setRequestedID(readInt(USER_ID));
        exploreModel.setUserID(userId);
        searchUserApiService.callShortListUserApi(exploreModel);
    }

    private void callSearchUsersApi() {
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        exploreModel.setServiceID(SEARCH_USER_LIST);
        exploreModel.setRequestedID(readInt(USER_ID));
        searchUserApiService.callSearchUserApi(exploreModel);
    }
    public MutableLiveData<List<DataResponse>> getDataResponseMutableLiveData(){
        return dataResponseMutableLiveData;
    }
    public MutableLiveData<Boolean> getIsFavouriteLiveData(){
        return isFavouriteLiveData;
    }

    @Override
    public void responseSuccess(Result result) {

        switch (result.getServiceId()){

            case SEARCH_USER_LIST:
                SearchUserResponseObj searchUserResponseObj = (SearchUserResponseObj) result.getObject();
                if (searchUserResponseObj!=null){
                    dataResponseMutableLiveData.setValue(searchUserResponseObj.getDataResponse());
                }
                break;

            case SHORTLIST_USER_LIST:
                ShortlistAndroidResponseObj response = (ShortlistAndroidResponseObj) result.getObject();
                callSearchUsersApi();
                break;
        }
    }


    /*@Bindable
    InternetConnectionInterface internetConnectionInterface = new InternetConnectionInterface() {
        @Override
        public void internetConnectionRetryClick(int serviceId) {

        }
    };*/

}
