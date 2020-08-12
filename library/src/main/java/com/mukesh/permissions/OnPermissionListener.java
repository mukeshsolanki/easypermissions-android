package com.mukesh.permissions;

import androidx.annotation.NonNull;

import java.util.List;

public interface OnPermissionListener {
  void onAllPermissionsGranted(@NonNull List<String> permissions);

  void onPermissionsGranted(@NonNull List<String> permissions);

  void onPermissionsDenied(@NonNull List<String> permissions);
}
