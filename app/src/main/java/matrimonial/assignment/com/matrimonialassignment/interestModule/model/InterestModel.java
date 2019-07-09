package matrimonial.assignment.com.matrimonialassignment.interestModule.model;

import java.util.List;

import savysoft.accl.retrofit.RetrofitHeaders;

public class InterestModel {

    private List<RetrofitHeaders> headers;
    private int serviceId;
    private int RequestUserId;

    public int getRequestUserId() {
        return RequestUserId;
    }

    public void setRequestUserId(int requestUserId) {
        RequestUserId = requestUserId;
    }

    public List<RetrofitHeaders> getHeaders() {
        return headers;
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        this.headers = headers;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
