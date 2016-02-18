# Runtime Permission Library (Example)
A simple library that will remove all the boilerplate code and speed up your work with new Runtime Permissions introduced in Android M.
## What are Runtime Permissions?
<img src="http://chintanrathod.com/wp-content/uploads/2015/06/Android-M-Permission1.jpg" width="500" height="839" />
Google docs is [here](https://developer.android.com/preview/features/runtime-permissions.html). Unlike the traditional way of asking permission Android M increased its security by enforcing apps to ask permissions on the fly as and when the user requests for a feature that requires those permissions. These permissions can also be revoked by the user at any time.
## How to integrate into your app?
Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to user Runtime permissions library. Make the following changes to build.gradle inside you app.
```java
repositories {
  maven {
    url 'https://dl.bintray.com/mukeshsolanki/maven/'
  }
}
.....
dependencies {
  ...
  compile 'com.mukeshsolanki.requestpermissions:requestruntimepermissions:0.0.2'
}
```

## How to use the library?
Okay seems like you integrated the library in your project but **how do you use it**? Well its really easy just follow the steps below.

```
 RuntimePermission runtimePermission = new RuntimePermission();
```
This will create an object of the Runtime Permission class for you. Make sure it's an object of **com.mukeshsolanki.requestpermissions.RuntimePermission**
To check if the app has a specific permission you can call `runtimePermission.hasPermission(Activity activity, String permission);` or if you want to check 
whether the app has multiple permission you can call `runtimePermission.hasPermissions(Activity activity, String[] permissions)`. 

You can request for a permission by calling `runtimePermission.requestPermission(Activity activity, String permission, int requestCode)` or request multiple 
permissions by calling `runtimePermission.requestPermission(Activity activity, String[] permissions, int requestCode)`. However you will need to override a 
method on your activity inorder to wait for a callback from the library. Just add this to you activity.

<img src="https://d262ilb51hltx0.cloudfront.net/max/800/1*DJTWuO_J8QxKciSAjFWQCg.png" />

or like how google requests for multiple permissions

<img src="http://pic.youmobile.org/imgcdn/App-permissions-coming-in-Android-M.jpg" />

```
@Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == mRequestCode) { //The request code you passed along with the request.
    //grantResults holds a list of all the results for the permissions requested.
      for (int grantResult : grantResults) {
        if (grantResult == PackageManager.PERMISSION_DENIED) {
          Log.d("PermissionResult=>", "Denied");
          return;
        }
      }
      Log.d("PermissionResult=>", "All Permissions Granted");
    }
  }
```

That's pretty much it and your all wrapped up.