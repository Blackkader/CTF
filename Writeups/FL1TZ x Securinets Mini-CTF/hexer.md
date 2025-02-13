### **Challenge Name :** hexer

### **Category :** Reverse Engineering

### **Description :**

> soooo , this one can be considered as foren as well , i can telll you one thing : BYTES
>
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

![](https://private-user-images.githubusercontent.com/144800528/413027349-55bd5a03-b295-47bb-802b-ab545be1e9b8.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQ5LTU1YmQ1YTAzLWIyOTUtNDdiYi04MDJiLWFiNTQ1YmUxZTliOC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1lYTY1MmQyOTJlMmFkNWM1ZmI4MDY2YTRkYWNkNDhkNmJkMWUyNmJiNDhkZDQ5YTFiMzRkNTY2MTk1NDJlOGJiJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.pTy4Bu9fi3NoPZEM1hMD6DmT6SbPkBBtGEC0Hmj5Sd0)

And bingo !

```
FL1TZ{g00d_JoB_y0U_RoCK_h4rd_82540bb05feic}
```

---
