package matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response;

import java.util.List;

public class SearchUserResponseObj {

    private List<DataResponse> DataResponse = null;
    private Object UserList;
    private Object ModelObject;
    private Object CityList;
    private List<UserCityList> UserCityList = null;
    private List<QualificationList> QualificationList = null;
    private List<HeightList> HeightList = null;
    private List<HeightOrasList> HeightOrasList = null;
    private String ErrorMessage;
    private String  Status;
    private String FilePath;

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse> getDataResponse() {
        return DataResponse;
    }

    public void setDataResponse(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse> dataResponse) {
        DataResponse = dataResponse;
    }

    public Object getUserList() {
        return UserList;
    }

    public void setUserList(Object userList) {
        UserList = userList;
    }

    public Object getModelObject() {
        return ModelObject;
    }

    public void setModelObject(Object modelObject) {
        ModelObject = modelObject;
    }

    public Object getCityList() {
        return CityList;
    }

    public void setCityList(Object cityList) {
        CityList = cityList;
    }

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.UserCityList> getUserCityList() {
        return UserCityList;
    }

    public void setUserCityList(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.UserCityList> userCityList) {
        UserCityList = userCityList;
    }

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.QualificationList> getQualificationList() {
        return QualificationList;
    }

    public void setQualificationList(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.QualificationList> qualificationList) {
        QualificationList = qualificationList;
    }

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.HeightList> getHeightList() {
        return HeightList;
    }

    public void setHeightList(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.HeightList> heightList) {
        HeightList = heightList;
    }

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.HeightOrasList> getHeightOrasList() {
        return HeightOrasList;
    }

    public void setHeightOrasList(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.HeightOrasList> heightOrasList) {
        HeightOrasList = heightOrasList;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }
}
