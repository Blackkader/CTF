## **Challenge Name :** LoginMaster
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'LoginMaster.apk'_

---

### Solution

We run the apk on our emulator and turns out it is asking for creds : 

![alt text](Ressources/1.png)

We try something random and it says invalid creds: 

![alt text](Ressources/2.png)

Time for **jadx** now , we throw our apk there and head for the **MainActivity** and find our interesting check :
```java
 public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (user.equals("login") && pass.equals("MASTER!")) {
                    Toast.makeText(MainActivity.this, "Login successful!", 0).show();
                   
```
There you go , if you get the logs correct it takes the **woho.png** and xors it with the correct **password** : **MASTER!** , and you get the flag in the **xored/decrypted** png ! we try our correct logs **(login / MASTER!)** and we get our flag !
![alt text](Ressources/3.png)


```
Securinets{l0g1n_m4st3R_1s_HERE!}
```
---