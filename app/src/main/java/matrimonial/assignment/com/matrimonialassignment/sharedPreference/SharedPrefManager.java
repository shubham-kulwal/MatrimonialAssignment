package matrimonial.assignment.com.matrimonialassignment.sharedPreference;

import android.app.Activity;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import matrimonial.assignment.com.matrimonialassignment.application.ApplicationClass;

public class SharedPrefManager {

    public static String USER_ID = "USER_ID";
    public static String NAVIGATION_VALUE = "NAVIGATION_VALUE";
    public static String PREF_LOGIN_RESULT = "PREF_LOGIN_RESULT";
    private static String APP_ID = "assignment_pref";
    private static int WORLD_READABLE = Activity.MODE_PRIVATE;

    public static void writeString(String key, String val) {
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID, WORLD_READABLE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, val);
        editor.commit();
    }

    public static String readString(String key) {
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID, WORLD_READABLE);
        return pref.getString(key, "");
    }

    public static void writeInt(String key, Integer val) {
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID,
                WORLD_READABLE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, val);
        editor.commit();
    }

    public static Integer readInt(String key) {
        SharedPreferences pref = ApplicationClass.getInstance().getSharedPreferences(APP_ID, WORLD_READABLE);
        return pref.getInt(key, 0);
    }

    public static String getObjectToString(Object mObject) {
        Gson mGson = (ApplicationClass.getInstance()).getGsonObject();
        return mGson.toJson(mObject);
    }

    public static Object getStringToObject(String stringToConvert, Class<?> cls) {
        Gson mGson = ApplicationClass.getInstance().getGsonObject();
        Object mObject = mGson.fromJson(stringToConvert, cls);
        return mObject;
    }
}
