### **Challenge Name :** hexer

### **Category :** Reverse Engineering

### **Description :**

> soooo , this one can be considered as foren as well , i can telll you one thing : BYTES
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _a binary 'hexer'_

---

### **Solution**

Unfortunately, using the things we learned in the **strings** challenge won't get us anything leading 

And again , the key to solve the challenge is in the name and in the description _(why am i going easy on you guys)_

So what we want here are **BYTES !!**  

With a bit of research we will find out about **HEXDUMP**

> *A **hexdump** represents the raw **byte-level data** of a file in **hexadecimal format**. It visually organizes the file's contents, making it easier to inspect binary data* (chat gpt :D)
> 
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

Now how to extract the hexdump of the binary ???

There are maaany tools , and hexeditors (even online)

For me I prefer [xxd](https://www.tutorialspoint.com/unix_commands/xxd.htm) , so let's use that  and scroll a bit :

![](../.private_images/2025-02-11-22-09-00-image.png)

And bingo !

```
FL1TZ{g00d_JoB_y0U_RoCK_h4rd_82540bb05feic}
```

---
