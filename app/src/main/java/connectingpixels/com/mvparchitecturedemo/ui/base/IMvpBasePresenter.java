package connectingpixels.com.mvparchitecturedemo.ui.base;

import connectingpixels.com.mvparchitecturedemo.data.network.model.ErrorObject;

/**
 * Created by alpesh on 12/12/17.
 */

public interface IMvpBasePresenter<V extends IMvpBaseView> {
    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ErrorObject errorObject);
}
