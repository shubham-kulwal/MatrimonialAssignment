package matrimonial.assignment.com.matrimonialassignment.loginModule.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.activity.DashBoardActivity;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityLoginLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.loginModule.viewModel.LoginViewModel;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginLayoutBinding activityLoginLayoutBinding = initializeActivityBinding();
        init(activityLoginLayoutBinding.getViewModel());
    }

    private ActivityLoginLayoutBinding initializeActivityBinding() {
        ActivityLoginLayoutBinding activityLoginLayoutBinding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login_layout);
        activityLoginLayoutBinding.setViewModel(new LoginViewModel());
        activityLoginLayoutBinding.executePendingBindings();
        return activityLoginLayoutBinding;
    }

    private void init(LoginViewModel loginViewModel) {
        observeProgressDialog(loginViewModel);
        observeFinishActivity(loginViewModel);
    }
}
