package connectingpixels.com.mvparchitecturedemo.ui.base;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Created by alpesh on 13/12/17.
 */

public abstract class RuntimePermissionActivity extends BaseActivity {

    private static final int REQ_PERMISSION_CAMERA = 1001;

    public abstract void onPermissionGranted(int requestCode, boolean shouldShowRequestPermissionRational);

    public abstract void onPermissionDenied(int requestCode, boolean shouldShowRequestPermissionRational);

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean rational = false;
        int permissionCheck = PackageManager.PERMISSION_GRANTED;

        for (String permission : permissions) {
            permissionCheck += ContextCompat.checkSelfPermission(this, permission);
            if (ContextCompat.checkSelfPermission(this, permission) != 0) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                    rational = false;
                } else {
                    rational = true;
                }
            }
        }

        if ((grantResults.length > 0) && permissionCheck == PackageManager.PERMISSION_GRANTED) {
            onPermissionGranted(requestCode, false);
        } else {
            onPermissionDenied(requestCode, rational);
        }
    }

    public void requestPermission(final String[] requestPermissions, final String msg, final int requestCode) {
        int permissionCheck = PackageManager.PERMISSION_DENIED;
        boolean shouldShowRequestPermissionRationale = false;

        for (String permission : requestPermissions) {
            permissionCheck = permissionCheck + ContextCompat.checkSelfPermission(this, permission);
            shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale || ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
        }

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale) {
                Snackbar.make(findViewById(android.R.id.content),
                        msg, Snackbar.LENGTH_INDEFINITE).setAction("GRANT", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(RuntimePermissionActivity.this, requestPermissions, requestCode);
                    }
                }).show();
            } else {
                //never show again
            }
        } else {
            onPermissionGranted(requestCode, true);
        }
    }
}
