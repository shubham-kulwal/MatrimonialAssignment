package matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.viewModel;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.service.ShortListedUserService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.model.ShortListedUserModel;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class ShortListedUserListViewModel extends BaseViewModel {

    private ShortListedUserModel shortListedUserModel;
    private ShortListedUserService shortListedUserService;
    private final int SHORTLISTED_USER_LIST = 1;
    private MutableLiveData<List<DataResponse>> dataResponseMutableLiveData;

    public ShortListedUserListViewModel() {
        shortListedUserModel = new ShortListedUserModel();
        shortListedUserService = new ShortListedUserService();
        dataResponseMutableLiveData = new MutableLiveData<>();
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        shortListedUserModel.setHeaders(headers);
    }

    public void getShortListedUsers() {
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        observeApiResult(shortListedUserService);
        shortListedUserModel.setRequestUserId(readInt(USER_ID));
        shortListedUserModel.setServiceId(SHORTLISTED_USER_LIST);
        shortListedUserService.callShortListedUserListApi(shortListedUserModel);
    }

    public MutableLiveData<List<DataResponse>> getDataResponseMutableLiveData(){
        return dataResponseMutableLiveData;
    }


    @Override
    public void responseSuccess(Result result) {
        switch (result.getServiceId()){
            case SHORTLISTED_USER_LIST:
                GetShortListedUserListResponseObj getShortListedUserListResponseObj = (GetShortListedUserListResponseObj) result.getObject();
                if (getShortListedUserListResponseObj!=null){
                    setProgressDialog(DISMISS_PROGRESS_DIALOG);
                    dataResponseMutableLiveData.setValue(getShortListedUserListResponseObj.getDataResponse());
                }
                break;
        }
    }
}
