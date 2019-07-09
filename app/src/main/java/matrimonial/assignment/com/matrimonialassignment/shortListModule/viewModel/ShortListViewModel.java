package matrimonial.assignment.com.matrimonialassignment.shortListModule.viewModel;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.service.BlockUserListService;
import matrimonial.assignment.com.matrimonialassignment.service.ShortListedUserService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.BlockUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos.GetShortListedUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.shortListModule.model.ShortListModel;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.SHOW_PROGRESS_DIALOG;

public class ShortListViewModel extends BaseViewModel {

    private ShortListModel shortListModel;
    private BlockUserListService blockUserListService;
    private final int BLOCK_USER_LIST = 2;
    private MutableLiveData<List<DataResponse>> shortListUserMutableLiveData;
    private MutableLiveData<List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse>> blockUserListMutableLiveData;
    private ShortListedUserService shortListedUserService;
    private final int SHORTLISTED_USER_LIST = 1;


    public ShortListViewModel() {
        shortListModel = new ShortListModel();
        shortListedUserService = new ShortListedUserService();
        blockUserListService = new BlockUserListService();
        shortListUserMutableLiveData = new MutableLiveData<>();
        blockUserListMutableLiveData = new MutableLiveData<>();
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        shortListModel.setHeaders(headers);
    }

    public void getBlockUsersList() {
        observeApiResult(blockUserListService);
        shortListModel.setRequestUserId(readInt(USER_ID));
        shortListModel.setServiceId(BLOCK_USER_LIST);
        blockUserListService.callBlockUserListApi(shortListModel);
    }

    public void getShortListedUsers() {
        setProgressDialog(SHOW_PROGRESS_DIALOG);
        observeApiResult(shortListedUserService);
        shortListModel.setRequestUserId(readInt(USER_ID));
        shortListModel.setServiceId(SHORTLISTED_USER_LIST);
        shortListedUserService.callShortListedUserListApi(shortListModel);
    }

    public MutableLiveData<List<DataResponse>> getDataResponseMutableLiveData(){
        return shortListUserMutableLiveData;
    }

    public MutableLiveData<List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.DataResponse>> getBlockUserListMutableLiveData(){
        return blockUserListMutableLiveData;
    }

    @Override
    public void responseSuccess(Result result) {
        switch (result.getServiceId()) {
            case BLOCK_USER_LIST:
                BlockUserListResponseObj blockUserListResponseObj = (BlockUserListResponseObj) result.getObject();
                if (blockUserListResponseObj != null) {
                    blockUserListMutableLiveData.setValue(blockUserListResponseObj.getDataResponse());
                    getShortListedUsers();
                }
                break;

            case SHORTLISTED_USER_LIST:
                GetShortListedUserListResponseObj getShortListedUserListResponseObj = (GetShortListedUserListResponseObj) result.getObject();
                if (getShortListedUserListResponseObj!=null){
                    shortListUserMutableLiveData.setValue(getShortListedUserListResponseObj.getDataResponse());
                }
                break;
        }
    }
}
