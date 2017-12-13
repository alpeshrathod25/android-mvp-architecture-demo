package connectingpixels.com.mvparchitecturedemo.ui.main;


import connectingpixels.com.mvparchitecturedemo.data.network.model.MainResponse;
import connectingpixels.com.mvparchitecturedemo.ui.base.IMvpBaseView;

/**
 * Created by alpesh on 12/12/17.
 */

public interface IMainMvpView extends IMvpBaseView {

    void openFirstActivity();

    void openSecondActivity();

    void setResult(MainResponse result);
}
