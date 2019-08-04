package matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;


public class DataResponse {

    private int UserId;
    private int IsManglik;
    private int Jobdata;
    private String NoOfMBro = null;
    private String NoOfMSis = null;
    private String SubCaste;
    private String ReligionName;
    private String CastName;
    private boolean IsOwnShop;
    private boolean IsRequestSend;
    private int ReligionId;
    private String BloodGroupName;
    private boolean IsAdhaarVerified;
    private String DegreeName;
    private String Height;
    private String FirstName;
    private String MName;
    private String LName;
    private int BloodGroupId;
    private String CityId = null;
    private int CasteId;
    private int OrasId;
    private String OrasName = null;
    private String Address;
    private String Gender;
    private String DateOfBirth;
    private int HeightId;
    private String Weight = null;
    private String IdentificationMark = null;
    private String PANNO = null;
    private String MobileNo;
    private String MailId = null;
    private String Color;
    private String IsHandiCapped = null;
    private String HandicapedType = null;
    private boolean IsActive;
    private String UserType;
    private String DateofReg;
    private int MarritalStatus;
    private int NoOfChildrens;
    private boolean ChildLivingStatus;
    private String PlaceofBirth;
    private String TimeofBirth;
    private String BodyType;
    private String UserName = null;
    private String Password;
    private int QualificationId;
    private String Qualification;
    private String Income;
    private String Img1;
    private String Img2 = null;
    private String KImg = null;
    private String Gotra = null;
    private String BirthName = null;
    private String Hobbies;
    private String Expectation;
    private String City;
    private String State;
    private String Country;
    private String District;
    private String Taluka;
    private boolean IsIntercast;
    private int JobId;
    private boolean IsJobOrBusiness;
    private String Salary = null;
    private String Post = null;
    private String CompanyName;
    private String PermanentOrContract = null;
    private String JobType = null;
    private String JobLocation;
    private String Expr1;
    private String FathersName;
    private int FamilyMemId;
    private String MothersName;
    private int Age;
    private int NoofBrothers;
    private int NoofSisters;
    private String IsJob = null;
    private String FathersIncome;
    private String JobBusinessInfo = null;
    private String JobBusinessInfo1 = null;
    private String BotherInfo;
    private String SisterInfo;
    private int ismarried;
    private String BirthCountry = null;
    private String BirthDistrict = null;
    private String BirthState = null;
    private String PanchayatCode;
    private int PanchayatId;
    private int IsOwnHouse;
    private String Achievements;
    private String Pincode;
    private String ReferenceName;
    private String ReferenceContact;
    private String BehalfOf;
    private String IsSpec = null;
    private int TotalRecords;
    private int favourite;
    private boolean IsShorlisted;
    private Object RequestStatus;
    private int FullAccess;
    private int OnlyImageFullAccess;
    private boolean IsBlocked;
    private List<ImageList> ImageList;
    private String DateOfBirthString;

    public String getDateOfBirthString() {
        return DateOfBirthString;
    }

    public void setDateOfBirthString(String dateOfBirthString) {
        DateOfBirthString = dateOfBirthString;
    }

    public List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.ImageList> getImageList() {
        return ImageList;
    }

    public void setImageList(List<matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.ImageList> imageList) {
        ImageList = imageList;
    }

    public boolean isBlocked() {
        return IsBlocked;
    }

    public void setBlocked(boolean blocked) {
        IsBlocked = blocked;
    }

    public int getFavourite() {
        return favourite;
    }

    public boolean isShorlisted() {
        return IsShorlisted;
    }

    public void setShorlisted(boolean shorlisted) {
        IsShorlisted = shorlisted;
    }

    public Object getRequestStatus() {
        return RequestStatus;
    }

    public void setRequestStatus(Object requestStatus) {
        RequestStatus = requestStatus;
    }

    public int getFullAccess() {
        return FullAccess;
    }

    public void setFullAccess(int fullAccess) {
        FullAccess = fullAccess;
    }

    public int getOnlyImageFullAccess() {
        return OnlyImageFullAccess;
    }

    public void setOnlyImageFullAccess(int onlyImageFullAccess) {
        OnlyImageFullAccess = onlyImageFullAccess;
    }

    public int isFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public int getIsManglik() {
        return IsManglik;
    }

    public void setIsManglik(int isManglik) {
        IsManglik = isManglik;
    }

    public int getJobdata() {
        return Jobdata;
    }

    public void setJobdata(int jobdata) {
        Jobdata = jobdata;
    }

    public String getNoOfMBro() {
        return NoOfMBro;
    }

    public void setNoOfMBro(String noOfMBro) {
        NoOfMBro = noOfMBro;
    }

    public String getNoOfMSis() {
        return NoOfMSis;
    }

    public void setNoOfMSis(String noOfMSis) {
        NoOfMSis = noOfMSis;
    }

