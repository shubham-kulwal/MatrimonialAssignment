package matrimonial.assignment.com.matrimonialassignment.blockUserListModule.model;

import java.util.List;

import savysoft.accl.retrofit.RetrofitHeaders;

public class BlockUserListModel {

    private List<RetrofitHeaders> headers;
    private int serviceId;

    private int RequestUserId;

    public int getRequestUserId() {
        return RequestUserId;
    }

    public void setRequestUserId(int requestUserId) {
        RequestUserId = requestUserId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public List<RetrofitHeaders> getHeaders() {
        return headers;
    }

    public void setHeaders(List<RetrofitHeaders> headers) {
        this.headers = headers;
    }
}
