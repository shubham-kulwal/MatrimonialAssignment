
package matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos;

import com.google.gson.annotations.SerializedName;


public class MaleUserRequestObj {

    @SerializedName("RequestUserId")
    private int mRequestUserId;

    public int getRequestUserId() {
        return mRequestUserId;
    }

    public void setRequestUserId(int requestUserId) {
        mRequestUserId = requestUserId;
    }

}
