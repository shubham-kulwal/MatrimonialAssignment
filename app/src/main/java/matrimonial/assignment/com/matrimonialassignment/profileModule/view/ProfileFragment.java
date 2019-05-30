package matrimonial.assignment.com.matrimonialassignment.profileModule.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentExploreLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentProfileLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.viewModel.ExploreViewModel;
import matrimonial.assignment.com.matrimonialassignment.profileModule.viewModel.ProfileViewModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;

import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.PREF_LOGIN_RESULT;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readString;

public class ProfileFragment extends Fragment {

    private FragmentProfileLayoutBinding fragmentProfileLayoutBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentProfileLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile_layout, null, false);
        View view = fragmentProfileLayoutBinding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fragmentProfileLayoutBinding.setViewModel(new ProfileViewModel());
        fragmentProfileLayoutBinding.executePendingBindings();
        init();
    }

    private void init() {;
        DataResponse dataResponse  = getLoginResult();
        fragmentProfileLayoutBinding.firstname.setText(dataResponse.getFirstName());
        fragmentProfileLayoutBinding.lastName.setText(dataResponse.getLastName());
        fragmentProfileLayoutBinding.fathersName.setText(dataResponse.getMiddleName());
       // fragmentProfileLayoutBinding.mothersName.setText(dataResponse.getM);
        fragmentProfileLayoutBinding.dateOfBirth.setText(dataResponse.getDateOfBirth());
        fragmentProfileLayoutBinding.placeOfBirth.setText(dataResponse.getPlaceOfBirth());
        fragmentProfileLayoutBinding.timeOfBirth.setText(dataResponse.getTimeofBirth());
        fragmentProfileLayoutBinding.age.setText(dataResponse.getAge()+"");
        fragmentProfileLayoutBinding.weight.setText(dataResponse.getWeight()+"");
        fragmentProfileLayoutBinding.email.setText(dataResponse.getEmail()+"");
        fragmentProfileLayoutBinding.mobile.setText(dataResponse.getMobileNo()+"");
        fragmentProfileLayoutBinding.hobbies.setText(dataResponse.getHobbies()+"");


    }

    public DataResponse getLoginResult() {
        if (!readString(PREF_LOGIN_RESULT).equalsIgnoreCase("")) {
            return new Gson().fromJson(readString(PREF_LOGIN_RESULT), DataResponse.class);
        } else {
            return null;
        }
    }
}
