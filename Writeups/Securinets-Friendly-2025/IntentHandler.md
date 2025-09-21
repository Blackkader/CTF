## **Challenge Name :** IntentHandler
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'IntentHandler.apk'_

---

### Solution
Well we start like usual , and this time we have this **unsolvable2** activity , let's take a peek : 
```java
package io.securinets.level8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes3.dex */
public class Unsolvable2 extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WinHelper wh = new WinHelper(this);
        Intent firstIntent = getIntent();
        if (firstIntent == null || !firstIntent.getAction().equals(getString(C0802R.string.action1)) || !firstIntent.getDataString().equals(getString(C0802R.string.uri1)) || firstIntent.getFlags() != getResources().getInteger(C0802R.integer.flag1)) {
            Toast.makeText(this, "BYE BYE! First Intent check failed", 0).show();
            finish();
            return;
        }
        wh.m167p0(firstIntent.getAction());
        wh.m167p0(firstIntent.getDataString());
        wh.m167p0(Integer.valueOf(firstIntent.getFlags()));
        Bundle firstExtras = firstIntent.getExtras();
        if (firstExtras == null || !firstExtras.containsKey("secondIntent")) {
            Toast.makeText(this, "BYE BYE! Second Intent missing", 0).show();
            finish();
            return;
        }
        Intent secondIntent = (Intent) firstExtras.getParcelable("secondIntent");
        if (secondIntent == null || !secondIntent.getAction().equals(getString(C0802R.string.action2)) || !secondIntent.getDataString().equals(getString(C0802R.string.uri2)) || secondIntent.getFlags() != getResources().getInteger(C0802R.integer.flag2)) {
            Toast.makeText(this, "BYE BYE! Second Intent check failed", 0).show();
            finish();
            return;
        }
        wh.m167p0(secondIntent.getAction());
        wh.m167p0(secondIntent.getDataString());
        wh.m167p0(Integer.valueOf(secondIntent.getFlags()));
        Bundle secondExtras = secondIntent.getExtras();
        if (secondExtras == null || !secondExtras.containsKey("thirdIntent")) {
            Toast.makeText(this, "BYE BYE! Third Intent missing", 0).show();
            finish();
            return;
        }
        Intent thirdIntent = (Intent) secondExtras.getParcelable("thirdIntent");
        if (thirdIntent == null || !thirdIntent.getAction().equals(getString(C0802R.string.action3)) || thirdIntent.getFlags() != (getResources().getInteger(C0802R.integer.flag3) | getResources().getInteger(C0802R.integer.flag4))) {
            Toast.makeText(this, "BYE BYE! Third Intent check failed", 0).show();
            finish();
        } else {
            wh.m167p0(thirdIntent.getAction());
            String errorMsg = wh.magic(getString(C0802R.string.errormsg));
            Log.i("Error, file not found : ", errorMsg);
        }
    }
}
```

This challenge is like the previous one , but this time
the  command **am start** wont help here , cause you can't give it a **Nested Intent** , so we have to develop our own apk !!! that sends the intent to our **Unsolvable2** activity ! and for that i used **android studio** and this is the **main activity** content:
```java
package io.securinets.solver8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Intent thirdIntent = new Intent();
        thirdIntent.setAction("intentac3");
        // Combine flag3 and flag4
        thirdIntent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT | Intent.FLAG_INCLUDE_STOPPED_PACKAGES);


        Intent secondIntent = new Intent();
        secondIntent.setAction("intentac2");
        secondIntent.setData(Uri.parse("intentu2"));
        secondIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        secondIntent.putExtra("thirdIntent", thirdIntent);


        Intent firstIntent = new Intent();
        firstIntent.setAction("intentac1");
        firstIntent.setData(Uri.parse("intentu1"));
        firstIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        firstIntent.putExtra("secondIntent", secondIntent);


        firstIntent.setClassName("io.securinets.level8", "io.securinets.level8.Unsolvable2");
        startActivity(firstIntent);
    }
}
```
Launching our apk will get us the flag in the logs : 



```
2025-09-20 19:18:22.841  7980-7980  Error, fil...t found :  io.securinets.level8                 I  Securinets{aN_1nTEnt_In5iDe_aN_1nTEnt_In5iDe_aN_1nTEnt!!!}

```
---
