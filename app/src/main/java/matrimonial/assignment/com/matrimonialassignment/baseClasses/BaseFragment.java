package matrimonial.assignment.com.matrimonialassignment.baseClasses;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.FINISH;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.PROGRESS_DIALOG_MESSAGE;

public class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;
    public static final int TAKE_PICTURE = 11, PICK_GALLERY_PICTURE = 12, REQUEST_PERMISSION_CONSTANT = 22, ADD_RESULT_REQUEST_IMAGE_CAPTURE = 5, ADD_RESULT_RESULT_LOAD_IMG = 6;
    private int selectedTypeForUploadPhoto;


    public List<RetrofitHeaders> getHeaders(){
        List<RetrofitHeaders> headers = new ArrayList();
        headers.add(new RetrofitHeaders("Content-Type","application/json"));
        headers.add(new RetrofitHeaders("isdevice","true"));
        headers.add(new RetrofitHeaders("token","Tasmay0603@"));
        return headers;
    }

    @BindingAdapter({"callActivity"})
    public static void callActivity(View view, Class<?> cls) {
        if (cls != null) {
            callActivity(view.getContext(), cls);
        }
    }

    @BindingAdapter({"toastMessage"})
    public static void showToastMessage(View view, String message) {
        if (message != null)
            toastShort(view.getContext(), message);
    }

    public static void toastShort(Context context, String message) {
        if (!TextUtils.isEmpty(message))
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void callActivity(Context context, Class<?> cls) {
        Intent callDestinationActivity = new Intent(context, cls);
        callDestinationActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(callDestinationActivity);
    }

    public void observeFinishActivity(BaseViewModel viewModel) {
        viewModel.getFinishActivity().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer finishActivity) {
                if (finishActivity == FINISH)
                    getActivity().finish();
            }
        });
    }

    public void observeProgressDialog(BaseViewModel viewModel) {
        viewModel.getProgressDialog().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer showProgressDialogFlag) {
                if (showProgressDialogFlag == DISMISS_PROGRESS_DIALOG) {
                    dismissProgressDialog();
                } else {
                    showProgressDialog();
                }
            }
        });
    }

    private void dismissProgressDialog() {
        if (getProgessDialog() != null && getProgessDialog().isShowing()) {
            getProgessDialog().dismiss();
        }
    }

    private void showProgressDialog() {
        ProgressDialog progressDialog = getProgessDialog();
        if (progressDialog!= null) {
            progressDialog.setMessage(PROGRESS_DIALOG_MESSAGE);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    private ProgressDialog getProgessDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
        }
        return progressDialog;
    }

    public void callImageSelectionOptions() {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, REQUEST_PERMISSION_CONSTANT);
            } else {
                showImageChangeDialog(getActivity());
            }
        } else {
            showImageChangeDialog(getActivity());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean flag = false;

        for (int permission : grantResults) {
            if (permission == -1) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        if (!flag) {
           // CommonMethods.ShowSettingAlertDialog(getActivity());
        } else {
            showImageChangeDialog(getActivity());
        }
    }

    public void showImageChangeDialog(final Activity mActivity) {
        CharSequence options[] = new CharSequence[]{"Camera", "Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        selectedTypeForUploadPhoto = TAKE_PICTURE;
                        takePictureFromCameraIntent();
                        break;
                    case 1:
                        selectedTypeForUploadPhoto = PICK_GALLERY_PICTURE;
                        getPictureFromGallery();
                        break;
                    case 2:
                        dialog.dismiss();
                        break;
                }
                dialog.dismiss();
            }
        });
        builder.show();

    }

    private void takePictureFromCameraIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getApplicationContext().getPackageManager()) != null) {
            getActivity().startActivityForResult(takePictureIntent, ADD_RESULT_REQUEST_IMAGE_CAPTURE);
        }
    }

    public void getPictureFromGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        getActivity().startActivityForResult(pickPhoto, ADD_RESULT_RESULT_LOAD_IMG);
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();

        o.inJustDecodeBounds = true;

        BitmapFactory.decodeStream(getActivity().getContentResolver()
                .openInputStream(selectedImage), null, o);

        final int REQUIRED_SIZE = 72;

        int width_tmp = o.outWidth, height_tmp = o.outHeight;

        int scale = 1;

        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;

            height_tmp /= 2;

            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();

        o2.inSampleSize = scale;

        Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver()
                .openInputStream(selectedImage), null, o2);

        return bitmap;
    }

    public static byte[] getStreamByteFromImage(final File imageFile) {
        Bitmap photoBitmap = BitmapFactory.decodeFile(imageFile.getPath());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        photoBitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }
}
