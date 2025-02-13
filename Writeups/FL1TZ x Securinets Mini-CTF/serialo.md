**Challenge Name :** serialo

### **Category :** Reverse Engineering

### **Description :**

> "this one is easy" find the name when the serial is this : 566C01447A4B47144473486F204E034F70012343754F505C435D
>
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'ser.tar'_

---

### Solution

Ok we have a .tar file **(an archive)** , let's extract it using the tar command

![](https://private-user-images.githubusercontent.com/144800528/413027344-e0d9948c-fec1-4ccb-8b84-2f1bb3639a24.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQ0LWUwZDk5NDhjLWZlYzEtNGNjYi04Yjg0LTJmMWJiMzYzOWEyNC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mMTNmNGE1OTc1NjcxY2E5ZDJhOTUyZmY5MDViMTE2YmU4ZDcxNzNiOTVkMWU1NGEzODVmNzU4MmIxZWM1ZThlJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.d8ZEdHI5SYI_o3arT4BxWjUHKGD6iKUoiATItV_avsQ)

Oh the challenge is corrupted , it's not our problem , it's the author's fault 

IS ITTTT ???

Didn't i tell you that we have two bestfriends ??? one of them is the key for revealing the secret behind this file and that one bestfriend is **file**

![](https://private-user-images.githubusercontent.com/144800528/413027309-2ebbf35e-b5dc-4430-b9e6-3bd08ceaaf3d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzA5LTJlYmJmMzVlLWI1ZGMtNDQzMC1iOWU2LTNiZDA4Y2VhYWYzZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1lMDQwYzFjNTExOGZmNDcwMzViZTIzN2NmZDE2N2Y2Y2E5MjJmNTc1ZWQ5YmVjZjI5ZjMwODQ0ZDMwNTQwYzU5JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.mHtRjV6yug_BvNQ5Ep_RQJeCxPr8WHdQGOi8gc54vAI)

ohh it's an executable , the author is just playing games with us , lets add the execution permission and try to run it 

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027361-eae3bc77-779f-4d95-a011-ec176826b0b3.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzYxLWVhZTNiYzc3LTc3OWYtNGQ5NS1hMDExLWVjMTc2ODI2YjBiMy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT02NDBjYWRmYjFiYjMwZDY2YTVhOTczOTkxMDlhMDYwNDZiOGJkY2RlMjFiZTRjZGEwMzM0MDBiNTk1NzU0NzRhJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.qr7tSHIg0a-fyQg0KtHDmYcg8aY-JQr5LlKIRly2Mpw" alt="" width="489" data-align="center">

Hmmm , a name and a serial , in the **description** it is asking us to find the name for this serial **566C01447A4B47144473486F204E034F70012343754F505C435D**

Time to decompile our program and see what it does , here comes **IDA**

```c
int __cdecl main(int argc, const char **argv, const char **envp)
{
  signed int v3; // ebp
  int i; // esi
  char v6; // [esp+Ch] [ebp-130h]
  _BYTE v7[2]; // [esp+Dh] [ebp-12Fh] BYREF
  char v8[100]; // [esp+10h] [ebp-12Ch] BYREF
  char Buffer[197]; // [esp+74h] [ebp-C8h] BYREF
  __int16 v10; // [esp+139h] [ebp-3h]
  char v11; // [esp+13Bh] [ebp-1h]

  memset(v8, 0, sizeof(v8));
  memset(Buffer, 0, sizeof(Buffer));
  v10 = 0;
  v11 = 0;
  v6 = 16;
  qmemcpy(v7, " 0", sizeof(v7));
  sub_4011B9(aInputName);
  scanf("%s", v8);
  v3 = 0;
  for ( i = 0; v3 < (int)strlen(v8); ++i )
  {
    if ( i >= 3 )
      i = 0;
    sprintf(Buffer, "%s%02X", Buffer, v8[v3++] ^ v7[i - 1]);
  }
  memset(v8, 0, sizeof(v8));
  sub_4011B9(aInputSerial);
  scanf("%s", v8);
  if ( !strcmp(v8, Buffer) )
    sub_4011B9(aCorrect);
  else
    sub_4011B9(aWrong);
  return 0;
}
```

Again , names are confusing , let's rename them to our liking

```c
int __cdecl main(int argc, const char **argv, const char **envp)
{
  signed int j; // ebp
  int i; // esi
  char v6; // [esp+Ch] [ebp-130h]
  _BYTE key[2]; // [esp+Dh] [ebp-12Fh] BYREF
  char input[100]; // [esp+10h] [ebp-12Ch] BYREF
  char Buffer[197]; // [esp+74h] [ebp-C8h] BYREF
  __int16 v10; // [esp+139h] [ebp-3h]
  char v11; // [esp+13Bh] [ebp-1h]

  memset(input, 0, sizeof(input));
  memset(Buffer, 0, sizeof(Buffer));
  v10 = 0;
  v11 = 0;
  v6 = 16;
  qmemcpy(key, " 0", sizeof(key));
  Print(aInputName);
  scanf("%s", input);
  j = 0;
  for ( i = 0; j < (int)strlen(input); ++i )
  {
    if ( i >= 3 )
      i = 0;
    sprintf(Buffer, "%s%02X", Buffer, input[j++] ^ key[i - 1]);
  }
  memset(input, 0, sizeof(input));
  Print(aInputSerial);
  scanf("%s", input);
  if ( !strcmp(input, Buffer) )
    Print(aCorrect);
  else
    Print(aWrong);
  return 0;
}
```

sooo , the interesting part is the part that generates the serial 

```c
for ( i = 0; j < (int)strlen(input); ++i )
  {
    if ( i >= 3 )
      i = 0;
    sprintf(Buffer, "%s%02X", Buffer, input[j++] ^ key[i - 1]);
  }
```

If we can reverse that we can get the name of the serial

Well , it's xor againn _( enough with the xor already )_

Didn't we learn that xor is reversible ???? Time to solve then..

But wait  !!! 

we have **i** starting from 0 and in the sprintf line we have key[i-1]

so for the first iteration we will get **key[-1]** ?????

This is not python , oupsss the author made an error , time to contact him 

DId he ?? 

Time for dynamic analysis :DD , let's put a breakpoint in the xor line 

> (You can right click in the pseudocode then click Synchronize with Ida view)

And when you get to the ida view , u look for the xor and set a breakpoint there, then you start debugging

Time to run our program and inspect the value of ecx ( which is our key[i-1])

<img src="https://private-user-images.githubusercontent.com/144800528/413027350-f63f9ea0-87fe-4543-adc1-d32c310d6ab7.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzM2OTAsIm5iZiI6MTczOTQ3MzM5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzUwLWY2M2Y5ZWEwLTg3ZmUtNDU0My1hZGMxLWQzMmMzMTBkNmFiNy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTAzMTBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0wYjEwNmFiNDU1NWFiNzY5ZTRjMWVkNjcxZjY0ZWY4ZGRmMThkYjQ5ZTZkMDlmNTI5MTgyM2MyMzg5N2YxODY3JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.V9_0pt3Ojzl-N7XFwl7G0-y8ZhMeW3fHYXvc2rd6XIs" title="" alt="" data-align="center">

boom ! **ecx=0x10=16**

Another two iterations will give the expected values of **key[0]=" "(0x20=32='ord(" ")')** and **key[1]="0"(0x30=48='ord("0")')**

Time for our solverrrrr :

```python
serial= "566C01447A4B47144473486F204E034F70012343754F505C435D"
key=" 0"+chr(16)
i=0
name=""
for j in range(0,len(serial)-1,2):
    if(i>=3):
        i=0
    name=name+chr(int(serial[j:j+2],16)^ord(key[i-1]))
    i=i+1

print(name)
```

Running the script will give us this output, which is our flag !

```
FL1TZ{W4tch_0n3_P13cE_plS}
```

**Is the author suggesting something ?? NO HE IS ORDERING YOU! (politely)**

---
