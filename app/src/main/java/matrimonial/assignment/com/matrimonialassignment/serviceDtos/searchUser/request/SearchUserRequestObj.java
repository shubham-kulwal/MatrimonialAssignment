package matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.request;

public class SearchUserRequestObj {
    private float PageNo;
    private String PageSize;
    private float RequestUserId;


    // Getter Methods

    public float getPageNo() {
        return PageNo;
    }

    public String getPageSize() {
        return PageSize;
    }

    public float getRequestUserId() {
        return RequestUserId;
    }

    // Setter Methods

    public void setPageNo(float PageNo) {
        this.PageNo = PageNo;
    }

    public void setPageSize(String PageSize) {
        this.PageSize = PageSize;
    }

    public void setRequestUserId(float RequestUserId) {
        this.RequestUserId = RequestUserId;
    }
}
