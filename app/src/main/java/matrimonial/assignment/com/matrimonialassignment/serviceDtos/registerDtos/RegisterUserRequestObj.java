package matrimonial.assignment.com.matrimonialassignment.serviceDtos.registerDtos;

public class RegisterUserRequestObj {

    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Email;
    private String Password;
    private String ConfirmPassword;
    private String MobileNo;
    private String Gender;
    private String AgentId = null;
    private String BehalfOf;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAgentId() {
        return AgentId;
    }

    public void setAgentId(String agentId) {
        AgentId = agentId;
    }

    public String getBehalfOf() {
        return BehalfOf;
    }

    public void setBehalfOf(String behalfOf) {
        BehalfOf = behalfOf;
    }
}
