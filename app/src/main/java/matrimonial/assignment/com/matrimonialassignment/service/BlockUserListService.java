package matrimonial.assignment.com.matrimonialassignment.service;

import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.BlockUserListResponseObj;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos.GetBlockUserListRequestObj;
import matrimonial.assignment.com.matrimonialassignment.shortListModule.model.ShortListModel;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APILIST.GET_BLOCK_USER_LIST;
import static savysoft.accl.utils.Constants.ApiMethods.POST_METHOD;

public class BlockUserListService extends ApiService {

    public void callBlockUserListApi(ShortListModel shortListModel){
        retrofitApiCall(blockUserListRequestObj(shortListModel), BlockUserListResponseObj.class,
                GET_BLOCK_USER_LIST, shortListModel.getServiceId(), POST_METHOD, shortListModel.getHeaders());
    }

    private GetBlockUserListRequestObj blockUserListRequestObj(ShortListModel shortListModel){
        GetBlockUserListRequestObj getBlockUserListRequestObj = new GetBlockUserListRequestObj();
        getBlockUserListRequestObj.setRequestUserId(shortListModel.getRequestUserId());
        return getBlockUserListRequestObj;
    }
}
