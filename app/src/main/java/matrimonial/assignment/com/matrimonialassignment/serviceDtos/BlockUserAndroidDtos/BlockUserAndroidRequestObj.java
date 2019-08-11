
package matrimonial.assignment.com.matrimonialassignment.serviceDtos.BlockUserAndroidDtos;

import com.google.gson.annotations.SerializedName;


public class BlockUserAndroidRequestObj {

    @SerializedName("BlockUserId")
    private int mBlockUserId;
    @SerializedName("RequestUserId")
    private int mRequestUserId;

    public int getBlockUserId() {
        return mBlockUserId;
    }

    public void setBlockUserId(int blockUserId) {
        mBlockUserId = blockUserId;
    }

    public int getRequestUserId() {
        return mRequestUserId;
    }

    public void setRequestUserId(int requestUserId) {
        mRequestUserId = requestUserId;
    }

}
