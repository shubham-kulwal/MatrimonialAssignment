package matrimonial.assignment.com.matrimonialassignment.interestModule.viewModel;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.interestModule.model.InterestModel;
import matrimonial.assignment.com.matrimonialassignment.service.BlockUserListService;
import matrimonial.assignment.com.matrimonialassignment.service.ShortListedUserService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.BlockUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.shortListedUserModule.model.ShortListedUserModel;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class InterestViewModel extends BaseViewModel {


    private InterestModel interestModel;
    private ShortListedUserService shortListedUserService;
    private final int SHORTLISTED_USER_LIST = 1;
    private MutableLiveData<List<DataResponse>> shortListUserMutableLiveData;
    private MutableLiveData<List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse>> blockUserListMutableLiveData;
    private BlockUserListService blockUserListService;
    private final int BLOCK_USER_LIST = 2;

    public InterestViewModel() {
        interestModel = new InterestModel();
        shortListedUserService = new ShortListedUserService();
        blockUserListService = new BlockUserListService();
        shortListUserMutableLiveData = new MutableLiveData<>();
        blockUserListMutableLiveData = new MutableLiveData<>();
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        interestModel.setHeaders(headers);
    }

    public void getShortListedUsers() {
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        observeApiResult(shortListedUserService);
        interestModel.setRequestUserId(readInt(USER_ID));
        interestModel.setServiceId(SHORTLISTED_USER_LIST);
       // shortListedUserService.callShortListedUserListApi(interestModel);
    }

    public void getBlockUsersList() {
        observeApiResult(blockUserListService);
        interestModel.setRequestUserId(readInt(USER_ID));
        interestModel.setServiceId(BLOCK_USER_LIST);
     //   blockUserListService.callBlockUserListApi(interestModel);
    }

    public MutableLiveData<List<DataResponse>> getDataResponseMutableLiveData(){
        return shortListUserMutableLiveData;
    }

    public MutableLiveData<List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse>> getBlockUserListMutableLiveData(){
        return blockUserListMutableLiveData;
    }


    @Override
    public void responseSuccess(Result result) {
        switch (result.getServiceId()){
            case SHORTLISTED_USER_LIST:
                GetShortListedUserListResponseObj getShortListedUserListResponseObj = (GetShortListedUserListResponseObj) result.getObject();
                if (getShortListedUserListResponseObj!=null){
                    shortListUserMutableLiveData.setValue(getShortListedUserListResponseObj.getDataResponse());
                }
                break;

            case BLOCK_USER_LIST:
                BlockUserListResponseObj blockUserListResponseObj = (BlockUserListResponseObj) result.getObject();
                if (blockUserListResponseObj!=null){
                    blockUserListMutableLiveData.setValue(blockUserListResponseObj.getDataResponse());
                }
                break;
        }
    }
}
