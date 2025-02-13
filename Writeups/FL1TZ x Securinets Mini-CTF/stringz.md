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

![](https://private-user-images.githubusercontent.com/144800528/413027304-538e4a9d-b53a-4617-9620-da1e060a0e96.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzA0LTUzOGU0YTlkLWI1M2EtNDYxNy05NjIwLWRhMWUwNjBhMGU5Ni5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03YjIwOWVhNmJkYzYyNzYzOTA3NGNmMDYyZmEyM2E3M2VkOTJjZWZjOTU2NWIwYmIwYzhlNzU3YTdjOTdjNDljJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.SBeRZMUYtj0RUHXnKiBmhH3AH1JLLLVXHOovOiY7DDs)

We can see that it's an executable which is built for 64-bit and compiled for the **x86-64 (AMD64) architecture** and for **Linux kernel version 4.4.0** or newer.

> You have to learn more about the file command !!!!!!!

Running the file won't give us anything useful :/ 

So let's try  to use this website [Dogbolt](https://dogbolt.org/) which was provided in the description, we get this result :

<img src="https://private-user-images.githubusercontent.com/144800528/413027336-6b8340d8-a48f-452a-8ceb-b9b1967ffde4.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzM2LTZiODM0MGQ4LWE0OGYtNDUyYS04Y2ViLWI5YjE5NjdmZmRlNC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kNjQzZjczMDg5NjJlNTk0YTAxZWE4ZDkxY2EyMWE2NzM5MzgxOTU2NDNhNDQzOWNiMjQzY2Q0N2Y3NDQ4ODI4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.5dQsIkDhwbWkw_fWDxRAso-6pW9oZ7Fsh2p42Nj8DxU" title="" alt="" data-align="center">Let's choose any one of those and try to search for the flag format _FL1TZ_

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027326-c3a3c135-f853-40bf-8f8a-a61953ced8b8.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzI2LWMzYTNjMTM1LWY4NTMtNDBiZi04ZjhhLWE2MTk1M2NlZDhiOC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iN2NmODEzY2UyNTc2YWUzZjFhZWNkNjY3ODY2MmQ4NGY4ZDgzODQxY2Q5Y2E0NDFiNzg4YWFjMDkyMTc1ZTVjJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.HFhsR6nvoOUB1uvtNFSo3-a9-6FmaSW2X5GU7K8j0x4" alt="" width="278" data-align="center">

And we find our flag : 

```
FL1TZ{wOhOO_y0U_ar3_A_h3cKeR}
```

There is another way to solve this challenge ! And it is the intended way :

As it says in the description (**the hint is given in the name of the BINARY**)

What is the name of the binary ? "**strings**" 

A beginner **Linux** user will know what we exactly want here , which is the [strings command](https://www.ibm.com/docs/en/aix/7.2?topic=s-strings-command), let's try to use it on our binary 

> If you had typed the name of the binary twice (with a space in between), you would have gotten the flag xD

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027307-2661ad06-0bf2-47d6-8191-f3d20fdd3e2f.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzA3LTI2NjFhZDA2LTBiZjItNDdkNi04MTkxLWYzZDIwZmRkM2UyZi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1jNDZiNGEyYTMzNjJiMWYwMzkzNzkyOTg5NDljMWE0ZjA5MzIwNTJkNzExMDAwMTk3NWJhYjhiZTIzZDAwMjY4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.h84q7RGqh9fF-m2op5Ro_iC1gjPwlFDlKluPd_sOwv8" alt="" width="363" data-align="center">

**MUST KNOW** : file and strings are the number one step we always do in each challenge , they are information gatherers and our bestfriends !!

---
