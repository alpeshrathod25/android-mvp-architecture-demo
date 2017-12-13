package connectingpixels.com.mvparchitecturedemo.data.preference;

import android.content.Context;

/**
 * Created by alpesh on 12/12/17.
 */

public class PreferenceKeeper {

    public static Context sContext;

    public static void setContext(Context context) {
        sContext = context;
    }
}
