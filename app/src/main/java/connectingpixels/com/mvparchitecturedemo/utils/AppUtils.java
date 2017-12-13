package connectingpixels.com.mvparchitecturedemo.utils;

/**
 * Created by alpesh on 13/12/17.
 */

public class AppUtils {
    public static boolean isNotNullOrEmpty(String val) {
        return (val == null || "".equals(val.trim())) ? false : true;
    }
}
