
package matrimonial.assignment.com.matrimonialassignment.serviceDtos.BlockUserAndroidDtos;


import com.google.gson.annotations.SerializedName;


public class BlockUserAndroidRequestObj {

    @SerializedName("BlockUserId")
    private Long mBlockUserId;
    @SerializedName("IsBlocked")
    private Boolean mIsBlocked;
    @SerializedName("RequestUserId")
    private Long mRequestUserId;

    public Long getBlockUserId() {
        return mBlockUserId;
    }

    public void setBlockUserId(Long blockUserId) {
        mBlockUserId = blockUserId;
    }

    public Boolean getIsBlocked() {
        return mIsBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        mIsBlocked = isBlocked;
    }

    public Long getRequestUserId() {
        return mRequestUserId;
    }

    public void setRequestUserId(Long requestUserId) {
        mRequestUserId = requestUserId;
    }

}
