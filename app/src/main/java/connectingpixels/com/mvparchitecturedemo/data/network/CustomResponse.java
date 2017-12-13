package connectingpixels.com.mvparchitecturedemo.data.network;

import android.util.Log;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import connectingpixels.com.mvparchitecturedemo.data.network.model.ErrorObject;
import connectingpixels.com.mvparchitecturedemo.utils.AppConstant;
import connectingpixels.com.mvparchitecturedemo.utils.AppUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alpesh on 29/10/17.
 */

public abstract class CustomResponse<T> implements Callback<T> {

    public abstract void onSuccess(T t);

    public abstract void onError(ErrorObject t);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            onError(new ErrorObject(AppConstant.IErrorCode.defaultErrorCode, "We could not complete your request"));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable th) {
        String val = "";
        if (!(call == null || call.request() == null || call.request().body() == null))
            val = call.request().body().toString();

        if (AppUtils.isNotNullOrEmpty(val))
            Log.e("Response Error", val);

        if (th instanceof UnknownHostException) {
            onError(new ErrorObject(AppConstant.IErrorCode.notInternetConnErrorCode, AppConstant.IErrorMessage.NO_INTERNET_CONNECTION));
        } else if (th instanceof SocketTimeoutException) {
            onError(new ErrorObject(AppConstant.IErrorCode.socketTimeOutError, AppConstant.IErrorMessage.TIME_OUT_CONNECTION));
        } else if (!(th instanceof IOException)) {
            onError(new ErrorObject(AppConstant.IErrorCode.defaultErrorCode, "We could not complete your request"));
        } else if (AppUtils.isNotNullOrEmpty(th.getMessage()) && th.getMessage().contains("Cancel")) {
            onError(new ErrorObject(AppConstant.IErrorCode.ioExceptionCancelApiErrorCode, "We could not complete your request"));
        } else if (AppUtils.isNotNullOrEmpty(th.getMessage()) && th.getMessage().equalsIgnoreCase("socket closed")) {
            onError(new ErrorObject(AppConstant.IErrorCode.ioExceptionCancelApiErrorCode, "We could not complete your request"));
        } else {
            onError(new ErrorObject(AppConstant.IErrorCode.ioExceptionOtherErrorCode, "We could not complete your request"));
        }
    }
}
