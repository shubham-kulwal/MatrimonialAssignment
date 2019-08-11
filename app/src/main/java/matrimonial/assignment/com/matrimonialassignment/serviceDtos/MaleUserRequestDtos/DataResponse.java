
package matrimonial.assignment.com.matrimonialassignment.serviceDtos.MaleUserRequestDtos;


import com.google.gson.annotations.SerializedName;


public class DataResponse {

    @SerializedName("Address")
    private String mAddress;
    @SerializedName("CastId")
    private Long mCastId;
    @SerializedName("CastName")
    private String mCastName;
    @SerializedName("InOut")
    private String mInOut;
    @SerializedName("ReligionId")
    private Long mReligionId;
    @SerializedName("ReligionName")
    private String mReligionName;
    @SerializedName("RequestDate")
    private String mRequestDate;
    @SerializedName("RequestFrom")
    private Long mRequestFrom;
    @SerializedName("RequestId")
    private Long mRequestId;
    @SerializedName("RequestStatus")
    private String mRequestStatus;
    @SerializedName("RequestTo")
    private Long mRequestTo;
    @SerializedName("UserName")
    private String mUserName;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public Long getCastId() {
        return mCastId;
    }

    public void setCastId(Long castId) {
        mCastId = castId;
    }

    public String getCastName() {
        return mCastName;
    }

    public void setCastName(String castName) {
        mCastName = castName;
    }

    public String getInOut() {
        return mInOut;
    }

    public void setInOut(String inOut) {
        mInOut = inOut;
    }

    public Long getReligionId() {
        return mReligionId;
    }

    public void setReligionId(Long religionId) {
        mReligionId = religionId;
    }

    public String getReligionName() {
        return mReligionName;
    }

    public void setReligionName(String religionName) {
        mReligionName = religionName;
    }

    public String getRequestDate() {
        return mRequestDate;
    }

    public void setRequestDate(String requestDate) {
        mRequestDate = requestDate;
    }

    public Long getRequestFrom() {
        return mRequestFrom;
    }

    public void setRequestFrom(Long requestFrom) {
        mRequestFrom = requestFrom;
    }

    public Long getRequestId() {
        return mRequestId;
    }

    public void setRequestId(Long requestId) {
        mRequestId = requestId;
    }

    public String getRequestStatus() {
        return mRequestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        mRequestStatus = requestStatus;
    }

    public Long getRequestTo() {
        return mRequestTo;
    }

    public void setRequestTo(Long requestTo) {
        mRequestTo = requestTo;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

}
