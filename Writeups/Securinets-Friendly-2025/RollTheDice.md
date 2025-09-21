## **Challenge Name :** RollTheDice
### **Category :** Mobile

### **𝐀𝐮𝐭𝐡𝐨𝐫 : [𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫](https://github.com/Blackkader/)**
---

### **Files Given :** _'Dont return ! yet ...apk'_

---

### Solution

This is another **Dynamic Analysis** challenge , and as the name suggests , we will have to alter the return value of a certain function here , first let's launch our apk : 

![alt text](Ressources/14.png) 
![alt text](Ressources/15.png)

Oh we're rolling dices here ! and we only have once chance cause the button hides after our first try , damn it ! but what is the winning condition ? it's actually this: 

 ```java
 if (dice1.getText().equals("6") && dice2.getText().equals("7") && dice3.getText().equals("8") && dice4.getText().equals("9") && dice5.getText().equals("10")) {
```
But here is the catch , if  you run the app and roll multiple times ,  u'll notice that the max number is **5** ( you don't have to reverse thaat big scary function xd),
so we have to find a way to change the value of the dices to the desired ones , and for that we gonna use frida yet again and here is our script :
```js
Java.perform(function () {
    var Main = Java.use("io.securinets.level10.MainActivity");

    var callCount = 0;
    var forcedValues = [6,7,8,9,10];

    var original = Main.generate.overload().implementation;

    Main.generate.overload().implementation = function() {
        if (callCount < forcedValues.length) {
            var ret = forcedValues[callCount];
            console.log("generate() -> forced", ret);
            callCount++;
            return ret;
        }

        return original.apply(this, arguments);
    };
});

```
Same flow as the previous one , and yepp we forced the desired values :
![alt text](Ressources/16.png)

if we check the logcat : 


```
2025-09-20 19:50:07.298  8660-8660  WINNNNNEEEEEER          io.securinets.level10                I  Securinets{yOU_jUsT_r0LLEd_THE_p3rF3cT_sCOrE}
```
---