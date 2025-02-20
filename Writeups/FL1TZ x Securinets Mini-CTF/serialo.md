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

![](https://raw.githubusercontent.com/Blackkader/CTF/main/Ressources/image_18.png)

Oh the challenge is corrupted , it's not our problem , it's the author's fault 

IS ITTTT ???

Didn't i tell you that we have two bestfriends ??? one of them is the key for revealing the secret behind this file and that one bestfriend is **file**

![](https://raw.githubusercontent.com/Blackkader/CTF/main/Ressources/image_19.png)

ohh it's an executable , the author is just playing games with us , lets add the execution permission and try to run it 

<img title="" src="https://raw.githubusercontent.com/Blackkader/CTF/main/Ressources/image_20.png" alt="" width="489" data-align="center">

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

<img src="https://raw.githubusercontent.com/Blackkader/CTF/main/Ressources/image_21.png" title="" alt="" data-align="center">

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
