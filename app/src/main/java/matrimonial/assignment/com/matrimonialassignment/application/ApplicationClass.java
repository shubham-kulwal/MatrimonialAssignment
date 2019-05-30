package matrimonial.assignment.com.matrimonialassignment.application;

import android.app.Application;

import com.google.gson.Gson;

public class ApplicationClass extends Application {

    private static ApplicationClass instance;
    private Gson mGson;

    public static ApplicationClass getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public Gson getGsonObject() {
        return mGson;
    }
}
