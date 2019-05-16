package matrimonial.assignment.com.matrimonialassignment.registrationModule.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityLoginLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityRegistrationLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.loginModule.view.LoginActivity;
import matrimonial.assignment.com.matrimonialassignment.loginModule.viewModel.LoginViewModel;
import matrimonial.assignment.com.matrimonialassignment.registrationModule.viewModel.RegistrationViewModel;

public class RegistrationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegistrationLayoutBinding activityRegistrationLayoutBinding = initializeActivityBinding();
        activityRegistrationLayoutBinding.toolbar.setTitle("Sign Up");
        init(activityRegistrationLayoutBinding.getViewModel());
    }

    private ActivityRegistrationLayoutBinding initializeActivityBinding() {
        ActivityRegistrationLayoutBinding activityRegistrationLayoutBinding = DataBindingUtil.setContentView(RegistrationActivity.this, R.layout.activity_registration_layout);
        activityRegistrationLayoutBinding.setViewModel(new RegistrationViewModel());
        activityRegistrationLayoutBinding.executePendingBindings();
        return activityRegistrationLayoutBinding;
    }

    private void init(RegistrationViewModel viewModel) {
        observeProgressDialog(viewModel);
        observeFinishActivity(viewModel);
    }
}
