package matrimonial.assignment.com.matrimonialassignment.interestModule.viewModel;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.interestModule.model.InterestModel;
import matrimonial.assignment.com.matrimonialassignment.service.MaleUserRequestService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos.MaleUserRequestResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;

public class InterestViewModel extends BaseViewModel {


    private InterestModel interestModel;
    private final int MALE_REQUEST_SERVICE_ID = 1;
    private MutableLiveData<List<DataResponse>> maleUserRequestLiveData = new MutableLiveData<>();
    private MaleUserRequestService maleUserRequestService;

    public InterestViewModel() {
        interestModel = new InterestModel();
        maleUserRequestService = new MaleUserRequestService();
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        interestModel.setHeaders(headers);
    }


    public void getMaleUserRequest() {
     //   setProgressDialog(Constants.ProgressDialog.SHOW_PROGRESS_DIALOG);
        observeApiResult(maleUserRequestService);
        interestModel.setRequestUserId(readInt(USER_ID));
        interestModel.setServiceId(MALE_REQUEST_SERVICE_ID);
        maleUserRequestService.callMaleRequestApi(interestModel);
    }

    public MutableLiveData<List<DataResponse>> getDataResponseMutableLiveData() {
        return maleUserRequestLiveData;
    }


    @Override
    public void responseSuccess(Result result) {
        switch (result.getServiceId()) {
            case MALE_REQUEST_SERVICE_ID:
                MaleUserRequestResponseObj maleUserRequestResponseObj = (MaleUserRequestResponseObj) result.getObject();
                if (maleUserRequestResponseObj.getStatus() && maleUserRequestResponseObj.getDataResponse() != null) {
                    maleUserRequestLiveData.setValue(maleUserRequestResponseObj.getDataResponse());
                }
                break;
        }
    }
}
