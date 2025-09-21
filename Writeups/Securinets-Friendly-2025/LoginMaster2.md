## **Challenge Name :** LoginMaster2
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'LoginMaster2.apk'_

---

### Solution

Againn our lovely creds , jadx time : 

```java
public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                int[] encpass = MainActivity.encrypt(user, pass);
                if (user.equals("logedin") && Arrays.equals(encpass, MainActivity.this.secrets)) {
                    Toast.makeText(MainActivity.this, "Login successful!", 0).show();
                    
```
Another **encryption function** that uses the login "**logedin**" for the encryption process alongside the **pass** then compares the encrypted result to **secrets** hmm  , let's see what it does first :
```java
public static int[] encrypt(String login, String password) {
        int[] encrypted = new int[password.length()];
        int[] loginBytes = new int[login.length()];
        for (int i = 0; i < login.length(); i++) {
            loginBytes[i] = login.charAt(i);
        }
        for (int i2 = 0; i2 < password.length(); i2++) {
            int xorChar = password.charAt(i2) ^ loginBytes[i2 % loginBytes.length];
            int rotChar = ((xorChar << 3) & 255) | ((xorChar & 255) >> 5);
            encrypted[i2] = rotChar;
        }
        return encrypted;
    }
```
Oh it's a combination of shifting and xoring (which is reversible), now time to find our **secrets** which our declared in the **MainActivity** class :
```java
private int[] secrets = {89, 233, 49, 89, 1, 33, 121, 249, 217, 17, 185, 42};
```
We can now write python script to generate the expected password : 

```python
def decrypt_password(login, encrypted):
    login_bytes = [ord(c) for c in login]
    decrypted = ""

    for i, val in enumerate(encrypted):
        
        xor_char = ((val & 0xFF) >> 3) | ((val << 5) & 0xFF)
        original_char = xor_char ^ login_bytes[i % len(login_bytes)]
        decrypted += chr(original_char)
    return decrypted
secrets = [89, 233, 49, 89, 1, 33, 121, 249, 217, 17, 185, 42]
dec = decrypt_password(login, secrets)
print("Decrypted pass :", dec)

```
And we gout our output :
```
Decrypted: GRANDMASTER!
```
Now we try our creds **(logedin / GRANDMASTER!)** and we get our flag :

![alt text](Ressources/10.png)


```
Securinets{l0g1n_gR4Ndm4st3R_1s_p0pP1nG!}
```
---