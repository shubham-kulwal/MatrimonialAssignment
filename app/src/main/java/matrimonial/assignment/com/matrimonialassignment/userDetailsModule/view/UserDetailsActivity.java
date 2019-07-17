package matrimonial.assignment.com.matrimonialassignment.userDetailsModule.view;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.activity.ViewImageActivity;
import matrimonial.assignment.com.matrimonialassignment.adapter.ImageAdapter;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseActivity;
import matrimonial.assignment.com.matrimonialassignment.callbacks.onImageViewListener;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityLoginLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.databinding.ActivityUserDetailsLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.view.ExploreFragment;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.searchUser.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.userDetailsModule.viewModel.UserDetailsViewModel;

public class UserDetailsActivity extends BaseActivity implements onImageViewListener {
    ActivityUserDetailsLayoutBinding activityUserDetailsLayoutBinding;
    private InfiniteScrollAdapter infiniteAdapter;


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
       // itemPicker = (DiscreteScrollView) findViewById(R.id.item_picker);
      /*  List<String> images = new ArrayList<>();
        for (int i=0 ;  i <=5 ; i++ ){
            images.add(dataResponse.getImg1());
        }*/
        activityUserDetailsLayoutBinding.itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
      //  activityUserDetailsLayoutBinding.itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ImageAdapter(dataResponse.getImageList(), this));
        activityUserDetailsLayoutBinding.itemPicker.setAdapter(infiniteAdapter);
    //    activityUserDetailsLayoutBinding.itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
        activityUserDetailsLayoutBinding.itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
     //   Glide.with(this).load(dataResponse.getImg1()).into(activityUserDetailsLayoutBinding.profileImage);
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

    @Override
    public void onImageClick(String imageURl) {
        Intent intent = new Intent(this , ViewImageActivity.class );
        intent.putExtra("image", imageURl);
        startActivity(intent);
    }



    /*@Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
}
