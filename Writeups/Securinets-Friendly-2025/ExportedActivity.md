## **Challenge Name :** ExportedActivity
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'ExportedActivity.apk'_

---

### Solution

For this one you will find 10 Stages , each stage is a different (and exported , for exported activities you can DIRECTLY start them using adb for example ) activity , you can find the conditions for each stage but the smart way is to find WHICH stage we need to get to so we can get the flag , and we can guess that it's the last stage !
Let's follow the idea (examining the last stage ):

```java
Intent intent = getIntent();
        String action = intent.getAction();
        if (!getString(C0803R.string.realflag).equals(action)) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
            return;
        }


 public void onClick(View v) {
                String answer = pz.getText().toString();
                try {
                    int[] whatsthis = Stage10.encrypt(answer);
                    if (Arrays.equals(whatsthis, Stage10.this.ahs_652)) {
                        Toast.makeText(Stage10.this, "CORRECT!", 0).show();
                        if (Stage10.this.isTemplate) {
                            try {
                                InputStream is = Stage10.this.getResources().openRawResource(C0803R.raw.woho);
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                byte[] buffer = new byte[1024];
                                while (true) {
                                    int read = is.read(buffer);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        baos.write(buffer, 0, read);
                                    }
                                }
                                is.close();
                                byte[] bytes = baos.toByteArray();
                                byte[] answerBytes = answer.getBytes(StandardCharsets.UTF_8);
                                for (int i = 0; i < bytes.length; i++) {
                                    bytes[i] = (byte) (bytes[i] ^ answerBytes[i % answerBytes.length]);
                                }
                                int i2 = bytes.length;
                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, i2);
                                if (bitmap != null) {
                                    rootLayout.setBackground(new BitmapDrawable(Stage10.this.getResources(), bitmap));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Stage10.this.isTemplate = false;
                        } else {
                            rootLayout.setBackgroundResource(C0803R.drawable.template);
                            Stage10.this.isTemplate = true;
                        }
                        loginButton.setVisibility(8);
                        pz.setVisibility(8);
                        return;
                    }
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
        Log.i("LOTF", Arrays.toString(key2));
        return key2;
    }
```
Seems like there is a check on the activity's **action** if its wrong it gets us out with BYE BYE msg , also our  winning condition is : **if (Arrays.equals(whatsthis, Stage10.this.ahs_652))** , another commong hash if we guess , will it be the same website tho ? 
A quick search on how to start activities WITH action u'll get to this command : 

```
adb shell am start -a "ActionValue" -n io.securinets.level6/.Stage10
```
Now all we need to do is find the correct action value and the correct password to get our flag , we see that the action value we provide is compared to  **realflag**:

```java
if (!getString(C0803R.string.realflag).equals(action)) {
            Toast.makeText(this, "BYE BYE!", 0).show();
            finish();
            return;
        }

```
Using the search option on jadx for **realflag** string gets us to the strings.xml in which we find the correct value :
```xml
   <string name="realflag">Securinets{f4k3_fl4g_doNt_sUbM1T!}</string>
```
IS that our flag ?? ofc no xd it's the expected action value , so our command becomes:
```
adb shell am start -a Securinets{f4k3_fl4g_doNt_sUbM1T!} -n io.securinets.level6/.Stage10
```
Executing the command successfully starts the stage10 activity ! , now we only need to find the correct password , as we said **10015.io** didnt work this time , let's try the [second website](https://md5decrypt.net/en/Sha256/) that pops up in google , and boom  we get our result : 

```
5d5b09f6dcb2d53a5fffc60c4ac0d55fabdf556069d6631545f42aa6e3500f2e : sha256
```
Ahhh the author actually hashed the string **sha256**  ! so we simply input this and we get our flag :

![alt text](Ressources/13.png)

```
Securinets{U_ju5T_l34RneD_4bout_AcT1vIti3S!!}
```
---