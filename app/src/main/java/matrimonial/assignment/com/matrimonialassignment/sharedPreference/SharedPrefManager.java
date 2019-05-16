package matrimonial.assignment.com.matrimonialassignment.sharedPreference;

import android.app.Activity;
import android.content.SharedPreferences;

import matrimonial.assignment.com.matrimonialassignment.application.ApplicationClass;

public class SharedPrefManager {

    public static String USER_ID;
    public static String NAVIGATION_VALUE;
    private static String APP_ID = "assignment_pref";
    private static int WORLD_READABLE = Activity.MODE_PRIVATE;

    public static void writeString(String key, String val){
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID,WORLD_READABLE);
        pref.edit().putString(key,val).commit();
    }

    public static String readString(String key){
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID,WORLD_READABLE);
        return pref.getString(key, "");
    }

    public static void writeInt(String key, int val){
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID,WORLD_READABLE);
        pref.edit().putInt(key,val).commit();
    }

    public static int readInt(String key){
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID,WORLD_READABLE);
        return pref.getInt(key, 0);
    }
}
