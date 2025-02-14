**Challenge Name :** maze2

### **Category :** Reverse Engineering

### **Description :**

> imu REVIVEDDDDD !!!
> 
> you need to unlock the secret technique to kill him again !
> 
> Now you are in another planet looking for a new technique and while wondering there
> 
> a strange figure came to you and said :
> 
> the key resides here , but it is protected by the two spells : -A6H5S2 -obfuscation
> 
> can you overcome those ???
> 
> `nc ctf.fl1tz.me 1037`
> 
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'maze2.c'_

---

### Solution

Enough with mazes already ! 

After getting our flag from maze1 it seems like the boss revived (huh ?) 

It's time to put him to rest again 

When we connect to the instance , we can see we have to input some key 

<img src="https://private-user-images.githubusercontent.com/144800528/413027341-83f24065-309a-41f9-b248-4e1672babc22.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQxLTgzZjI0MDY1LTMwOWEtNDFmOS1iMjQ4LTRlMTY3MmJhYmMyMi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0xZGIyZTE3ZDZjNzg4MjcyMTE2ZGM2MThjN2FlNzRmNTliOTdiNzBmMjM4YTE5ZTVmMWQzYTJjMzAwOWFiMmVmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.DcO3qgpdD5kmN9yD1l-6aAabC2F5iwzLOFtVkFhsfAE" title="" alt="" data-align="center">

nothing happens, let's inspect our maze2.c file : (_I'll only put the main function_)

```c
int32_t main(int32_t argc, char** argv, char** envp)
{
    void* fsbase;
    int64_t rax = *(fsbase + 0x28);
    sr654h();
    printf("pass ? ");
    void buf;
    int32_t result;

    if (fgets(&buf, 0x64, __TMC_END__))
    {
        *(&buf + strcspn(&buf, u"\n…")) = 0;
        void var_178;
        abc123_def456("FL1TZ{y4_w3ld1_Jib_elFl4g_mel_MAZE}", &var_178);
        void var_138;
        ghi789_jkl012(&var_178, &var_138);
        int64_t s;
        __builtin_memset(&s, 0, 0x64);
        int32_t var_194_1 = 0;
        int32_t var_190_1 = 0;

        while (*(&var_138 + var_194_1))
        {
            if (print_ln(*(&var_138 + var_194_1), 4))
            {
                *(&s + var_190_1) = *(&var_138 + var_194_1);
                var_190_1 += 1;
            }

            var_194_1 += 1;
        }

        *(&s + var_190_1) = 0;

        if (strcmp(&buf, &s))
        {
            puts("dsl");
            result = 0;
        }
        else
        {
            FILE* fp = fopen("flag.txt", u"r…");

            if (fp)
            {
                while (true)
                {
                    char rax_24 = fgetc(fp);

                    if (rax_24 == 0xff)
                        break;

                    putchar(rax_24);
                }

                fclose(fp);
                result = 0;
            }
            else
            {
                puts("Error opening file");
                result = 1;
            }
        }
    }
    else
    {
        puts("Error reading input");
        result = 1;
    }

    *(fsbase + 0x28);

    if (rax == *(fsbase + 0x28))
        return result;

    __stack_chk_fail();
    /* no return */
}
```

we can see this fake key 

```
FL1TZ{y4_w3ld1_Jib_elFl4g_mel_MAZE}
```

It is actually asking us to use the flag from maze 1 ! which is this :

```
FL1TZ{k3yl0ver5_UN1T3!:_t0geth3eR_w3_wILL_sOlv3_tH3_nExT_0n3!!}
```

now let's inspect  the functions called in main :

**(sr654h / abc123_def456 / ghi789_jkl012 / print_ln)**

starting with **sr654h** , we can see that it's not contributing in the encryption of our key so we can ignore it ! 

moving on to **abc123_def456** :

```c
int64_t abc123_def456(char* arg1, int64_t arg2)
{
    int64_t rax = EVP_MD_CTX_new();
    EVP_DigestInit_ex(rax, EVP_sha256(), 0);
    EVP_DigestUpdate(rax, arg1, strlen(arg1));
    EVP_DigestFinal_ex(rax, arg2, 0);
    return EVP_MD_CTX_free(rax);
}
```

We can find something interesting !!! 

```c
                        EVP_sha256()
```

"FL1TZ{k3yl0ver5_UN1T3!:_t0geth3eR_w3_wILL_sOlv3_tH3_nExT_0n3!!}" is being hashed by sha-256 ?? we can confirm that by either copying the function and running it in another c file while inputing our string or by reading the description xd 

> the key resides here , but it is protected by the two spells : -A6H5S2 -obfuscation

seems like sha256 is just A6H5S2 but in shambles xd 

now time to see what is **ghi789_jkl012** doing here :

```c
void ghi789_jkl012(void* arg1, int64_t arg2)
{
    for (int32_t i = 0; i <= 0x1f; i += 1)
        sprintf(i * 2 + arg2, "%02x", *(arg1 + i));
}
```

It's formatting the string to hexa representation ! this confirms that it's hash 

sha-256!! so we cracked the first key ! 

now time to crack the obfuscation  and to do that , we have two ways :D 

**First way :** we forget about understanding it and just apply it to our hash (which is the intended solution )

and we get our key **d408d48448d8** !!

**Second way :** we try to understand what it actually does ( unnecessary !) :

by debugging the function and giving it different values we can confirm that it's a simple division by 4 xD so , this obfuscation thing is just taking the ascii code of each character of the resulted hash and see if it's divisible by 4 ( if yes concatinate it to the string key ) !!!

And here is our solver ! :

```python
import hashlib
hash=hashlib.sha256(b"FL1TZ{k3yl0ver5_UN1T3!:_t0geth3eR_w3_wILL_sOlv3_tH3_nExT_0n3!!}").hexdigest()
print("".join([e for e in hash if ord(e)%4==0]))
```

and we get our key again ! **d408d48448d8**

We put that into the server and we get the output :

```
RBA7TTT !!!

dude you are so good , am jealous 

you got the final technique called: REV IS EASY 

you destroy imu sama ,

your journey ends here 

FL1TZ{s0rry_f0r_M4k1nG_U_GO_thRoUGH_DAT_M4z3}
```

---
I also wanna include this writeup of Fries who solver the challenge like a pro : 
<a href="https://github.com/Fr1es5/FL1TZ-ctf-rev-writeups/tree/main/Maze2" target="_blank">oid_by_Fries</a>
---
