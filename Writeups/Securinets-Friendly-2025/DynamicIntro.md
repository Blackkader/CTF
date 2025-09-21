## **Challenge Name :** DynamicIntro
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'DynamicIntro.apk'_

---

### Solution

As the name suggets , this challenge is about **Dynamic Analysis** enough with static ... And if you say Dynamic in android  you say **Frida** ! but let's take a look at our **MainActivity** first :

```java
public class MainActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(C0794R.layout.activity_main);
        AppCompatButton loginButton = (AppCompatButton) findViewById(C0794R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() { // from class: io.securinets.level9.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MainActivity.this.WIN("canyouchangethisargument?idontthinksohahahaahahahaha");
            }
        });
    }

    protected void WIN(String key) {
        if (key.equals("CHANGED!")) {
            WinHelper wh = new WinHelper(this);
            String winner = wh.magic(getString(C0794R.string.waaat));
            Log.i("WINNNN", winner);
            return;
        }
        Log.i("LOSER", "LOSER");
    }
}
```
As we can see , the winning condition is calling the function **WIN** with the argument **CHANGED!** , how to do that ? we can change in the **smali** code or we can use **frida** , hook our function and change the argument ! we will go with the second approach , here is the frida script : 

```js
Java.perform(function () {
    var Dynamic1 = Java.use("io.securinets.level9.MainActivity");

    Dynamic1.WIN.overload('java.lang.String').implementation = function (key) {

        var newKey = "CHANGED!";
  
       return this.WIN(newKey);
    };
});
```
We start our apk first , we start our **frida server** and then we attach our script to the **apk** , then we click on our **TRY** button , finally we check the logcat :


```
2025-09-20 19:33:11.523  8326-8326  WINNNN                  io.securinets.level9                 I  Securinets{fR1d4_1s_y0uR_BEST_frI3ND}
```
---