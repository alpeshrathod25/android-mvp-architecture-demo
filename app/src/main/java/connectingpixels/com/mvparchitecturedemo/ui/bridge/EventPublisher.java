package connectingpixels.com.mvparchitecturedemo.ui.bridge;


import connectingpixels.com.mvparchitecturedemo.data.network.model.MainResponse;
import connectingpixels.com.mvparchitecturedemo.data.network.model.ErrorObject;
import connectingpixels.com.mvparchitecturedemo.ui.main.MainEvent;

/**
 * Created by alpesh on 29/10/17.
 */

public class EventPublisher {

    private static EventPublisher mInstance;

    public static EventPublisher getInstance() {
        if (mInstance == null) {
            mInstance = new EventPublisher();
        }
        return mInstance;
    }

    public final void setResult(ErrorObject error, MainResponse result) {
        MainEvent event = new MainEvent();
        event.errorObject = error;
        event.result = result;
        RxBus.getInstance().send(event);
    }
}
