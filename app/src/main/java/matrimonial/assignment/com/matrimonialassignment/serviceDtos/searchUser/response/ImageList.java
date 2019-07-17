package matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response;

public class ImageList {

    private int ProfileImageId;
    private int UserId;
    private String ImagePath;
    private String Caption;
    private String CreatedBy;


    public int getProfileImageId() {
        return ProfileImageId;
    }

    public void setProfileImageId(int profileImageId) {
        ProfileImageId = profileImageId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }
}
