package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.blockUserListModule.model.BlockUserListModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.BlockUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.GetBlockUserListRequestObj;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.GET_BLOCK_USER_LIST;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class BlockUserListService extends ApiService {

    public void callBlockUserListApi(BlockUserListModel blockUserListModel){
        retrofitApiCall(blockUserListRequestObj(blockUserListModel), BlockUserListResponseObj.class,
                GET_BLOCK_USER_LIST, blockUserListModel.getServiceId(), POST_METHOD, getHeaders());
    }

    private GetBlockUserListRequestObj blockUserListRequestObj(BlockUserListModel blockUserListModel){
        GetBlockUserListRequestObj getBlockUserListRequestObj = new GetBlockUserListRequestObj();
        getBlockUserListRequestObj.setRequestUserId(blockUserListModel.getRequestUserId());
        return getBlockUserListRequestObj;
    }
}
