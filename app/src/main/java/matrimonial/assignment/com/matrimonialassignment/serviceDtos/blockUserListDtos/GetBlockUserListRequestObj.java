
package matrimonial.assignment.com.matrimonialassignment.serviceDtos.blockUserListDtos;

import com.google.gson.annotations.SerializedName;

public class GetBlockUserListRequestObj {

    @SerializedName("RequestUserId")
    private int mRequestUserId;

    public int getRequestUserId() {
        return mRequestUserId;
    }

    public void setRequestUserId(int requestUserId) {
        mRequestUserId = requestUserId;
    }

}
