package connectingpixels.com.mvparchitecturedemo.utils;

/**
 * Created by alpesh on 13/12/17.
 */

public class AppConstant {

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public interface IErrorCode {
        String contentNotModifiedErrorCode = "ER005";
        String defaultErrorCode = "ER001";
        String ioExceptionCancelApiErrorCode = "ER003";
        String ioExceptionOtherErrorCode = "ER004";
        String notInternetConnErrorCode = "ER002";
        String socketTimeOutError = "ER006";
    }

    public interface IErrorMessage {
        String CONTENT_NOT_MODIFIED = "Content not modified";
        String IO_EXCEPTION = "We could not complete your request";
        String LOCTION_NOT_FETCH_ERROR_MESSAGE = "We could not fetch the city according to your current location.";
        String NO_INTERNET_CONNECTION = "No internet connection.";
        String OTHER_EXCEPTION = "We could not complete your request";
        String SEND_DEAL_OPTION = "dealoption";
        String SOMETHING_WRONG_ERROR = "Something went wrong!!\nPlease try again later.";
        String TIME_OUT_CONNECTION = "We could not complete your request.\nPlease try again later.";
    }
}
