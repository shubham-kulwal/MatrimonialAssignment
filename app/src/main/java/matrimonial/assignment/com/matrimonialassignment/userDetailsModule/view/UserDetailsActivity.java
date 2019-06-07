package matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityLoginLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityUserDetailsLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.view.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.viewModel.UserDetailsViewModel;

public class UserDetailsActivity extends BaseActivity {
    ActivityUserDetailsLayoutBinding activityUserDetailsLayoutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeActivityBinding();
        init();
        sendDataToViewModel();
    }

    private void sendDataToViewModel() {
        activityUserDetailsLayoutBinding.getUserDetailsViewModel().setHeaders(getHeaders());
    }

    private ActivityUserDetailsLayoutBinding initializeActivityBinding() {
        activityUserDetailsLayoutBinding = DataBindingUtil.setContentView(UserDetailsActivity.this, R.layout.activity_user_details_layout);
        activityUserDetailsLayoutBinding.setUserDetailsViewModel(new UserDetailsViewModel(this));
        activityUserDetailsLayoutBinding.executePendingBindings();
        return activityUserDetailsLayoutBinding;
    }

    private void init() {
        DataResponse dataResponse = ExploreFragment.dataResponse;
        Glide.with(this).load(dataResponse.getImg1()).into(activityUserDetailsLayoutBinding.profileImage);
        activityUserDetailsLayoutBinding.name.setText(dataResponse.getFirstName()+" "+dataResponse.getMName()+" "+dataResponse.getLName());
        activityUserDetailsLayoutBinding.dateOfBirth.setText(dataResponse.getDateOfBirth());
        activityUserDetailsLayoutBinding.timeOfBirth.setText(dataResponse.getTimeofBirth());
        activityUserDetailsLayoutBinding.placeOfBirth.setText(dataResponse.getPlaceofBirth());
        activityUserDetailsLayoutBinding.age.setText(dataResponse.getAge()+"");
        activityUserDetailsLayoutBinding.gender.setText(dataResponse.getGender());
        activityUserDetailsLayoutBinding.orasName.setText(dataResponse.getOrasName());
        activityUserDetailsLayoutBinding.height.setText(dataResponse.getHeight());
        activityUserDetailsLayoutBinding.weight.setText(dataResponse.getWeight());
        activityUserDetailsLayoutBinding.caste.setText(dataResponse.getCastName());
        activityUserDetailsLayoutBinding.religion.setText(dataResponse.getReligionName());
        activityUserDetailsLayoutBinding.handicapped.setText(dataResponse.getIsHandiCapped());
        activityUserDetailsLayoutBinding.qualification.setText(dataResponse.getQualification());
        activityUserDetailsLayoutBinding.income.setText(dataResponse.getIncome());
        activityUserDetailsLayoutBinding.noOfBros.setText(dataResponse.getNoOfMBro());
        activityUserDetailsLayoutBinding.noOfSis.setText(dataResponse.getNoOfMSis());
        activityUserDetailsLayoutBinding.expectation.setText(dataResponse.getExpectation());
        activityUserDetailsLayoutBinding.hobbies.setText(dataResponse.getHobbies());
        activityUserDetailsLayoutBinding.address.setText(dataResponse.getAddress());
        activityUserDetailsLayoutBinding.city.setText(dataResponse.getCity());
        activityUserDetailsLayoutBinding.taluka.setText(dataResponse.getTaluka());
        activityUserDetailsLayoutBinding.state.setText(dataResponse.getState());
        activityUserDetailsLayoutBinding.country.setText(dataResponse.getCountry());
        if (dataResponse.getIsManglik()==1) {
            activityUserDetailsLayoutBinding.manglik.setText("Yes");
        }else {
            activityUserDetailsLayoutBinding.manglik.setText("No");
        }
        if (dataResponse.isRequestSend())
            activityUserDetailsLayoutBinding.expressInterestTv.setVisibility(View.INVISIBLE);

    }

   public void hideExpressInterest(){
        activityUserDetailsLayoutBinding.expressInterestTv.setVisibility(View.INVISIBLE);
    }
}
