package connectingpixels.com.mvparchitecturedemo;

import android.app.Application;

import connectingpixels.com.mvparchitecturedemo.data.preference.PreferenceKeeper;

/**
 * Created by alpesh on 13/12/17.
 */

public class TheApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferenceKeeper.setContext(getApplicationContext());
    }
}
