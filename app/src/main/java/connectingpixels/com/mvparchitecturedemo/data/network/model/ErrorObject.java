package connectingpixels.com.mvparchitecturedemo.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alpesh on 29/10/17.
 */

public class ErrorObject implements Parcelable {
    private String httpCode;
    private String message;
    public String status;
    public String type;

    public ErrorObject() {

    }

    public ErrorObject(String str, String str2) {
        this.httpCode = str;
        this.message = str2;
    }

    protected ErrorObject(Parcel parcel) {
        this.httpCode = parcel.readString();
        this.message = parcel.readString();
        this.type = parcel.readString();
        this.status = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(this.httpCode);
        parcel.writeString(this.message);
        parcel.writeString(this.type);
        parcel.writeString(this.status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ErrorObject> CREATOR = new Creator<ErrorObject>() {
        @Override
        public ErrorObject createFromParcel(Parcel in) {
            return new ErrorObject(in);
        }

        @Override
        public ErrorObject[] newArray(int size) {
            return new ErrorObject[size];
        }
    };
}
