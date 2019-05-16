package matrimonial.assignment.com.matrimonialassignment.splashScreenModule.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivitySplashLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.splashScreenModule.viewModel.SplashScreenViewModel;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashLayoutBinding activitySplashLayoutBinding = initializeActivityBinding();
        activitySplashLayoutBinding.getViewModel().callActivity();
        observeFinishActivity(activitySplashLayoutBinding.getViewModel());
    }

    private ActivitySplashLayoutBinding initializeActivityBinding() {
        ActivitySplashLayoutBinding activitySplashLayoutBinding = DataBindingUtil.setContentView(SplashScreenActivity.this, R.layout.activity_splash_layout);
        activitySplashLayoutBinding.setViewModel(new SplashScreenViewModel());
        activitySplashLayoutBinding.executePendingBindings();
        return activitySplashLayoutBinding;
    }
}
