package matrimonial.assignment.com.matrimonialassignment.userDetailsModule.model;

import java.util.List;

import savysoft.accl.retrofit.RetrofitHeaders;

public class UserDetailModel {

    private int serviceID;
    private List<RetrofitHeaders> headers;
    private Integer requestedID;
    private Integer requestTo;

    public Integer getrequestTo() {
        return requestTo;
    }

    public void setrequestTo(Integer userID) {
        this.requestTo = userID;
    }

    public Integer getRequestedID() {
        return requestedID;
    }

    public void setRequestedID(Integer requestedID) {
        this.requestedID = requestedID;
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
