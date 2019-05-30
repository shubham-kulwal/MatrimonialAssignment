package matrimonial.assignment.com.matrimonialassignment.callbacks;

import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;

public interface OnItemClickListener {

    void onClick(DataResponse dataResp);
    void onMarkAsFavouriteClick(DataResponse dataResp,String tag,int position);
}
