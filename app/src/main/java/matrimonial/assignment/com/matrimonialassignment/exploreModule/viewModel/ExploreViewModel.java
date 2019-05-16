package matrimonial.assignment.com.matrimonialassignment.exploreModule.viewModel;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.model.ExploreModel;
import matrimonial.assignment.com.matrimonialassignment.service.SearchUserApiService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.SearchUserResponseObj;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class ExploreViewModel extends BaseViewModel {

    private ExploreModel exploreModel;
    private SearchUserApiService searchUserApiService;
    private final int SEARCH_USER_LIST = 1;
    private MutableLiveData<List<DataResponse>> dataResponseMutableLiveData;

    public ExploreViewModel() {
        exploreModel = new ExploreModel();
        searchUserApiService = new SearchUserApiService();
        dataResponseMutableLiveData = new MutableLiveData<>();
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        exploreModel.setHeaders(headers);
    }

    public void getUsers() {
        callSearchUsersApi();
    }

    private void callSearchUsersApi() {
        observeApiResult(searchUserApiService);
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        exploreModel.setServiceID(SEARCH_USER_LIST);
        exploreModel.setRequestedID(SharedPrefManager.readInt(SharedPrefManager.USER_ID));
        searchUserApiService.callSearchUserApi(exploreModel);
    }
    public MutableLiveData<List<DataResponse>> getDataResponseMutableLiveData(){
        return dataResponseMutableLiveData;
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
        }
    }


}
