package com.mukesh.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class AppPermissions {
  private Activity mActivity;

  /**
   * This method was deprecated in version 1.0.3 please use {#AppPermissions(Activity activity)}
   */
  @Deprecated public AppPermissions() {
  }

  public AppPermissions(Activity activity) {
    mActivity = activity;
  }

  public boolean hasPermission(String permission) {
    return ActivityCompat.checkSelfPermission(mActivity, permission)
        == PackageManager.PERMISSION_GRANTED;
  }

  public boolean hasPermission(String[] permissionsList) {
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(mActivity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

  public void requestPermission(String permission, int requestCode) {
    if (ActivityCompat.checkSelfPermission(mActivity, permission)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(mActivity, new String[] { permission }, requestCode);
    }
  }

  public void requestPermission(String[] permissionsList, int requestCode) {
    List<String> permissionNeeded = new ArrayList<>();
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(mActivity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        permissionNeeded.add(permission);
      }
    }
    if (permissionNeeded.size() > 0) {
      ActivityCompat.requestPermissions(mActivity,
          permissionNeeded.toArray(new String[permissionNeeded.size()]), requestCode);
    }
  }

  @Deprecated public boolean hasPermission(Activity activity, String permission) {
    return ActivityCompat.checkSelfPermission(activity, permission)
        == PackageManager.PERMISSION_GRANTED;
  }

  @Deprecated public boolean hasPermission(Activity activity, String[] permissionsList) {
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(activity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

  @Deprecated public void requestPermission(Activity activity, String permission, int requestCode) {
    if (ActivityCompat.checkSelfPermission(activity, permission)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(activity, new String[] { permission }, requestCode);
    }
  }

  @Deprecated
  public void requestPermission(Activity activity, String[] permissionsList, int requestCode) {
    List<String> permissionNeeded = new ArrayList<>();
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(activity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        permissionNeeded.add(permission);
      }
    }
    if (permissionNeeded.size() > 0) {
      ActivityCompat.requestPermissions(activity,
          permissionNeeded.toArray(new String[permissionNeeded.size()]), requestCode);
    }
  }
}
