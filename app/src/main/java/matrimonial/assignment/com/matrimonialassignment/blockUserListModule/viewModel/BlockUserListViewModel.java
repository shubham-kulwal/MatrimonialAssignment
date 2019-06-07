package matrimonial.assignment.com.matrimonialassignment.blockUserListModule.viewModel;

import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.model.BlockUserListModel;
import matrimonial.assignment.com.matrimonialassignment.service.BlockUserListService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.USER_ID;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;

public class BlockUserListViewModel extends BaseViewModel {

    private BlockUserListModel blockUserListModel;
    private BlockUserListService blockUserListService;
    private final int BLOCK_USER_LIST = 1;

    public BlockUserListViewModel() {
        this.blockUserListModel = new BlockUserListModel();
        this.blockUserListService = new BlockUserListService();
    }


    public void setHeaders(List<RetrofitHeaders> headers) {
        blockUserListModel.setHeaders(headers);
    }

    public void getBlockUsersList() {
        observeApiResult(blockUserListService);
        blockUserListModel.setRequestUserId(readInt(USER_ID));
        blockUserListModel.setServiceId(BLOCK_USER_LIST);
        blockUserListService.callBlockUserListApi(blockUserListModel);
    }

    @Override
    public void responseSuccess(Result result) {
        switch (result.getServiceId()){

            case BLOCK_USER_LIST:

                break;
        }
    }


}