    public String getSubCaste() {
        return SubCaste;
    }

    public void setSubCaste(String subCaste) {
        SubCaste = subCaste;
    }

    public String getReligionName() {
        return ReligionName;
    }

    public void setReligionName(String religionName) {
        ReligionName = religionName;
    }

    public String getCastName() {
        return CastName;
    }

    public void setCastName(String castName) {
        CastName = castName;
    }

    public boolean isOwnShop() {
        return IsOwnShop;
    }

    public void setOwnShop(boolean ownShop) {
        IsOwnShop = ownShop;
    }

    public boolean isRequestSend() {
        return IsRequestSend;
    }

    public void setRequestSend(boolean requestSend) {
        IsRequestSend = requestSend;
    }

    public int getReligionId() {
        return ReligionId;
    }

    public void setReligionId(int religionId) {
        ReligionId = religionId;
    }

    public String getBloodGroupName() {
        return BloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        BloodGroupName = bloodGroupName;
    }

    public boolean isAdhaarVerified() {
        return IsAdhaarVerified;
    }

    public void setAdhaarVerified(boolean adhaarVerified) {
        IsAdhaarVerified = adhaarVerified;
    }

    public String getDegreeName() {
        return DegreeName;
    }

    public void setDegreeName(String degreeName) {
        DegreeName = degreeName;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getBloodGroupId() {
        return BloodGroupId;
    }

    public void setBloodGroupId(int bloodGroupId) {
        BloodGroupId = bloodGroupId;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public int getCasteId() {
        return CasteId;
    }

    public void setCasteId(int casteId) {
        CasteId = casteId;
    }

    public int getOrasId() {
        return OrasId;
    }

    public void setOrasId(int orasId) {
        OrasId = orasId;
    }

    public String getOrasName() {
        return OrasName;
    }

    public void setOrasName(String orasName) {
        OrasName = orasName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public int getHeightId() {
        return HeightId;
    }

    public void setHeightId(int heightId) {
        HeightId = heightId;
    }

    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public String getIdentificationMark() {
        return IdentificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        IdentificationMark = identificationMark;
    }

    public String getPANNO() {
        return PANNO;
    }

    public void setPANNO(String PANNO) {
        this.PANNO = PANNO;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getMailId() {
        return MailId;
    }

    public void setMailId(String mailId) {
        MailId = mailId;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getIsHandiCapped() {
        return IsHandiCapped;
    }

    public void setIsHandiCapped(String isHandiCapped) {
        IsHandiCapped = isHandiCapped;
    }

    public String getHandicapedType() {
        return HandicapedType;
    }

    public void setHandicapedType(String handicapedType) {
        HandicapedType = handicapedType;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public String getDateofReg() {
        return DateofReg;
    }

    public void setDateofReg(String dateofReg) {
        DateofReg = dateofReg;
    }

    public int getMarritalStatus() {
        return MarritalStatus;
    }

    public void setMarritalStatus(int marritalStatus) {
        MarritalStatus = marritalStatus;
    }

    public int getNoOfChildrens() {
        return NoOfChildrens;
    }

    public void setNoOfChildrens(int noOfChildrens) {
        NoOfChildrens = noOfChildrens;
    }

    public boolean isChildLivingStatus() {
        return ChildLivingStatus;
    }

    public void setChildLivingStatus(boolean childLivingStatus) {
        ChildLivingStatus = childLivingStatus;
    }

    public String getPlaceofBirth() {
        return PlaceofBirth;
    }

    public void setPlaceofBirth(String placeofBirth) {
        PlaceofBirth = placeofBirth;
    }

    public String getTimeofBirth() {
        return TimeofBirth;
    }

    public void setTimeofBirth(String timeofBirth) {
        TimeofBirth = timeofBirth;
    }

    public String getBodyType() {
        return BodyType;
    }

    public void setBodyType(String bodyType) {
        BodyType = bodyType;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getQualificationId() {
        return QualificationId;
    }

    public void setQualificationId(int qualificationId) {
        QualificationId = qualificationId;
    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getIncome() {
        return Income;
    }

    public void setIncome(String income) {
        Income = income;
    }

    public String getImg1() {
        return Img1;
    }

    public void setImg1(String img1) {
        Img1 = img1;
    }

    public String getImg2() {
        return Img2;
    }

    public void setImg2(String img2) {
        Img2 = img2;
    }

    public String getKImg() {
        return KImg;
    }

    public void setKImg(String KImg) {
        this.KImg = KImg;
    }

    public String getGotra() {
        return Gotra;
    }

    public void setGotra(String gotra) {
        Gotra = gotra;
    }

    public String getBirthName() {
        return BirthName;
    }

    public void setBirthName(String birthName) {
        BirthName = birthName;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String hobbies) {
        Hobbies = hobbies;
    }

    public String getExpectation() {
        return Expectation;
    }

    public void setExpectation(String expectation) {
        Expectation = expectation;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getTaluka() {
        return Taluka;
    }

    public void setTaluka(String taluka) {
        Taluka = taluka;
    }

    public boolean isIntercast() {
        return IsIntercast;
    }

    public void setIntercast(boolean intercast) {
        IsIntercast = intercast;
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int jobId) {
        JobId = jobId;
    }

    public boolean isJobOrBusiness() {
        return IsJobOrBusiness;
    }

    public void setJobOrBusiness(boolean jobOrBusiness) {
        IsJobOrBusiness = jobOrBusiness;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getPermanentOrContract() {
        return PermanentOrContract;
    }

    public void setPermanentOrContract(String permanentOrContract) {
        PermanentOrContract = permanentOrContract;
    }

    public String getJobType() {
        return JobType;
    }

    public void setJobType(String jobType) {
        JobType = jobType;
    }

    public String getJobLocation() {
        return JobLocation;
    }

    public void setJobLocation(String jobLocation) {
        JobLocation = jobLocation;
    }

    public String getExpr1() {
        return Expr1;
    }

    public void setExpr1(String expr1) {
        Expr1 = expr1;
    }

    public String getFathersName() {
        return FathersName;
    }

    public void setFathersName(String fathersName) {
        FathersName = fathersName;
    }

    public int getFamilyMemId() {
        return FamilyMemId;
    }

    public void setFamilyMemId(int familyMemId) {
        FamilyMemId = familyMemId;
    }

    public String getMothersName() {
        return MothersName;
    }

    public void setMothersName(String mothersName) {
        MothersName = mothersName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getNoofBrothers() {
        return NoofBrothers;
    }

    public void setNoofBrothers(int noofBrothers) {
        NoofBrothers = noofBrothers;
    }

    public int getNoofSisters() {
        return NoofSisters;
    }

    public void setNoofSisters(int noofSisters) {
        NoofSisters = noofSisters;
    }

    public String getIsJob() {
        return IsJob;
    }

    public void setIsJob(String isJob) {
        IsJob = isJob;
    }

    public String getFathersIncome() {
        return FathersIncome;
    }

    public void setFathersIncome(String fathersIncome) {
        FathersIncome = fathersIncome;
    }

    public String getJobBusinessInfo() {
        return JobBusinessInfo;
    }

    public void setJobBusinessInfo(String jobBusinessInfo) {
        JobBusinessInfo = jobBusinessInfo;
    }

    public String getJobBusinessInfo1() {
        return JobBusinessInfo1;
    }

    public void setJobBusinessInfo1(String jobBusinessInfo1) {
        JobBusinessInfo1 = jobBusinessInfo1;
    }

    public String getBotherInfo() {
        return BotherInfo;
    }

    public void setBotherInfo(String botherInfo) {
        BotherInfo = botherInfo;
    }

    public String getSisterInfo() {
        return SisterInfo;
    }

    public void setSisterInfo(String sisterInfo) {
        SisterInfo = sisterInfo;
    }

    public int getIsmarried() {
        return ismarried;
    }

    public void setIsmarried(int ismarried) {
        this.ismarried = ismarried;
    }

    public String getBirthCountry() {
        return BirthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        BirthCountry = birthCountry;
    }

    public String getBirthDistrict() {
        return BirthDistrict;
    }

    public void setBirthDistrict(String birthDistrict) {
        BirthDistrict = birthDistrict;
    }

    public String getBirthState() {
        return BirthState;
    }

    public void setBirthState(String birthState) {
        BirthState = birthState;
    }

    public String getPanchayatCode() {
        return PanchayatCode;
    }

    public void setPanchayatCode(String panchayatCode) {
        PanchayatCode = panchayatCode;
    }

    public int getPanchayatId() {
        return PanchayatId;
    }

    public void setPanchayatId(int panchayatId) {
        PanchayatId = panchayatId;
    }

    public int getIsOwnHouse() {
        return IsOwnHouse;
    }

    public void setIsOwnHouse(int isOwnHouse) {
        IsOwnHouse = isOwnHouse;
    }

    public String getAchievements() {
        return Achievements;
    }

    public void setAchievements(String achievements) {
        Achievements = achievements;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public String getReferenceName() {
        return ReferenceName;
    }

    public void setReferenceName(String referenceName) {
        ReferenceName = referenceName;
    }

    public String getReferenceContact() {
        return ReferenceContact;
    }

    public void setReferenceContact(String referenceContact) {
        ReferenceContact = referenceContact;
    }

    public String getBehalfOf() {
        return BehalfOf;
    }

    public void setBehalfOf(String behalfOf) {
        BehalfOf = behalfOf;
    }

    public String getIsSpec() {
        return IsSpec;
    }

    public void setIsSpec(String isSpec) {
        IsSpec = isSpec;
    }

    public int getTotalRecords() {
        return TotalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        TotalRecords = totalRecords;
    }
}
