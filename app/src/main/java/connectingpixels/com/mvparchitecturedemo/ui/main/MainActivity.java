package connectingpixels.com.mvparchitecturedemo.ui.main;

import android.os.Bundle;

import connectingpixels.com.mvparchitecturedemo.R;
import connectingpixels.com.mvparchitecturedemo.data.network.model.MainResponse;
import connectingpixels.com.mvparchitecturedemo.ui.base.BaseActivity;


public class MainActivity extends BaseActivity implements IMainMvpView {

    IMainMvpPresenter<IMainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new MainPresenter<>();
        mPresenter.onAttach(this);
    }

    @Override
    public void openFirstActivity() {
    }

    @Override
    public void openSecondActivity() {

    }

    @Override
    public void setResult(MainResponse result) {
        //actual implementation
    }
}
