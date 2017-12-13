package connectingpixels.com.mvparchitecturedemo.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import connectingpixels.com.mvparchitecturedemo.ui.base.BaseActivity;


/**
 * Created by alpesh on 12/12/17.
 */

public class SplashActivity extends BaseActivity implements ISplashMvpView {

    ISplashMvpPresenter<ISplashMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new SplashPresenter<>();
        mPresenter.onAttach(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDetach();
    }

    @Override
    public void openLoginActivity() {

    }

    @Override
    public void openMainActivity() {

    }
}
