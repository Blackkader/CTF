### **Challenge Name :** x0r

### **Category :** Reverse Engineering

### **Description :**

> you are doing a good job guys !!! now its time for adventure so , for this challenge you have to search for the REAL key !! also learn a bit about xor and goodluck flag format : FL1TZ{}
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _a binary 'x0r'_

---

### **Solution**

Again , our usual bestfriend number 1

![](../.private_images/2025-02-11-22-20-10-image.png)

Running our second bestfriend strings won't get us anything leading except for a suspicious conversation between two people (FINN AND JAKE) 

> GO watch adventure time 

Let's try to run it 

![](../.private_images/2025-02-11-22-21-09-image.png)

Oh dang i don't have permission , time to give up  :/ 

NOPE , we are hackers we can do this 

A quick google research will tell us plenty about permission (or any ai chat as well)

So we have to get the execute permission and that's done by **chmod +x xoring**

<img title="" src="../.private_images/2025-02-11-22-27-17-image.png" alt="" width="508" data-align="center">

As Finn said here , none of these keys worked !

OH wait jake actually suggested trying **frozen_pizza** as the key , he actually got us the real key damn ! 

> did you really think that's true xDD

Lets try to decompile our binary, this time i am gonna use [IDA](https://hex-rays.com/ida-free)

We look inside the main function's pseudo code and we find this :

![](../.private_images/2025-02-11-22-37-17-image.png)

The interesting part is this :

![](../.private_images/2025-02-11-22-36-25-image.png)

Therefore we can confirm that our encrypted flag (**PH^nI~cnxBnPbb^RpEXgT**) is passed to the **hard_xor** function alongside the fake keys and our input which is **s1**

Our goal as i stated before is to find the real key , we can only do that by inderstanding what hard_xor is actually doing to our encrypted flag .

<img title="" src="../.private_images/2025-02-11-22-40-02-image.png" alt="" data-align="center">

                this looks hard :( 

            lets change variable names so it becomes easier to read

<img title="" src="../.private_images/2025-02-11-22-41-35-image.png" alt="" width="545" data-align="center">

 WAAY BETTER , 

we can say  that we have 3 strings a b c and **a=b^c**

how can we get b which is our key ??? we can only get it if we know that ***XOR is actually reversible***  >  **b=a^c**

I used [CyberChef]([CyberChef](https://gchq.github.io/CyberChef/)) to get our key !

<img title="" src="../.private_images/2025-02-11-22-47-39-image.png" alt="" width="546" data-align="center">

But is that really our key ???? NO if we go back to our **hard_xor** we see that 

while iterating we used  ``` key[ i % key_length] ``` so what we can actually get from the real key are the first 7 characters only ( length of ayo_x0R) , in our case they are "1111111".

We can also assume that the key should  be composed of the same character as it is impossible to know the rest of the key if key_length > 7 

we try to xor our encrypted flag with **1** or **1111111**

![](../.private_images/2025-02-11-22-52-26-image.png)

And as the description said : flag format : FL1TZ{} , this is our flag :

```
FL1TZ{ayo_xOR_Is_aSSocAtiVe}
```

Oh my god , **xor** is **reversible** and **associative** as well or is the author lying 

---
