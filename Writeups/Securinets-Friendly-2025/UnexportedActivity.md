## **Challenge Name :** UnexportedActivity
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'UnexportedActivity.apk'_

---

### Solution

This time it's **UNEXPORTED** so we can't directly start it with adb , we have to have a rooted emulator/device ! for that you can simply follow any guide on how to root your device , personally i followed this [video](https://www.youtube.com/watch?v=iFI6cutuedc) . Soo after getting your rooted device , you go to the **adb shell** then type **su** then u'll become root , after that you type **am start bla bla**  let's take a look at our Unexportedactivity which is named **Unsolvable** : 
```java
public class Unsolvable extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WinHelper wh = new WinHelper(this);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null || !action.equals(getString(C0802R.string.akshen))) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
            return;
        }
        wh.m167p0(action);
        Uri data = intent.getData();
        if (data == null || !data.toString().equals(getString(C0802R.string.URI))) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
            return;
        }
        wh.m167p0(data);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
            return;
        }
        if (!extras.containsKey("whatisthis") || !extras.containsKey("number") || !extras.containsKey("verificator")) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
            return;
        }
        String secretValue = extras.getString("whatisthis");
        int numberValue = extras.getInt("number");
        boolean verificatorValue = extras.getBoolean("verificator");
        if (!getString(C0802R.string.ekstra1).equals(secretValue) || numberValue != getResources().getInteger(C0802R.integer.ekstra2) || !verificatorValue) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
        } else {
            wh.m167p0(Integer.valueOf(numberValue));
            wh.m167p0(secretValue);
            String errorMsg = wh.magic(getString(C0802R.string.errormsg));
            Log.i("Error, file not found : ", errorMsg);
        }
    }
}

```
What's an intent ?
* **Summary** : An intent in Android is like a message you send that tells the system or another app what you want to do, such as opening a screen, sharing a photo, or starting a service in the background.
* [Docs](https://developer.android.com/reference/android/content/Intent)
* [YT video](https://www.youtube.com/watch?v=4AG-h-zoY4g)

So the intent must have an **action** equals to **akshen**'s value and a **data** , and the data must be a **uri** , and the uri must be the same as the **URI** string in the strings.xml , and the intent must have a **bundle** (extras) with the keys **whatisthis**  , **number**  and **verificator**  , the value of the **whatisthis** must be the same as the **ekstra1** string in the strings.xml , the value of **number** must be the same as the **ekstra2** integer in the **Integers.xml** and the value of **verificator** must be true !
And if everything is correct it logs our flag as **error** ( yet again ) in the **logcat**.
Let's find those values , starting with **Strings.xml**:
```xml
<string name="akshen">fully actioned</string>
<string name="URI">https://app.securinets.io/free/palestine</string>
<string name="ekstra1">awel extra</string>

```
And now for the **Integers.xml** :
```xml
<integer name="ekstra2">999</integer>
```
We have all we need to start our **Unsolvable** Activity ! and that can be done with this command (after getting rooted : adb shell then  su):
```
am start -n io.securinets.level7/.Unsolvable -a 'fully actioned' -d 'https://app.securinets.io/free/palestine' --es whatisthis 'awel extra' --ei number 999 --ez verificator tru

```
And boom we get the flag in the logs :
```
2025-09-20 18:52:16.152  7359-7359  Error, fil...t found :  io.securinets.level7                 I  Securinets{G00d_c4tCh_EZ_uN3xPOrTEd_4Ctivity}
```
---