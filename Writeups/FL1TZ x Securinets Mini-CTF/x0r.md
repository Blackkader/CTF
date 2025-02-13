### **Challenge Name :** x0r

### **Category :** Reverse Engineering

### **Description :**

> you are doing a good job guys !!! now its time for adventure so , for this challenge you have to search for the REAL key !! also learn a bit about xor and goodluck flag format : FL1TZ{}
>
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _a binary 'x0r'_

---

### **Solution**

Again , our usual bestfriend number 1

![](https://private-user-images.githubusercontent.com/144800528/413027335-1133c204-2552-4dc6-b678-2c4023a5f50a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzM1LTExMzNjMjA0LTI1NTItNGRjNi1iNjc4LTJjNDAyM2E1ZjUwYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0wNjZhMGM0ODA0YzM2ZDRkOGUwNjk5OGU2MjEwMGVmMDExODY0ZTE4Zjg5ZmE4YWI5OWIxZTNjOTE0NDNkZjkwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.3_JvnZ-VNoD-mohwlWuHD0ktvCiTDMuQf7pztar23Tc)

Running our second bestfriend strings won't get us anything leading except for a suspicious conversation between two people (FINN AND JAKE) 

> GO watch adventure time 

Let's try to run it 

![](https://private-user-images.githubusercontent.com/144800528/413027329-1294d8c1-3aa6-4531-ae47-cfa7efedb56e.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzI5LTEyOTRkOGMxLTNhYTYtNDUzMS1hZTQ3LWNmYTdlZmVkYjU2ZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05ODUyYTI1Yjg1ZTNhODYzY2Y1OWJkNTQ0YzNhMWRiNDQxZTE4MTU4ZmMzNWVkOWI4NWY5NzRhNTA0YmVjN2U2JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.ty5yigPH72ThQ1SBzdzfXK8rglfZAM7DBHIGd4-2Qgo)

Oh dang i don't have permission , time to give up  :/ 

NOPE , we are hackers we can do this 

A quick google research will tell us plenty about permission (or any ai chat as well)

So we have to get the execute permission and that's done by **chmod +x xoring**

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027340-96aea416-676a-4d0f-862b-8768a94d0fc2.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQwLTk2YWVhNDE2LTY3NmEtNGQwZi04NjJiLTg3NjhhOTRkMGZjMi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03NzRiYmZjYTA3OGFiMzZmYWQ2MzE5ODgxYjE1OGNjZWY5ZjhhNGUzZTYwZDgxYjRlZWU3YzZlZTFjNDY3YTM5JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.iETn4qitgqFDYSs3G3e-MZ_JrYfcIolHWUCIgdKvR5g" alt="" width="508" data-align="center">

As Finn said here , none of these keys worked !

OH wait jake actually suggested trying **frozen_pizza** as the key , he actually got us the real key damn ! 

> did you really think that's true xDD

Lets try to decompile our binary, this time i am gonna use [IDA](https://hex-rays.com/ida-free)

We look inside the main function's pseudo code and we find this :

![](https://private-user-images.githubusercontent.com/144800528/413027348-3a6275b8-5c64-477a-b802-b11b3ef28895.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQ4LTNhNjI3NWI4LTVjNjQtNDc3YS1iODAyLWIxMWIzZWYyODg5NS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1hZTQ1ODM2NzExMDQ5OGQwYWQ1MmYyYzBhMzNlNmE3ODM4YThlMTUyNmY0OGUzMjA1NDQ5YjE1NWJmZjI0OGUxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.NsEU2qzm6qx2oVQAV7TzhGUGTvgm5cEuLLeror9jtRg)

The interesting part is this :

![](https://private-user-images.githubusercontent.com/144800528/413027359-32c7443e-fadc-444f-ab8b-22a105e9a700.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzU5LTMyYzc0NDNlLWZhZGMtNDQ0Zi1hYjhiLTIyYTEwNWU5YTcwMC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mMDU1Njc1NTk4MzdjM2UwNDdhY2ViOTUxNWE0ZjM2NjdmNjY0ZTdiM2JhOTg4NzU3ZmQ5Y2E3MDlhMjFlYTgxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.-2KGsMQKSXTu2_tYyNqsIIWN2rRIIPx7YhijPYAJvSY)

Therefore we can confirm that our encrypted flag (**PH^nI~cnxBnPbb^RpEXgT**) is passed to the **hard_xor** function alongside the fake keys and our input which is **s1**

Our goal as i stated before is to find the real key , we can only do that by inderstanding what hard_xor is actually doing to our encrypted flag .

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027357-b79a5cba-76f0-4bce-8f9a-1e9016930b65.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzU3LWI3OWE1Y2JhLTc2ZjAtNGJjZS04ZjlhLTFlOTAxNjkzMGI2NS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05MTY5OWFiY2NlYTY2MmUyZDExZjljMmQ5OWE1MGRjNjBlMjA2YWU0NmEyYjliZGZlMDQxMmY3OWM4ZWQ4ZmYyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.bzQrz7GYbkSDJ3oovk35S-hM0QTGC_veONEZSgE5xXg" alt="" data-align="center">

                this looks hard :( 

            lets change variable names so it becomes easier to read

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027347-310ce39a-1c91-4e57-8865-9eacf474f31f.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQ3LTMxMGNlMzlhLTFjOTEtNGU1Ny04ODY1LTllYWNmNDc0ZjMxZi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mNDk5YmNlNDM0ZjE4ZGUxMmY0N2QyOGE0OTMyZmMxYjdmNGZiNDdhZmU5YmJlODEyYzExOWQ4NjlmMDQyMjdiJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9._iXcE10-3xdSRBjphILRmbZldnNfUGVhoc-CWsqSPbM" alt="" width="545" data-align="center">

 WAAY BETTER , 

we can say  that we have 3 strings a b c and **a=b^c**

how can we get b which is our key ??? we can only get it if we know that ***XOR is actually reversible***  >  **b=a^c**

I used [CyberChef]([CyberChef](https://gchq.github.io/CyberChef/)) to get our key !

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027330-04271ed1-f2ea-473c-b54e-67cd8c4db7c7.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzMwLTA0MjcxZWQxLWYyZWEtNDczYy1iNTRlLTY3Y2Q4YzRkYjdjNy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01MmVlMjBjMGYxZGRlNTBkZDFiOThmMDMwYTM5Nzc0NmVlMTcwMTVmY2M2YjcyMGY5NjgwNjc5ZjdlZTY3Y2QyJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.kfpFkfCN62XOvyHidRxl95BtbGjoB_1XpA_TEsoUPvo" alt="" width="546" data-align="center">

But is that really our key ???? NO if we go back to our **hard_xor** we see that 

while iterating we used  ``` key[ i % key_length] ``` so what we can actually get from the real key are the first 7 characters only ( length of ayo_x0R) , in our case they are "1111111".

We can also assume that the key should  be composed of the same character as it is impossible to know the rest of the key if key_length > 7 

we try to xor our encrypted flag with **1** or **1111111**

![](https://private-user-images.githubusercontent.com/144800528/413027306-b71e2ac7-d896-419b-8a6c-8e5e580d6458.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzA2LWI3MWUyYWM3LWQ4OTYtNDE5Yi04YTZjLThlNWU1ODBkNjQ1OC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT00YTY2NGIzYTlmYThkMWU1MWE0YjA1Y2FiOTE4OTZkOWZkYTNhNjI2Njk2MWUxMjVhNjg3M2ZkZmQ4MjE0MDQ2JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.n0iOF6W6ugNgq6k3yYkAztc-0T6rHDJVzUqjQgEp6Mk)

And as the description said : flag format : FL1TZ{} , this is our flag :

```
FL1TZ{ayo_xOR_Is_aSSocAtiVe}
```

Oh my god , **xor** is **reversible** and **associative** as well or is the author lying 

---
