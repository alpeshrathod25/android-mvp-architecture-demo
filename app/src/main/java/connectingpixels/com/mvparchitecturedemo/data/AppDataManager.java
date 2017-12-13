package connectingpixels.com.mvparchitecturedemo.data;

import android.content.Context;

import connectingpixels.com.mvparchitecturedemo.data.db.IDbHelper;
import connectingpixels.com.mvparchitecturedemo.data.preference.IPreferencesHelper;

/**
 * Created by alpesh on 12/12/17.
 */

public class AppDataManager implements IDataManger {

    private final Context mContext;
    private final IDbHelper mDbHelper;
    private final IPreferencesHelper mPrefManager;

    public AppDataManager(Context mContext, IDbHelper mDbHelper, IPreferencesHelper mPrefManager) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mPrefManager = mPrefManager;
    }

    @Override
    public String getCurrentUserName() {
        return null;
    }

    @Override
    public void setCurrentUserName(String userName) {

    }

    @Override
    public String getCurrentUserEmail() {
        return null;
    }

    @Override
    public void setCurrentUserEmail(String email) {

    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return null;
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {

    }

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public void setAccessToken(String accessToken) {

    }
}
