package connectingpixels.com.mvparchitecturedemo.ui.splash;


import connectingpixels.com.mvparchitecturedemo.ui.base.BasePresenter;

/**
 * Created by alpesh on 12/12/17.
 */

public class SplashPresenter<V extends ISplashMvpView> extends BasePresenter<V> implements ISplashMvpPresenter<V> {

    public SplashPresenter() {
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void decideNextActivity() {
        //if ()
        //getMvpView().openLoginActivity();
        //else
        //getMvpView().openMainActivity();
    }
}
