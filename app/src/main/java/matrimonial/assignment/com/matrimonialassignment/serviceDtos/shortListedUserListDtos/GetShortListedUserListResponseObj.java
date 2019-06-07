
package matrimonial.assignment.com.matrimonialassignment.serviceDtos.shortListedUserListDtos;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GetShortListedUserListResponseObj {

    @SerializedName("CityList")
    private Object mCityList;
    @SerializedName("DataResponse")
    private List<DataResponse> mDataResponse;
    @SerializedName("ErrorMessage")
    private Object mErrorMessage;
    @SerializedName("FilePath")
    private Object mFilePath;
    @SerializedName("HeightList")
    private Object mHeightList;
    @SerializedName("HeightOrasList")
    private Object mHeightOrasList;
    @SerializedName("ModelObject")
    private Object mModelObject;
    @SerializedName("QualificationList")
    private Object mQualificationList;
    @SerializedName("Status")
    private Object mStatus;
    @SerializedName("UserCityList")
    private Object mUserCityList;
    @SerializedName("UserList")
    private Object mUserList;

    public Object getCityList() {
        return mCityList;
    }

    public void setCityList(Object cityList) {
        mCityList = cityList;
    }

    public List<DataResponse> getDataResponse() {
        return mDataResponse;
    }

    public void setDataResponse(List<DataResponse> dataResponse) {
        mDataResponse = dataResponse;
    }

    public Object getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        mErrorMessage = errorMessage;
    }

    public Object getFilePath() {
        return mFilePath;
    }

    public void setFilePath(Object filePath) {
        mFilePath = filePath;
    }

    public Object getHeightList() {
        return mHeightList;
    }

    public void setHeightList(Object heightList) {
        mHeightList = heightList;
    }

    public Object getHeightOrasList() {
        return mHeightOrasList;
    }

    public void setHeightOrasList(Object heightOrasList) {
        mHeightOrasList = heightOrasList;
    }

    public Object getModelObject() {
        return mModelObject;
    }

    public void setModelObject(Object modelObject) {
        mModelObject = modelObject;
    }

    public Object getQualificationList() {
        return mQualificationList;
    }

    public void setQualificationList(Object qualificationList) {
        mQualificationList = qualificationList;
    }

    public Object getStatus() {
        return mStatus;
    }

    public void setStatus(Object status) {
        mStatus = status;
    }

    public Object getUserCityList() {
        return mUserCityList;
    }

    public void setUserCityList(Object userCityList) {
        mUserCityList = userCityList;
    }

    public Object getUserList() {
        return mUserList;
    }

    public void setUserList(Object userList) {
        mUserList = userList;
    }

}
