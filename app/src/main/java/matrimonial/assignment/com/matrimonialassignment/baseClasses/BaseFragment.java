package matrimonial.assignment.com.matrimonialassignment.baseClasses;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import savysoft.accl.retrofit.RetrofitHeaders;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.FINISH;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.PROGRESS_DIALOG_MESSAGE;

public class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;


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
}
