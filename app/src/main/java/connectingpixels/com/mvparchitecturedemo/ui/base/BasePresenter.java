package connectingpixels.com.mvparchitecturedemo.ui.base;

import connectingpixels.com.mvparchitecturedemo.data.network.model.ErrorObject;

/**
 * Created by alpesh on 12/12/17.
 */

public class BasePresenter<V extends IMvpBaseView> implements IMvpBasePresenter<V> {

    V mMvpView;

    public BasePresenter() {//can contains datamanager class as argument

    }

    @Override
    public void onAttach(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    @Override
    public void handleApiError(ErrorObject errorObject) {

    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                  " requesting data to the Presenter");
        }
    }
}
