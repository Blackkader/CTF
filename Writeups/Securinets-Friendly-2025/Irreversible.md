## **Challenge Name :** Irreversible
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'Irreversible.apk'_

---

### Solution

We run the apk and it's the lovely creds again heheh , jadx time :
```java
public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                try {
                    int[] encpass = MainActivity.encrypt(pass);
                    if (user.equals("itsnothardiswear") && Arrays.equals(encpass, MainActivity.this.ahs)) {
                        Toast.makeText(MainActivity.this, "Login successful!", 0).show();
                        
```
Another encrypt : 

```java
public static int[] encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashed) {
            String hex = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        String hexResult = hexString.toString();
        int[] key2 = new int[hexResult.length()];
        for (int i = 0; i < hexResult.length(); i++) {
            key2[i] = hexResult.charAt(i);
        }
        return key2;
    }

```
It's hasing the password with SHA-256 and then converting it to an array of ints , BUT aren't hashes irreversible ? ( task name :D ) Yes but **Common Hashes** are another thing , we can simply search for a website that uses a database of common hashes and our first google result is 
[this](https://10015.io/tools/sha256-encrypt-decrypt)

We throw our hash (after converting it to hex) in t he website and we get the correct pass : 

![alt text](Ressources/11.png)

```
123456789123456789
```
We try our creds **(itsnothardiswear / 123456789123456789)** and we get our flag :

![alt text](Ressources/12.png)

Seems like we used the author's favorite website heh.
```
Securinets{10015.io_1s_mY_f4VoR1t3!!}
```
---