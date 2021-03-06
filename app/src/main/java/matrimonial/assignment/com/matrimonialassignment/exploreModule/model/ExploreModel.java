package matrimonial.assignment.com.matrimonialassignment.exploreModule.model;

import java.util.List;

import savysoft.accl.retrofit.RetrofitHeaders;

public class ExploreModel {

    private List<RetrofitHeaders> headers;
    private int serviceID;
    private int PageNo;
    private String PageSize;
    private Integer requestedID;
    private Integer userID;
    private Integer requestTo;

    public Integer getrequestTo() {
        return requestTo;
    }

    public void setrequestTo(Integer userID) {
        this.requestTo = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getRequestedID() {
        return requestedID;
    }

    public void setRequestedID(Integer requestedID) {
        this.requestedID = requestedID;
    }

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public String getPageSize() {
        return PageSize;
    }

    public void setPageSize(String pageSize) {
        PageSize = pageSize;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public List<RetrofitHeaders> getHeaders() {
        return headers;
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        this.headers = headers;
    }
}
