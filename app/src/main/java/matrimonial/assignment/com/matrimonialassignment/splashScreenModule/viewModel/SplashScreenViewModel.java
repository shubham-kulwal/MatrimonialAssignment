package matrimonial.assignment.com.matrimonialassignment.splashScreenModule.viewModel;

import android.os.Handler;

import matrimonial.assignment.com.matrimonialassignment.activity.DashBoardActivity;
import matrimonial.assignment.com.matrimonialassignment.activity.MainActivity;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseViewModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.NAVIGATION_VALUE;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readInt;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.FINISH;

public class SplashScreenViewModel extends BaseViewModel {

    public void callActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (readInt(NAVIGATION_VALUE)==1){
                    setCallActivity(DashBoardActivity.class);
                    setFinishActivity(FINISH);
                }else {
                    setCallActivity(MainActivity.class);
                    setFinishActivity(FINISH);
                }
            }
        }, 2000);
    }

    @Override
    public void responseSuccess(Result result) {

    }
}
