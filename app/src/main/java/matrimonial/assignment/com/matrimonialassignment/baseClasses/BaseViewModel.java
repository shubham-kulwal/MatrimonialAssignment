package matrimonial.assignment.com.matrimonialassignment.baseClasses;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.Nullable;

import matrimonial.assignment.com.matrimonialassignment.BR;
import matrimonial.assignment.com.matrimonialassignment.service.ApiService;
import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import savysoft.accl.interfaces.InternetConnectionInterface;

import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APIFAILURE.APIFAILURE_STATUSCODE;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.ProgressDialog.DISMISS_PROGRESS_DIALOG;

public abstract class BaseViewModel extends BaseObservable {

    @Bindable
    public Class<?> callActivity=null;
    @Bindable
    public String toastMessage;
    @Bindable
    public int serviceId =-1;
   /* @Bindable
    public InternetConnectionInterface internetConnectionInterface=null;*/

    private MutableLiveData<Integer> finishActivity = new MutableLiveData<>();
    private MutableLiveData<Integer> showProgressDialog = new MutableLiveData<>();

    public void setCallActivity(Class<?> callActivity){
        this.callActivity=callActivity;
        notifyPropertyChanged(BR.callActivity);
    }

    public LiveData getFinishActivity(){
        return  finishActivity;
    }

    public void setFinishActivity(int value){
        finishActivity.setValue(value);
    }

    public LiveData<Integer> getProgressDialog() {
        return showProgressDialog;
    }

    public void setProgressDialog(int flag) {
        showProgressDialog.setValue(flag);
    }

    public void setToastMessage(String toastMessage){
        this.toastMessage=toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void observeApiResult(ApiService apiManager) {
        apiManager.getResponse().observeForever(new Observer<Result>() {
            @Override
            public void onChanged(@Nullable Result result) {
                if (result != null && result.getStatusCode() == APIFAILURE_STATUSCODE) {
                 //   setResponse(result.getServiceId());
                    setProgressDialog(DISMISS_PROGRESS_DIALOG);
                } else {
                    if (result != null) {
                        responseSuccess(result);
                    }
                }
            }
        });
    }

//    private void setResponse(int serviceId){
//        this.serviceId=serviceId;
//        notifyPropertyChanged(BR.serviceId);
//        //notifyPropertyChanged(BR.internetConnectionInterface);
//    }

    public abstract void responseSuccess(Result result);
}
