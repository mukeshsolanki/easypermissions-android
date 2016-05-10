package com.mukesh.permissionsexample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import mukesh.com.permissions.AppPermissions;

public class MainActivity extends AppCompatActivity {

  public static final String[] PERMISSIONS = {
      Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECEIVE_SMS,
      Manifest.permission.READ_SMS, Manifest.permission.WRITE_EXTERNAL_STORAGE
  };
  private AppPermissions mRuntimePermission;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mRuntimePermission = new AppPermissions();
    mRuntimePermission.requestPermission(this, PERMISSIONS, 0);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 0) {
      List<Integer> permissionResults = new ArrayList<>();
      for (int grantResult : grantResults) {
        permissionResults.add(grantResult);
      }
      if (permissionResults.contains(PackageManager.PERMISSION_DENIED)) {
        Log.d("PermissionResult=>", "Denied");
      } else {
        Log.d("PermissionResult=>", "Granted");
      }
    }
  }
}
