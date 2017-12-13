package connectingpixels.com.mvparchitecturedemo.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by alpesh on 12/12/17.
 */

public interface IMvpBaseView {
    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();
}
