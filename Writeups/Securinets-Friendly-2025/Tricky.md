## **Challenge Name :** Tricky
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'Tricky.apk'_

---

### Solution

Main activity has nothing , so we head to our **Dayum** activity and it's this : 

```java
public class Dayum extends AppCompatActivity {

    /* renamed from: P1 */
    private static final byte[] f191P1 = {-82, 55, 120, -59, -57, 18, -120, 91, -107, -90};

    /* renamed from: P2 */
    private static final byte[] f192P2 = {89, 82, 20, -56, -6, 16, -28, 119, -70, 63};

    /* renamed from: P3 */
    private static final byte[] f193P3 = {37, -107, -119, 65, 100, -101, 31, -48, 124, -127, 9, -31, -95, 18, -57, -77, -91, -78};

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(C0793R.layout.activity_main);
        String p1 = deobfuscate.decodePart(f191P1, 1);
        String p2 = deobfuscate.decodePart(f192P2, 2);
        String p3 = deobfuscate.decodePart(f193P3, 3);
        String encflag = p1 + p2 + p3;
        deobfuscate.m166f4(encflag);
    }
}
```
As we can see , the app generates the flag parts dynamically and never logs them or prints them , so we have to do that ourselves !! FRIDA AGAINNN :

```js
Java.perform(function () {
    var Dayum = Java.use("io.securinets.level11.Dayum");

    Dayum.onCreate.overload("android.os.Bundle").implementation = function(savedInstanceState) {
        this.onCreate(savedInstanceState); 

        try {

            var locals = Java.use('java.lang.reflect.Field');

           
            var deobfuscate = Java.use("io.securinets.level11.deobfuscate");
            deobfuscate.f4.implementation = function(encflag) {
                var decflag = this.f4(encflag); 
                console.log("[*] decflag: " + decflag); 
                return decflag; 
            };
        } catch (e) {
            console.error(e);
        }
    };
});


```
After attaching the script then starting  the activity using
```
adb shell am start -n io.securinets.level11/.Dayum
```
We simply get our flag :
```
[*] decflag: inecsuretS0yOu_dN{fu!tEO1_5t3c5lH}3__p
```
I meant our scrambled flag xD , now how to know the correct flag ? let's just dig deep in our ../../Ressources maybe  we find something interesting , and ofc we do : 

```java
<string name="CORRECTPOSITIONS_MUST_DELETE_LATER">[5, 6, 1, 2, 9, 3, 4, 7, 8, 0, 16, 11, 12, 13, 14, 19, 18, 10, 15, 17, 36, 21, 34, 26, 31, 20, 27, 28, 23, 33, 35, 25, 22, 37, 32, 24, 29, 30]</string>

```
Seems like the author forgot to delete this LOL , now our simple python script will do the job :
```python
scrambled = "inecsuretS0yOu_dN{fu!tEO1_5t3c5lH}3__p"

mapping=[5, 6, 1, 2, 9, 3, 4, 7, 8, 0, 16, 11, 12, 13, 14, 19, 18, 10, 15, 17, 36, 21, 34, 26, 31, 20, 27, 28, 23, 33, 35, 25, 22, 37, 32, 24, 29, 30]

reconstructed = [''] * len(scrambled)
for i, idx in enumerate(mapping):
    reconstructed[idx] = scrambled[i]

reconstructed_str = ''.join(reconstructed)
print("Reconstructed:", reconstructed_str)

```


```
Reconstructed: Securinets{yOu_f0uNd_tH3_lO5t_p13cE5!}
```
---