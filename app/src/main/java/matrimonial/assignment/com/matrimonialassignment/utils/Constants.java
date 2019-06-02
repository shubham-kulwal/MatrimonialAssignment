package matrimonial.assignment.com.matrimonialassignment.utils;

public interface Constants {

    int FINISH = 1;

    interface ProgressDialog {
        int SHOW_PROGRESS_DIALOG = 1;
        int DISMISS_PROGRESS_DIALOG = 0;
        String PROGRESS_DIALOG_MESSAGE = "Loading...";
    }

    interface APIFAILURE {
        int APIFAILURE_STATUSCODE = 1;
    }

    interface APILIST {
        String LOGIN_API = "/account/login";
        String REGISTER_USER_API = "/account/RegisterUser";
        String SEARCH_USER_API = "userprofile/SearchUsers";
        String SHORLIST_USER_API = "/UserProfile/ShortlistAndroid";
        String SHORLIST_USER_API = "/UserProfile/ShortlistAndroid";

    }

}
