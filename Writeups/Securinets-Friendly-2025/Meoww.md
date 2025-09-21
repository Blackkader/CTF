## **Challenge Name :** Meoww
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'CatFinalBoss.apk'_

---

### Solution

We run our apk and it asks for creds YET AGAIN , we light up our jadx and we find the usual check : 
```java
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String encpass = MainActivity.encrypt(pass);
                if (user.equals("meowmeow") && encpass.equals("QUFBQUFBQUFBQUFBQUFBQQ==")) {
                    Toast.makeText(MainActivity.this, "Login successful!", 0).show();
```
Oh this time the pass is passed to the **encrypt** function , let's see what it does :
```java
    public static String encrypt(String password) {
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        return Base64.encodeToString(bytes, 2);
    }
```
Oh it's just base64 encoding ( is this a beginner ctf ? yes)
We again throw our encdoded expected password **QUFBQUFBQUFBQUFBQUFBQQ==** in cyberchef and we get our correct pass :
```
AAAAAAAAAAAAAAAA
```
We try our creds **(meowmeow / AAAAAAAAAAAAAAAA)** and we get this : 

![alt text](Ressources/8.png)

Ahh , now we're lost , or no ? let's just see what happens if we get our creds correctly following our code we find this interesting part :
```java

String error = MainActivity.decrypt("JBtDQAc6IV0gPiM5EC94cRBrJB1OMEYgBSwZKAwBdDR0bB4wAjk4HQgmCjwzIi08aW1gaQoyKF02EgcmEygfEmkbc14fGA5AEj4yJB82Aj0qLn11OmgzOBw/HB4KLTArHwJzHkd3VWE=", "SuperSecretKey123", 4);
                                Log.i("ERROR", error);
                        
```
Log ? if you search up a bit  you'll find that there is something called **LogCat** in android , it's a way to log stuff in the app , but why is it logging an **error** while we are putting the correct creds ? it's just the author misleading us , let's just open our LogCat wether using cli or androidstudio , i'll go for androidstudio and search for **ERROR** AND BOOM : 

![alt text](Ressources/9.png)


```
Securinets{AwWw_1ts_A_c4t!!_a_L0GCAT!!!}
```
---