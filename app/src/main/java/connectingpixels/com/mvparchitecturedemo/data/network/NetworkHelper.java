package connectingpixels.com.mvparchitecturedemo.data.network;


import connectingpixels.com.mvparchitecturedemo.data.network.model.MainResponse;
import connectingpixels.com.mvparchitecturedemo.data.network.model.ErrorObject;
import connectingpixels.com.mvparchitecturedemo.ui.bridge.EventPublisher;

/**
 * Created by alpesh on 29/10/17.
 */

public class NetworkHelper {

    private static NetworkHelper sNetworkHelper;

    public static NetworkHelper getInstance() {
        if (sNetworkHelper == null)
            sNetworkHelper = new NetworkHelper();
        return sNetworkHelper;
    }

    public void callApi() {
        ((RequestBuilder) ClientGenerator.getInstance().createService(RequestBuilder.class)).getList("Ah").enqueue(new CustomResponse<MainResponse>() {
            @Override
            public void onSuccess(MainResponse mainResponse) {
                EventPublisher.getInstance().setResult(null, mainResponse);
            }

            @Override
            public void onError(ErrorObject t) {
                EventPublisher.getInstance().setResult(t, null);
            }
        });
    }
}
