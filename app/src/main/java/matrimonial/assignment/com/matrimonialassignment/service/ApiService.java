package matrimonial.assignment.com.matrimonialassignment.service;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import matrimonial.assignment.com.matrimonialassignment.serviceDtos.Result;
import savysoft.accl.interfaces.RetrofitInterface;
import savysoft.accl.retrofit.RetrofitHeaders;
import savysoft.accl.retrofit.RetrofitParamsDTO;

import static matrimonial.assignment.com.matrimonialassignment.utils.APIConstants.BASE_URL;
import static matrimonial.assignment.com.matrimonialassignment.utils.Constants.APIFAILURE.APIFAILURE_STATUSCODE;

public class ApiService {

    private MutableLiveData<Result> liveDataResult = new MutableLiveData<>();
    public static RetrofitParamsDTO retrofitParamsDTO;

    public void retrofitApiCall(Object requestObject, Class<?> resultClass, String methodName, int serviceId, int apiMethod, List<RetrofitHeaders> headers) {
        RetrofitParamsDTO retrofitParamsDTO = new RetrofitParamsDTO.RetrofitBuilder(null, BASE_URL,
                requestObject,
                resultClass,
                methodName, serviceId, apiMethod, retrofitInterface)
                .setRetrofitHeaderses(headers)
                .build();
        retrofitParamsDTO.execute(retrofitParamsDTO);
        this.retrofitParamsDTO = retrofitParamsDTO;
    }

    public List<RetrofitHeaders> getHeaders(){
        List<RetrofitHeaders> headers = new ArrayList();
        headers.add(new RetrofitHeaders("Content-Type","application/json"));
        return headers;
    }

    RetrofitInterface retrofitInterface=new RetrofitInterface() {
        Result result=new Result();
        @Override
        public void onSuccess(Object object, int serviceId, int statusCode, String message) {

            result.setMessage(message);
            result.setObject(object);
            result.setServiceId(serviceId);
            result.setStatusCode(statusCode);
            setResponse(result);
        }

        @Override
        public void onError(int serviceId) {
            result.setServiceId(serviceId);
            result.setStatusCode(APIFAILURE_STATUSCODE);
            setResponse(result);
        }
    };

    public LiveData<Result> getResponse() {
        return liveDataResult;
    }

    public void setResponse(Result result) {
        liveDataResult.setValue(result);
    }
}
