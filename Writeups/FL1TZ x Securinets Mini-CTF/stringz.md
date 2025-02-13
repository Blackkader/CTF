### **Challenge Name :** _stringz_

### **Category :** _Reverse Engineering_

### **Description :**

> Hello players, this is serious you have to hack !! today you are gonna learn a new command !!! the hint is given in the name of the BINARY. First of all ? what is a binary ? what is an executable ?�?[tutorial](https://www.youtube.com/watch?v=WnqOhgI_8wA)�?there is magic called DECOMPILATION ! you can do it with many tools like GHIDRA or IDA also this website works well�?[Dogbolt](https://dogbolt.org/)
> 
> GOOD LUCK !! (you will need it , this challenge is very hard !!!)
>
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _a binary 'stringz'_

---

### **Solution**

The first we usually use while reverse engineering is the [file command](https://www.geeksforgeeks.org/file-command-in-linux-with-examples/)

![](../.private_images/2025-02-11-22-12-18-image.png)

We can see that it's an executable which is built for 64-bit and compiled for the **x86-64 (AMD64) architecture** and for **Linux kernel version 4.4.0** or newer.

> You have to learn more about the file command !!!!!!!

Running the file won't give us anything useful :/ 

So let's try  to use this website [Dogbolt](https://dogbolt.org/) which was provided in the description, we get this result :

<img src="../.private_images/2025-02-11-21-43-24-image.png" title="" alt="" data-align="center">Let's choose any one of those and try to search for the flag format _FL1TZ_

<img title="" src="../.private_images/2025-02-11-21-44-38-image.png" alt="" width="278" data-align="center">

And we find our flag : 

```
FL1TZ{wOhOO_y0U_ar3_A_h3cKeR}
```

There is another way to solve this challenge ! And it is the intended way :

As it says in the description (**the hint is given in the name of the BINARY**)

What is the name of the binary ? "**strings**" 

A beginner **Linux** user will know what we exactly want here , which is the [strings command](https://www.ibm.com/docs/en/aix/7.2?topic=s-strings-command), let's try to use it on our binary 

> If you had typed the name of the binary twice (with a space in between), you would have gotten the flag xD

<img title="" src="../.private_images/2025-02-11-21-50-26-image.png" alt="" width="363" data-align="center">

**MUST KNOW** : file and strings are the number one step we always do in each challenge , they are information gatherers and our bestfriends !!

---
