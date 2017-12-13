package connectingpixels.com.mvparchitecturedemo.ui.main;


import connectingpixels.com.mvparchitecturedemo.ui.base.IMvpBasePresenter;

/**
 * Created by alpesh on 12/12/17.
 */

public interface IMainMvpPresenter<V extends IMainMvpView> extends IMvpBasePresenter<V> {
    void onFirstButtonClick();

    void onSecondButtonClick();

    void callWebService();
}
