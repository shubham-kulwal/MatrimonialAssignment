package matrimonial.assignment.com.matrimonialassignment.serviceDtos.registerDtos;

public class RegisterUserResponseObj {

    private String DataResponse = null;
    private String UserList = null;
    private String ModelObject = null;
    private String CityList = null;
    private String UserCityList = null;
    private String QualificationList = null;
    private String HeightList = null;
    private String HeightOrasList = null;
    private String ErrorMessage;
    private boolean Status;
    private String FilePath = null;

    public String getDataResponse() {
        return DataResponse;
    }

    public void setDataResponse(String dataResponse) {
        DataResponse = dataResponse;
    }

    public String getUserList() {
        return UserList;
    }

    public void setUserList(String userList) {
        UserList = userList;
    }

    public String getModelObject() {
        return ModelObject;
    }

    public void setModelObject(String modelObject) {
        ModelObject = modelObject;
    }

    public String getCityList() {
        return CityList;
    }

    public void setCityList(String cityList) {
        CityList = cityList;
    }

    public String getUserCityList() {
        return UserCityList;
    }

    public void setUserCityList(String userCityList) {
        UserCityList = userCityList;
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

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }


}
