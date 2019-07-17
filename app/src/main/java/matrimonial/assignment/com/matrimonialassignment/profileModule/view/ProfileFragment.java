package matrimonial.assignment.com.matrimonialassignment.profileModule.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.File;

import matrimonial.assignment.com.matrimonialassignment.R;
import matrimonial.assignment.com.matrimonialassignment.baseClasses.BaseFragment;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentExploreLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.databinding.FragmentProfileLayoutBinding;
import matrimonial.assignment.com.matrimonialassignment.exploreModule.viewModel.ExploreViewModel;
import matrimonial.assignment.com.matrimonialassignment.profileModule.viewModel.ProfileViewModel;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.loginDtos.response.DataResponse;
import matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager;
import matrimonial.assignment.com.matrimonialassignment.utils.BitmapOrImageMethods;

import static android.app.Activity.RESULT_OK;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.PREF_LOGIN_RESULT;
import static matrimonial.assignment.com.matrimonialassignment.sharedPreference.SharedPrefManager.readString;

public class ProfileFragment extends BaseFragment {

    private FragmentProfileLayoutBinding fragmentProfileLayoutBinding;
    Bitmap decodedBitmap;
    File finalFile;

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
        fragmentProfileLayoutBinding.uploadTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callImageSelectionOptions();
            }
        });


    }

    public DataResponse getLoginResult() {
        if (!readString(PREF_LOGIN_RESULT).equalsIgnoreCase("")) {
            return new Gson().fromJson(readString(PREF_LOGIN_RESULT), DataResponse.class);
        } else {
            return null;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            switch (requestCode) {

                case ADD_RESULT_REQUEST_IMAGE_CAPTURE:
                    if (resultCode == RESULT_OK) {
                        Bundle extras = data.getExtras();
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        if (decodedBitmap != null) {
                            decodedBitmap.recycle();
                            decodedBitmap = null;
                        }
                        Uri tempUri = getImageUri(getActivity().getApplicationContext(), imageBitmap);
                        decodedBitmap = decodeUri(tempUri);
                        File finalFile = new File(getRealPathFromURI(tempUri));
                        byte[] bytes = getStreamByteFromImage(finalFile);
                        tempUri = getImageUri(getActivity().getApplicationContext(), BitmapOrImageMethods.getBitmapFromByteArray(bytes));
                        decodedBitmap = decodeUri(tempUri);
                        finalFile = new File(getRealPathFromURI(tempUri));
                      /*  gifImageView.setVisibility(View.GONE);
                        profileImageView.setVisibility(View.VISIBLE);*/
                        fragmentProfileLayoutBinding.profileImage.setImageBitmap(decodedBitmap);
                    }
                    break;

                case ADD_RESULT_RESULT_LOAD_IMG:
                    if (resultCode == RESULT_OK) {
                        Uri selectedImage = data.getData();
                        finalFile = new File(getRealPathFromURI(selectedImage));
                        if (decodedBitmap != null) {
                            decodedBitmap.recycle();
                            decodedBitmap = null;
                        }
                        decodedBitmap = decodeUri(selectedImage);
                        byte[] bytes = getStreamByteFromImage(finalFile);
                        selectedImage = getImageUri(getActivity().getApplicationContext(), BitmapOrImageMethods.getBitmapFromByteArray(bytes));
                        decodedBitmap = decodeUri(selectedImage);
                        finalFile = new File(getRealPathFromURI(selectedImage));
                        if (finalFile.toString().contains("gif")) {
                        /*    gifImageView.setVisibility(View.VISIBLE);
                            profileImageView.setVisibility(View.GONE);*/
                            fragmentProfileLayoutBinding.profileImage.setImageBitmap(decodedBitmap);
                        } else {
                          /*  profileImageView.setVisibility(View.VISIBLE);
                            gifImageView.setVisibility(View.GONE);*/
                            fragmentProfileLayoutBinding.profileImage.setImageBitmap(decodedBitmap);
                        }
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
