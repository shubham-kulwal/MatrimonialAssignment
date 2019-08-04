package matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;
import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.activity.ViewImageActivity;
import matrimonial.assignment.com.matrimonialassignment.adapter.ImageAdapter;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.callbacks.onImageViewListener;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityUserDetailsLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.view.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.viewModel.UserDetailsViewModel;

public class UserDetailsActivity extends BaseActivity implements onImageViewListener {
    ActivityUserDetailsLayoutBinding binding;
    private InfiniteScrollAdapter infiniteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeActivityBinding();
        init();
        sendDataToViewModel();
    }

    private void sendDataToViewModel() {
        binding.getUserDetailsViewModel().setHeaders(getHeaders());
    }

    private ActivityUserDetailsLayoutBinding initializeActivityBinding() {
        binding = DataBindingUtil.setContentView(UserDetailsActivity.this, R.layout.activity_user_details_layout);
        binding.setUserDetailsViewModel(new UserDetailsViewModel(this));
        binding.executePendingBindings();
        return binding;
    }

    private void init() {
        DataResponse dataResponse = ExploreFragment.dataResponse;
        binding.itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ImageAdapter(dataResponse.getImageList(), this));
        binding.itemPicker.setAdapter(infiniteAdapter);
        binding.itemPicker.setItemTransformer(new ScaleTransformer.Builder().setMinScale(0.8f).build());
        binding.name.setText(dataResponse.getFirstName() + " " + dataResponse.getMName() + " " + dataResponse.getLName());
        binding.dateOfBirth.setText(dataResponse.getDateOfBirthString());
        binding.timeOfBirth.setText(dataResponse.getTimeofBirth());
        binding.placeOfBirth.setText(dataResponse.getPlaceofBirth());
        binding.age.setText(dataResponse.getAge() + "");
        binding.gender.setText(dataResponse.getGender());
        binding.orasName.setText(dataResponse.getOrasName());
        binding.height.setText(dataResponse.getHeight());
        binding.weight.setText(dataResponse.getWeight());
        binding.caste.setText(dataResponse.getCastName());
        binding.religion.setText(dataResponse.getReligionName());
        binding.handicapped.setText(dataResponse.getIsHandiCapped());
        binding.qualification.setText(dataResponse.getQualification());
        binding.income.setText(dataResponse.getIncome());
        binding.noOfBros.setText(dataResponse.getNoOfMBro());
        binding.noOfSis.setText(dataResponse.getNoOfMSis());
        binding.expectation.setText(dataResponse.getExpectation());
        binding.hobbies.setText(dataResponse.getHobbies());
        binding.address.setText(dataResponse.getAddress());
        binding.city.setText(dataResponse.getCity());
        binding.taluka.setText(dataResponse.getTaluka());
        binding.state.setText(dataResponse.getState());
        binding.country.setText(dataResponse.getCountry());
        if (dataResponse.getIsManglik() == 1) {
            binding.manglik.setText("Yes");
        } else {
            binding.manglik.setText("No");
        }
        if (dataResponse.isRequestSend())
            binding.expressInterestTv.setVisibility(View.INVISIBLE);

    }

    public void hideExpressInterest() {
        binding.expressInterestTv.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onImageClick(String imageURl) {
        Intent intent = new Intent(this, ViewImageActivity.class);
        intent.putExtra("image", imageURl);
        startActivity(intent);
    }
}
