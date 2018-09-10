package com.mukesh.permissions;

import android.support.annotation.NonNull;

public interface MultiplePermissions {
  void onAllPermissionsGranted(@NonNull String... permissions);

  void onPermissionsGranted(@NonNull String... permissions);

  void onPremissiosnDenied(@NonNull String... permissions);
}
