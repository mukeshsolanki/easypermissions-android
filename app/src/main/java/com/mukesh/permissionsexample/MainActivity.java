package com.mukesh.permissionsexample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.mukesh.permissions.AppPermissions;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private static final String[] ALL_PERMISSIONS = {
      Manifest.permission.READ_SMS, Manifest.permission.WRITE_EXTERNAL_STORAGE,
      Manifest.permission.CAMERA
  };

  private static final int CAMERA_REQUEST_CODE = 1;
  private static final int SMS_REQUEST_CODE = 2;
  private static final int STORAGE_REQUEST_CODE = 3;
  private static final int ALL_REQUEST_CODE = 0;
  private Button mStorageButton, mCameraButton, mSmsButton, mAllButton;
  private AppPermissions mRuntimePermission;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mRuntimePermission = new AppPermissions(this);
    initializeUI();
    setListener();
  }

  private void setListener() {
    mStorageButton.setOnClickListener(this);
    mCameraButton.setOnClickListener(this);
    mSmsButton.setOnClickListener(this);
    mAllButton.setOnClickListener(this);
  }

  private void initializeUI() {
    mStorageButton = (Button) findViewById(R.id.storage_button);
    mCameraButton = (Button) findViewById(R.id.camera_button);
    mSmsButton = (Button) findViewById(R.id.sms_button);
    mAllButton = (Button) findViewById(R.id.all_button);
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
      case ALL_REQUEST_CODE:
        List<Integer> permissionResults = new ArrayList<>();
        for (int grantResult : grantResults) {
          permissionResults.add(grantResult);
        }
        if (permissionResults.contains(PackageManager.PERMISSION_DENIED)) {
          Toast.makeText(this, "All Permissions not granted", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(this, "All Permissions granted", Toast.LENGTH_SHORT).show();
        }
        break;
      case CAMERA_REQUEST_CODE:
        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
          Toast.makeText(this, "Camera Permissions not granted", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(this, "Camera Permissions granted", Toast.LENGTH_SHORT).show();
        }
        break;
      case SMS_REQUEST_CODE:
        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
          Toast.makeText(this, "SMS Permissions not granted", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(this, "SMS Permissions granted", Toast.LENGTH_SHORT).show();
        }
        break;
      case STORAGE_REQUEST_CODE:
        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
          Toast.makeText(this, "Storage Permissions not granted", Toast.LENGTH_SHORT).show();
        } else {
          Toast.makeText(this, "Storage Permissions granted", Toast.LENGTH_SHORT).show();
        }
        break;
    }
  }

  @Override public void onClick(View v) {
    if (v == mCameraButton) {
      if (mRuntimePermission.hasPermission(Manifest.permission.CAMERA)) {
        Toast.makeText(this, "Camera permission already given", Toast.LENGTH_SHORT).show();
      } else {
        mRuntimePermission.requestPermission(Manifest.permission.CAMERA, CAMERA_REQUEST_CODE);
      }
    } else if (v == mStorageButton) {
      if (mRuntimePermission.hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
        Toast.makeText(this, "Storage permission already given", Toast.LENGTH_SHORT).show();
      } else {
        mRuntimePermission.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
            STORAGE_REQUEST_CODE);
      }
    } else if (v == mSmsButton) {
      if (mRuntimePermission.hasPermission(Manifest.permission.READ_SMS)) {
        Toast.makeText(this, "SMS permission already given", Toast.LENGTH_SHORT).show();
      } else {
        mRuntimePermission.requestPermission(Manifest.permission.READ_SMS, SMS_REQUEST_CODE);
      }
    } else if (v == mAllButton) {
      if (mRuntimePermission.hasPermission(ALL_PERMISSIONS)) {
        Toast.makeText(this, "All permission already given", Toast.LENGTH_SHORT).show();
      } else {
        mRuntimePermission.requestPermission(this, ALL_PERMISSIONS, ALL_REQUEST_CODE);
      }
    }
  }
}
