package mukesh.com.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import java.util.ArrayList;
import java.util.List;

public class AppPermissions {
  public boolean hasPermission(Activity activity, String permission) {
    return ActivityCompat.checkSelfPermission(activity, permission)
        == PackageManager.PERMISSION_GRANTED;
  }

  public boolean hasPermission(Activity activity, String[] permissionsList) {
    for (String permission : permissionsList) {
      if (ActivityCompat.checkSelfPermission(activity, permission)
          != PackageManager.PERMISSION_GRANTED) {
        return false;
      }
    }
    return true;
  }

  public void requestPermission(Activity activity, String permission, int requestCode) {
    if (ActivityCompat.checkSelfPermission(activity, permission)
        != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(activity, new String[] { permission }, requestCode);
    }
  }

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
