package matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response;

import java.util.List;

public class LoginResponseObj {

    private Boolean Status;

    private String FilePath;

    private String ModelObject;

    private String UserCityList;

    private List<DataResponse> DataResponse;

    private String CityList;

    private String QualificationList;

    private String HeightList;

    private String HeightOrasList;

    private String ErrorMessage;

    private String UserList;

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getModelObject() {
        return ModelObject;
    }

    public void setModelObject(String modelObject) {
        ModelObject = modelObject;
    }

    public String getUserCityList() {
        return UserCityList;
    }

    public void setUserCityList(String userCityList) {
        UserCityList = userCityList;
    }

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.DataResponse> getDataResponse() {
        return DataResponse;
    }

    public void setDataResponse(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.DataResponse> dataResponse) {
        DataResponse = dataResponse;
    }

    public String getCityList() {
        return CityList;
    }

    public void setCityList(String cityList) {
        CityList = cityList;
    }

    public String getQualificationList() {
        return QualificationList;
    }

    public void setQualificationList(String qualificationList) {
        QualificationList = qualificationList;
    }

    public String getHeightList() {
        return HeightList;
    }

    public void setHeightList(String heightList) {
        HeightList = heightList;
    }

    public String getHeightOrasList() {
        return HeightOrasList;
    }

    public void setHeightOrasList(String heightOrasList) {
        HeightOrasList = heightOrasList;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public String getUserList() {
        return UserList;
    }

    public void setUserList(String userList) {
        UserList = userList;
    }
}
