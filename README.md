<h1 align="center">Runtime Permission Library(Android)</h1>
<p align="center">
  <a class="badge-align" href="https://www.codacy.com/app/mukeshsolanki/easypermissions-android?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mukeshsolanki/easypermissions-android&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/dd28ce7f922d4ad290c804283917f89d"/></a>
  <a href="https://jitpack.io/v/mukeshsolanki/easypermissions-android"><img src="https://jitpack.io/v/mukeshsolanki/easypermissions-android/month.svg"/></a>
  <a href="https://jitpack.io/#mukeshsolanki/easypermissions-android"> <img src="https://jitpack.io/v/mukeshsolanki/easypermissions-android.svg" /></a>
  <a href="https://circleci.com/gh/mukeshsolanki/easypermissions-android/tree/master"> <img src="https://circleci.com/gh/mukeshsolanki/easypermissions-android/tree/master.svg?style=shield" /></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <br /><br />A simple library that will remove all the boilerplate code and speed up your work with new Runtime Permissions introduced in Android M.


# Supporting Android Easy Permissions

Android Easy Permissions is an independent project with ongoing development and support made possible thanks to donations made by [these awesome backers](BACKERS.md#sponsors). If you'd like to join them, please consider:

- [Become a backer or sponsor on Patreon](https://www.patreon.com/mukeshsolanki).
- [One-time donation via PayPal](https://www.paypal.me/mukeshsolanki)

<a href="https://www.patreon.com/bePatron?c=935498" alt="Become a Patron"><img src="https://c5.patreon.com/external/logo/become_a_patron_button.png" /></a>

## What are Runtime Permissions?

<img src="https://github.com/mukeshsolanki/easypermissions-android/blob/master/screenshot/android-working-with-marshmallow-permissions.png?raw=true" />

Google docs is [here](https://developer.android.com/preview/features/runtime-permissions.html). Unlike the traditional way of asking permission Android M increased its security by enforcing apps to ask permissions on the fly as and when the user requests for a feature that requires those permissions. These permissions can also be revoked by the user at any time.
## How to integrate into your app?
Integrating the library into you app is extremely easy. A few changes in the build gradle and your all ready to user Runtime permissions library. Make the following changes to build.gradle inside you app.

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```
Step 2. Add the dependency
```java
dependencies {
        implementation 'com.github.mukeshsolanki:easypermissions-android:<latest-version>'
}
```

## How to use the library?
Okay seems like you integrated the library in your project but **how do you use it**? Well its really easy just follow the steps below.

```
 EasyPermissions easyPermissions =  new EasyPermissions.Builder()
                                           .with(this) //Activity
                                           .listener(
                                               new OnPermissionListener() {
                                                 @Override public void onAllPermissionsGranted(@NonNull List<String> permissions) {
                                                    // Triggered if all permissions were given
                                                 }

                                                 @Override public void onPermissionsGranted(@NonNull List<String> permissions) {
                                                    // Lists all the permissions that were granted
                                                 }

                                                 @Override public void onPermissionsDenied(@NonNull List<String> permissions) {
                                                    // Lists all the permissions that were denied
                                                 }
                                               })
                                           .build();
```

**Dont forget to override the onRequestPermissionsResult and pass teh result to the library like wise**
```
@Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    easyPermissions.onRequestPermissionsResult(permissions, grantResults);
  }
```

### Check Permissions
To check if the app already has permissions use
* `easyPermissions.hasPermission(String Permissions)` - To check one permission at a time
* `easyPermissions.hasPermission(String[] Permissions)` - To check multiple permissions at the same time

### Request Permissions
* `easyPermissions.request(String permission)` - To request one permission at a time
* `easyPermissions.request(String[] permission)` - To request multiple permissions at the same time.

That's pretty much it and your all wrapped up.

## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/App-Runtime-Permissions-Android.svg)](https://github.com/mukeshsolanki/App-Runtime-Permissions-Android/graphs/contributors)

* Bug reports and pull requests are welcome.
* Make sure you use [square/java-code-styles](https://github.com/square/java-code-styles) to format your code.

## License
```
Copyright 2018 Mukesh Solanki

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```