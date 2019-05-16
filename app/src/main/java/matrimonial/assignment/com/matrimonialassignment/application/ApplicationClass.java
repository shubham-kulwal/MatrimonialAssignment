package matrimonial.assignment.com.matrimonialassignment.application;

import android.app.Application;

public class ApplicationClass extends Application {

    private static ApplicationClass instance;

    public static ApplicationClass getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
