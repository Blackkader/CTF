**Challenge Name :** maze1

### **Category :** Reverse Engineering

### **Description :**

> this maze has no sense ! but have patience and do it it's really easy !
> `nc ctf.fl1tz.me 1036`
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'maze.py'_

---

### Solution

Seems like it's a remote challenge , hmm as we read the description it says **'this maze has no sense '**  and we have to have patience xD 

If we start the instance , it will tell us that we have to kill **IMU SAMA** 

Let's open our **maze.py** and lurk around , until we find this !

```python
def imu(char):
    printt("You see a giant monster with 3 heads , 6 arms and 9 legs")
    sleep(2)
    printt("He is the final boss 'IMU' , are you ready ???")
    sleep(2)
    printt("What are you going to do ?")
    square=Square("Fight","Run")
    square.display()
    choice = int(input("Enter your choice: "))
    if choice==2:
        printt("You are a coward , you run and you fall in a nothingness")
        sleep(2)
        exit()
    else:
        if (char.armament_haki==1 and char.observation_haki==1 and char.conqueror_haki==1 and char.stars==5 and char.glasses==1) :
            printt("You are the strongest , you defeat IMU and you are now the king of the island")
            sleep(2)
            printt("You can't be this strong ....")
            sleep(3)
            exit()
        else :
            printt("HAHAHAHAHAHAHAHA")
            exit()
```

Thus, the conditions to win are stated in this line : 

```python
(char.armament_haki==1 and char.observation_haki==1 and char.conqueror_haki==1 and char.stars==5 and char.glasses==1)
```

There is no other option beside reading the full code and figure out the right path to kill the boss while having those powerups (conditions) 

So here is the right path :

> 1-1-5-1-1-1-1-1-1-2-3-1-2-1-2-1-1-1

And by following this path we kill the boss and get this output :

Good job you killed imu sama with that PUNCH !!!
here is your key for the next challenge :

key:

```
FL1TZ{k3yl0ver5_UN1T3!:_t0geth3eR_w3_wILL_sOlv3_tH3_nExT_0n3!!}
```

Seems like the flag is telling us something hmmmm..

---
