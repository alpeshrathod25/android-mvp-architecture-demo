package connectingpixels.com.mvparchitecturedemo.ui.main;


import connectingpixels.com.mvparchitecturedemo.data.network.NetworkHelper;
import connectingpixels.com.mvparchitecturedemo.ui.base.BasePresenter;
import connectingpixels.com.mvparchitecturedemo.ui.bridge.RxBus;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by alpesh on 12/12/17.
 */

public class MainPresenter<V extends IMainMvpView> extends BasePresenter<V> implements IMainMvpPresenter<V> {

    NetworkHelper mNetworkHelper;
    Subscription subscribe;

    public MainPresenter() {
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
        subscribe = RxBus.getInstance().toObservable().subscribe(new Action1<Object>() {
            @Override
            public void call(Object o) {
                if (o instanceof MainEvent && isViewAttached()) {
                    MainEvent event = (MainEvent) o;
                    if (event.errorObject == null) {
                        getMvpView().setResult(event.result);
                    } else {
                        handleApiError(event.errorObject);
                    }
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        subscribe.unsubscribe();
    }

    @Override
    public void onFirstButtonClick() {
        getMvpView().openFirstActivity();
    }

    @Override
    public void onSecondButtonClick() {
        getMvpView().openSecondActivity();
    }

    @Override
    public void callWebService() {
        mNetworkHelper = NetworkHelper.getInstance();
        mNetworkHelper.callApi();//you can replace this method from networkhelper class to here
    }
}
