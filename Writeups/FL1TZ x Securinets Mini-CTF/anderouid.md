**Challenge Name :** anderouid

### **Category :** Reverse Engineering

### **Description :**

> The big organization "FL1TZ" has leaked their security app! Can you find the secret? 🔍
> 
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'FL1TZ.zip'_

---

### Solution

As the name suggests , this is challenge aims to reverse engineer an android apk ! 

Let's start with extracting our zip :

![](https://private-user-images.githubusercontent.com/144800528/413027345-41f01bf2-6b94-48f8-8491-530ea45ae132.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQ1LTQxZjAxYmYyLTZiOTQtNDhmOC04NDkxLTUzMGVhNDVhZTEzMi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mNDQ3MDg4NDZjMzRjOTQ3MmM5YzNkZWU1ZmU2NWJkZmVkNjY1ODViMDYxYWVlMzU1ZWM4OTJiZGRhYWNhYTE2JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.IfJNTCj_pWubF_i-5mKqt-eNEkdy-gS6S5COCQ7VA-4)

Oh i thought we are getting an apk ,hmm  let's run our **file command** as usual :

![](https://private-user-images.githubusercontent.com/144800528/413027331-0e9feee1-4e9f-4521-ae39-11b62f0aacfc.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzMxLTBlOWZlZWUxLTRlOWYtNDUyMS1hZTM5LTExYjYyZjBhYWNmYy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iMmZjMzM1Y2M0NDYzMmVjMDg4ZWE5MjkwNmZiODg2Y2E4OGIwMzUxZTI4YTNmYzJmMjM5OWZkYmJmOWRiYmIyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.qUxJVa-7fLIBSnChOgSO0Z0xojFT9PjUof2Pc5ruUIQ)

---

### TIP :

_(You can learn everything about android reverse engineering in this website : [Hextree](https://app.hextree.io/))_

---

yepp , we are right , it's an **apk** , the author really likes to mess with file extensions

Let's open our emulator [Android Studio](https://developer.android.com/studio) and run the app in our virtual device  :

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027334-8871f85d-babe-44c0-8884-03c75752ffa6.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzM0LTg4NzFmODVkLWJhYmUtNDRjMC04ODg0LTAzYzc1NzUyZmZhNi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03YTg0MzliMjAxYTNhZTczYmRmOTUwMDMyN2NiNTc1MDc3NDg2NmQxMjMxZWZkNWJmZmIxZTQxNDg4ODE3ZDdiJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.nOFM9tNSuQfpaL0pMy-_VdRyoMMrSyt3uGvkzVorKtU" alt="" width="257" data-align="center">

And as we can see , it is asking for a password , let's input something random :

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027318-c76bcbdf-2fb5-485e-b887-6df3c19c2e09.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzE4LWM3NmJjYmRmLTJmYjUtNDg1ZS1iODg3LTZkZjNjMTljMmUwOS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yOTVmOWE4NTRjYmZkZjNkNmQ2MzliZDFiMDdlZWE0YjE0ZTdjMjY1MjlhMGZhZjcxMjY1OTUxNjA2Y2VjYTg2JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.Z4O-qIBJ4eryyuOt8z-KqErHwxGKL21R0vzd6JKYc0g" alt="" width="237" data-align="center">

Time to dig through the code !! , and for that we are going to decompile our android app using [jadx]([GitHub - skylot/jadx: Dex to Java decompiler](https://github.com/skylot/jadx))

And head over to **AndroidManifest.xml**

```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    android:versionCode="1"
    android:versionName="1.0"
    android:compileSdkVersion="35"
    android:compileSdkVersionCodename="15"
    package="io.fl1tz.ctf"
    platformBuildVersionCode="35"
    platformBuildVersionName="15">
    <uses-sdk
        android:minSdkVersion="21"
        android:targetSdkVersion="35"/>
    <permission
        android:name="io.fl1tz.ctf.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"
        android:protectionLevel="signature"/>
    <uses-permission android:name="io.fl1tz.ctf.DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION"/>
    <application
        android:theme="@style/Theme.CTF"
        android:label="@string/app_name"
        android:icon="@mipmap/ic_launcher"
        android:debuggable="true"
        android:allowBackup="true"
        android:supportsRtl="true"
        android:extractNativeLibs="true"
        android:fullBackupContent="@xml/backup_rules"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:appComponentFactory="androidx.core.app.CoreComponentFactory"
        android:dataExtractionRules="@xml/data_extraction_rules">
        <activity
            android:name="io.fl1tz.ctf.MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
        <activity android:name="io.fl1tz.ctf.FlagActivity"/>
        <activity
            android:name="io.fl1tz.ctf.UnreachableActivity"
            android:exported="false"/>
        <provider
            android:name="androidx.startup.InitializationProvider"
            android:exported="false"
            android:authorities="io.fl1tz.ctf.androidx-startup">
            <meta-data
                android:name="androidx.emoji2.text.EmojiCompatInitializer"
                android:value="androidx.startup"/>
            <meta-data
                android:name="androidx.lifecycle.ProcessLifecycleInitializer"
                android:value="androidx.startup"/>
            <meta-data
                android:name="androidx.profileinstaller.ProfileInstallerInitializer"
                android:value="androidx.startup"/>
        </provider>
        <receiver
            android:name="androidx.profileinstaller.ProfileInstallReceiver"
            android:permission="android.permission.DUMP"
            android:enabled="true"
            android:exported="true"
            android:directBootAware="false">
            <intent-filter>
                <action android:name="androidx.profileinstaller.action.INSTALL_PROFILE"/>
            </intent-filter>
            <intent-filter>
                <action android:name="androidx.profileinstaller.action.SKIP_FILE"/>
            </intent-filter>
            <intent-filter>
                <action android:name="androidx.profileinstaller.action.SAVE_PROFILE"/>
            </intent-filter>
            <intent-filter>
                <action android:name="androidx.profileinstaller.action.BENCHMARK_OPERATION"/>
            </intent-filter>
        </receiver>
    </application>
</manifest>
```

then we double click on **MainActivity** to find out the function that's checking for the password : 

```java
public void checkPassword(View view) {
        String password = this.passwordInput.getText().toString();
        String correctPassword = getString(C0793R.string.secretpass);
        if (password.equals(correctPassword)) {
            Intent intent = new Intent(this, (Class<?>) FlagActivity.class);
            startActivity(intent);
        } else {
            this.resultText.setText("Incorrect password! ❌");
            this.resultText.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            this.resultText.setVisibility(0);
        }
    }
```

It's comparing it to **C0793R.string.secretpass** If they are equal we go to **FlagActivity**, but how can we find that secretpass ? let's search for secretpass using the search engine inside jadx ( click on CTRL + SHIFT + F )

![](https://private-user-images.githubusercontent.com/144800528/413027368-f3de8615-afac-499e-9d42-fd0e10d7d6a4.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzY4LWYzZGU4NjE1LWFmYWMtNDk5ZS05ZDQyLWZkMGUxMGQ3ZDZhNC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT00ZmM5NzY5ZjU4YmQxNzJkYWMyZDRhMDc2YTIzODM2ODNmNjlhNjIwZDRiMTQ2NTQ1YjViMmVmNDQwODAxZDIzJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.YLOS-Y2rNM0MvXGyA9hp1yHy-LPdy96rHPskFAPkHCA)

And boom we find the password : **th1s_is_n0t_the_flag_:(** which clearly tells us that this is just a step to pass through ! Now we input our correct password  and get to **FlagActivity** :

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027351-3780528e-daf2-4959-899d-d967b03e3c4f.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzUxLTM3ODA1MjhlLWRhZjItNDk1OS04OTlkLWQ5NjdiMDNlM2M0Zi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01NWMyNGZmYTZjNjAzNDcwOTk5OGY2NjBiMjQ4MjJmMTE5YWNlMTFlMTRkOWI0OGY4OWRhYTNhYTMzNTU1MzEyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.n2cM37IlZu-YkWMz3bXnmEwb8bb2L_pjw0oHYJJm5sU" alt="" width="337" data-align="center">

Now , we are supposed to look for something , a bit of research will show us that that suspicious string is in **Alien Language** ! , so i am going to use [dcode](https://www.dcode.fr/alien-language)

![](https://private-user-images.githubusercontent.com/144800528/413027362-7d723f4f-b556-47bc-b9f8-4dd421c2e42a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzYyLTdkNzIzZjRmLWI1NTYtNDdiYy1iOWY4LTRkZDQyMWMyZTQyYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05NmY1YjA0YzcwZWJjNjQ2ODYwMjFkZDExZTYzYjk2Mjc4MDQ2NmM4ZjE0ZDMzNGY1Y2NiNzMxZDQwYTBkYTQ2JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.HsCy1umqaG4tT32G3sIRIvXHs_nNO1Pc8cNcdWSZHiA)

Ohh , so it is asking us to look for the **UnreachableActivity** ! 

If we go back to our jadx we can find the activity there , and the interesting part is this : 

```java
public void onCreate(Bundle a) {
        super.onCreate(a);
        EdgeToEdge.enable(this);
        setContentView(C0793R.layout.activity_unreachable);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(C0793R.id.main), new OnApplyWindowInsetsListener() { // from class: io.fl1tz.ctf.UnreachableActivity$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return UnreachableActivity.lambda$onCreate$0(view, windowInsetsCompat);
            }
        });
        TextView e = (TextView) findViewById(C0793R.id.keyText);
        TextView f = (TextView) findViewById(C0793R.id.messageText);
        e.setText(new StringBuilder().append('w').append('o').append('h').append('o').append('o').append('_').append('y').append('o').append('u').append('_').append('f').append('o').append('u').append('n').append('d').append('_').append('t').append('h').append('e').append('_').append('k').append('e').append('y').toString());
        f.setText(new StringBuilder().append('h').append('m').append('m').append('m').append('m').append('m').append('m').append(' ').append('c').append('a').append('n').append(' ').append('y').append('o').append('u').append(' ').append('p').append('a').append('s').append('s').append(' ').append('i').append('t').append(' ').append('t').append('o').append(' ').append('t').append('h').append('e').append(' ').append('n').append('a').append('t').append('i').append('v').append('e').append(' ').append('f').append('u').append('n').append('c').append('t').append('i').append('o').append('n').append(' ').append('?').append('?').append('?').append('?').append('?').append('?').append('?').toString());
        System.loadLibrary("native-lib");
        String ok = InternetUtil.getKey("fakekeyfakekeyfakekey");
        List<Integer> L = Arrays.asList(-12, -12, -36, -34, -7, 111, -53, 9, -52, 24, -19, 60, 4, 11, 57, -25, -61, 42, 43, 24, -59, 7, 53, -17, -39, 36, 56, -1);
        StringBuilder newKeyBuilder = new StringBuilder();
        for (int i = 0; i < ok.length(); i++) {
            char currentChar = ok.charAt(i);
            int listValue = L.get(i % L.size()).intValue();
            char newChar = (char) (currentChar + listValue);
            newKeyBuilder.append(newChar);
        }
        String newKey = newKeyBuilder.toString();
        Log.i("topsecret:", newKey.substring(0, newKey.length() - 4) + "}");
    }
```

That's a lot xD ! U can reverse engineer the first part , or u can start the activity using adb ! but the thing is , in **AndroidManifest.xml** we can clearly see that the unreachable activity can't be exported : 

```java
<activity
            android:name="io.fl1tz.ctf.UnreachableActivity"
            android:exported="false"/>
```

So we need a ROOTED device , or we can recompile our apk and set the exported to "true" ! 

I'll go with the first method : 

![](https://private-user-images.githubusercontent.com/144800528/413027354-cc53d085-cfe3-44b0-897f-331d6ca62cd3.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzU0LWNjNTNkMDg1LWNmZTMtNDRiMC04OTdmLTMzMWQ2Y2E2MmNkMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0xODU3OTgyYmZlOTU1NGMzNDU2NTI0ZjMzNWNjODhmNTJkY2FiZTMzMTg1M2UwYzg0NDRhMTVlN2IyMjMzZmJkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.bdT_4HcOaZ3T4JrAcgpJtazOoJ2XhDfMuzvU0B0y92g)

And this is the result : 

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027358-023b5598-1184-473c-9767-555f5c7dfc2b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzU4LTAyM2I1NTk4LTExODQtNDczYy05NzY3LTU1NWY1YzdkZmMyYi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iNmY5ODMyZjE1NjI0MjRiMDZiNTE5YzJiYzU0MWQyYzdmZjg4MmRmZWJmNmUxZmQ4ZTJmOTBhYzVjMGNhOWFmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.eQwpnWiL6SqK5R8jF6-vM2Gp6bMrpB6aKIM70lb0a-s" alt="" data-align="center" width="371">

It is asking us to pass the key **wohoo_you_found_the_key** to the native function ,hmm what is a native function ? 

A **native function** in Android refers to a function written in **C** or **C++** instead of Java/Kotlin , you can read more here : [Add C and C++ code to your project](https://developer.android.com/studio/projects/add-native-code)

Now going back to our code this is the interesting part , where the native function is included : 

```java
        System.loadLibrary("native-lib");
        String ok = InternetUtil.getKey("fakekeyfakekeyfakekey");
        List<Integer> L = Arrays.asList(-12, -12, -36, -34, -7, 111, -53, 9, -52, 24, -19, 60, 4, 11, 57, -25, -61, 42, 43, 24, -59, 7, 53, -17, -39, 36, 56, -1);
        StringBuilder newKeyBuilder = new StringBuilder();
        for (int i = 0; i < ok.length(); i++) {
            char currentChar = ok.charAt(i);
            int listValue = L.get(i % L.size()).intValue();
            char newChar = (char) (currentChar + listValue);
            newKeyBuilder.append(newChar);
        }
        String newKey = newKeyBuilder.toString();
        Log.i("topsecret:", newKey.substring(0, newKey.length() - 4)
```

Oh , i get what he is asking !! he wants to change **"fakefakekeyfakekeyfakekey"**

with **wohoo_you_found_the_key** , how can we do that ??  There are many ways , we can build another apk and import the native function (how can we do that ? it's documented in android's website : [Link Gradle to your native library](https://developer.android.com/studio/projects/gradle-external-native-builds) ) and that part of code and change the key to the real one , then we launch our app and check for the log (we check the log because the last line is printing in the log !)

Another way is decompiling our app , change in the [smali](https://stackoverflow.com/questions/30837450/what-is-smali-code-android) and recompile again and start the unreachable activity again and check the log , We will do this one !

To decompile our app i am gonna use [Apktool](https://apktool.org/) ! 

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027356-876a560a-d2d6-45d3-aade-286a22e9fe70.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzU2LTg3NmE1NjBhLWQyZDYtNDVkMy1hYWRlLTI4NmEyMmU5ZmU3MC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0zYzI3OTNkMWE1YjcyYTFhZWVlOWI0NWI3ZDk2NWZhNGFhZTQ5ZTU0ZTc2OWI4N2MxYzU4NGQ0MjFjNGQzOGQ3JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.m157ibQ97nSjWzzqT48B832ytR1byB9g1xQ23ssxBiM" alt="" width="605" data-align="center">

Now we search for the **"UnreachableActivity"** in the smali and change it to our desired key :

![](https://private-user-images.githubusercontent.com/144800528/413027353-152769be-2ad4-4b1a-bf74-576758589c69.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzUzLTE1Mjc2OWJlLTJhZDQtNGIxYS1iZjc0LTU3Njc1ODU4OWM2OS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01OTk4YWI5MmJiMzhlNTYxY2MyZDAzZTA4YWNjMDdlZWU0MjI2NzFiN2Q3ZGVmMjA3ODQ0NTY2MDFlMDBjNmI1JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.qN1rClj8sTr8NWcDIKx5AgugxZoi76ciOUXuTYVt_qs)

We found the file , now we open an editor (I used codium) and change the key to the real one , after that we need to recompile our new app ( i used apktool again):

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027370-86986883-79c4-45ee-8ef1-3c715e5dccaa.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzcwLTg2OTg2ODgzLTc5YzQtNDVlZS04ZWYxLTNjNzE1ZTVkY2NhYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1jMjcwYTE5NWY0MmVmZWU2ZDQ0NTQzNTdiNDBlZDYwMzEwZjk5OWNjOWIzNzYzYzU0Yjk3YTEzMWFjYjRjZmU0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9._EGQPMiCnxI736LXKzigd3KhbXRomphkjzh36EQ7DEY" alt="" width="329" data-align="center">

Now we got our modded apk ! Time to sign it !

And to do that, I'll use **apksigner**, but first, we need to  generate a key using **keytool**. Starting with generating the key :

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027363-a7410f1b-38b8-4296-ab0f-1c742112e001.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzYzLWE3NDEwZjFiLTM4YjgtNDI5Ni1hYjBmLTFjNzQyMTEyZTAwMS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0xMDQ0NDUyZjJlOWY2ZGJlMDE3ZDVhMWI1NjlkMTkxM2QyOWEwNGU1MTJjOGIyMWYyNjQzYzJmOGVmMjgyMWI1JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.ENn0MP6Lm1nc6QABUGdcGNZkasU1XhWIAJqXV3FUQz8" alt="" width="546" data-align="center">

After we get our key we use it to sign the app by providing the password :

We can verify whether the apk was signed sucessfully or no using :

```
apksigner sign --ks strong-key.keystore --ks-key-alias mystrongkey   --ks-pass pass:mehmeh --key-pass pass:mehmeh   --out modded-signed-FL1TZ.apk FL1TZ/dist/Fl1TZ.apk
```

```
apksigner verify --print-certs modded-signed.apk
```

And finally we install it in our emulator using adb :

```
adb install -r modded-signed-FL1TZ.apk
```

![](https://private-user-images.githubusercontent.com/144800528/413027367-2346fd62-15f4-497f-8818-9d14da0c8eab.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzY3LTIzNDZmZDYyLTE1ZjQtNDk3Zi04ODE4LTlkMTRkYTBjOGVhYi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1hNGU4MTkxNTc3ODQ1NTVkNWI2Mjk2ZmEyNTAyMDAyZWI0MGRmYzk2OWQwZjlmY2NhMjBhNTRiYmY3MDFiZGE3JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.8LTx_7-VZ1CUSOFX4OgTxmWEw1Sclhj9hbCb8WOL4Jc)

Now we open the app in our emulator and relaunch our **"UnreachableActivity"** like we did before , then we see the logs ! we will be using logcat for that , and let's grep **topsecret** :

![](https://private-user-images.githubusercontent.com/144800528/413027360-08ea6ba3-463f-46e7-8b2c-6f213a2717bc.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzYwLTA4ZWE2YmEzLTQ2M2YtNDZlNy04YjJjLTZmMjEzYTI3MTdiYy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1hZmRhYzRkZjc1ZmE2OGIxZjYzMmE5MmFkZTM3YzAwOWQ3YjllN2VhZTdjMWU3MjhkYTllODYzMWYxZjc0YTZmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.e2Hoos8w7cUSUpZ7VuOjNMZ5r11e2gUYiSAuIgD6hVI)

 And that's our flag !! 

```
FL1TZ{Gl0ub_gra33_ft0ur_Sbe7}
```

---

I wanna link other writeups of this challenge  :

[anderouid_by_El-Mehdi-Dridi](https://github.com/El-Mehdi-Dridi/Mobile-CTF-Tasks/blob/main/FL1TZ/FL1TZ%20writeup.md)


---


