import colorama
from colorama import Fore, Style
from time import sleep
import sys


colorama.init()

class Square:
    title=">>>>>OPTIONS<<<<<"
    def __init__(self, *options):
        self.options = options

    def display(self):

        numbered_options = [f"[{i+1}] {opt}" for i, opt in enumerate(self.options)]
        max_content_width = max(len(self.title), *(len(opt) for opt in numbered_options))
        box_width = max_content_width + 8 


        top_border = f"{Fore.GREEN}╔{'═' * (box_width - 2)}╗{Style.RESET_ALL}"
        bottom_border = f"{Fore.GREEN}╚{'═' * (box_width - 2)}╝{Style.RESET_ALL}"
        empty_line = f"{Fore.GREEN}║{' ' * (box_width - 2)}║{Style.RESET_ALL}"
        separator = f"{Fore.GREEN}║{'─' * (box_width - 2)}║{Style.RESET_ALL}"  


        title_line = f"{Fore.GREEN}║{Fore.WHITE}   {self.title.center(max_content_width)}   {Fore.GREEN}║{Style.RESET_ALL}"


        option_lines = []
        for i, option in enumerate(self.options, 1):
            option_text = f"[{i}] {option}"
            padded_option = f"{Fore.WHITE}   {option_text.ljust(max_content_width)}   "
            option_lines.append(f"{Fore.GREEN}║{padded_option}{Fore.GREEN}║{Style.RESET_ALL}")


        printt(top_border)
        printt(empty_line)
        printt(title_line)
        printt(empty_line)
        printt(separator)  
        printt(empty_line)
        for line in option_lines:
            printt(line)
        printt(empty_line)
        printt(bottom_border)

class character:
    def __init__(self,name,armament_haki=0,observation_haki=0,conqueror_haki=0,stars=0):
        self.name=name
        self.armament_haki=armament_haki
        self.observation_haki=observation_haki
        self.conqueror_haki=conqueror_haki
        self.stars=stars
def printt(*args):
    print(*args)
    sys.stdout.flush()


def doffy(char):
    printt("You see a very tall man who is dressed in pink and has a pair of glasses")
    sleep(3)
    printt("You feel the urge to fight him , because you are a true warrior !")
    sleep(2)
    printt("What are you going to do ?")
    square=Square("1","2","3","4","4 but weaker ")
    square.display()
    choice = int(input("Enter your choice: "))
    if choice ==1 or choice==2 or choice==3:
        printt("You really didn't use gear fourth ? you are dead sadly ")
        sleep(2)
        exit()
    elif choice==4:
        printt("You used gear fourth and you defeated doffy ( no diff )")
        sleep(2)
        printt("Now you decided to follow the feet traces so you went back there")
        sleep(2)
        forest(char)
    elif choice==5:
        printt("You used gear fourth and you defeated doffy ( no diff )")
        sleep(2)
        printt("Now you decided to follow the feet traces so you went back there")
        sleep(2)
        char.glasses=1
        forest(char)
    




def hole(char):
    printt("You are now in a tight hole between the giant rocks !")
    sleep(2)
    printt("You see a strange button out of nowhere")
    sleep(2)
    printt("What are you going to do ?")
    square=Square("Press the button","GO ahead","Go back")
    square.display()
    choice = int(input("Enter your choice: "))
    if choice==1:
        printt("Good choice , you pressed the button and you got observation haki !!")
        sleep(2)
        char.observation_haki=1
        printt("You feel stronger so you move forward ")
        sleep(2)
        doffy(char)
    elif choice==2:
        printt("You feel some strong aura ahead but you still continue forward  ")
        sleep(2)
        doffy(char)
    else:
        printt("You go back")
        sleep(2)
        island(char,1)
    
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
            with open("flag.txt","r") as f:
                printt(f.read())
            sleep(5)
            exit()


def blackhole(char):
    printt("What are you going to do now ? what do people do in blackholes ??")
    square=Square("Swim","Cry","Power Up")
    square.display()
    choice = int(input("Enter your choice: "))
    if choice==2:
        printt("You cried too hard that you unlocked conqueror haki !!!")
        sleep(3)
        char.conqueror_haki=1
        square=Square("Swim","Power Up")
        square.display()
        choice = int(input("Enter your choice: "))
        if choice==2:
            printt("Power up ? who do you think you are ??? goku ?? get out !")
            sleep(1)
            exit()
        else :
            printt("You swim for a long time until you reach mars !")
            sleep(1)
            printt("And suddenly a THIEF (with a dog) who gets close to you  and says :")
            sleep(1)
            printt("Hey you look weak , i am bitraven the thief and this is my dog 'musashi-grabs' , do you like algebra ??")
            sleep(2.5)
            square=Square("Yes","No")
            square.display()
            choice=int(input("Just answer honestly :"))
            if choice==1:
                printt("You are a good person , i like you ")
                sleep(2)
                printt("SIKEEEE YOU REALLY LIKE ALGEBRA ????????  THE THIEF ROBBED YOU !!! (what did he take tho)")
                sleep(2)
                char.armament_haki=0
            else:
                printt("You are a good person , i like you <3 , no one likes algebra ")
                sleep(2)
                printt("The thief dies and the dog becomes a butterfly and flies away")
                sleep(2)
                printt("Now you go back to the island ")
                sleep(2)
                printt("That was a tough journey , you are now stronger , the strongest you have ever been")
                sleep(3)
                printt("What you wanna do now ? ")
                square=Square("Chill")
                square.display()
                choice=int(input("Enter your choice :"))
                if choice==1:
                    printt("While chilling you blinked and you got teleported to a dark room")
                    sleep(2)
                    printt("A magician approaches you and says : ")
                    sleep(2)
                    printt("Can you decode this for me ? and i'll teleport you to the last boss !")
                    sleep(2)
                    printt("6714o4453486iF004E036iF70010i34375i6F50i5Ci63oaiu")
                    sleep(2)
                    square=Square("Tell him that he should do it","Accept")
                    square.display()
                    choice=int(input("Enter your choice :"))
                    if choice==2:
                        printt("Decoding is for other challenges not this one , get out !")
                        sleep(2)
                        exit()
                    else :
                        printt("You told him : You are a magician you should do it yourself !")
                        sleep(2)
                        printt("He actually remembers that he is a magician and thanks you for that ! he decodes his key and teleport you !!!!!!!")
                        sleep(4)
                        imu(char)
    elif choice==3:
        printt("Power up ? who do you think you are ??? goku ?? get out !")
        sleep(1)
        exit()
    elif choice==1:
        print("You can't swim without crying , you lost , better luck next time")
        sleep(4)
        exit()


def spiritual_twin(char):
    printt("You reach a village and you see YOUR OWN spiritual twin !!")
    sleep(2)
    printt("He is mad and he wants you to fight him till death !")
    sleep(2)
    printt("What are you going to do ?")
    square=Square("Fight","Hug him","Run","Run too fast","Cry")
    square.display()
    choice = int(input("Enter your choice: "))
    if choice==1:
        if char.observation_haki==0:
            printt("You are weaker than your spiritual twin in all aspects , you can't kill him")
            sleep(2)
            printt("In order to win you need to see the future !!!")
            sleep(2)
            printt("Good luck next time")
            sleep(2)
            exit()
        else:
            printt("You see the future and you win the fight")
            sleep(2)
            printt("You are now the strongest in the village")
            sleep(2)
            printt("You lift your head up and you see a BLACK HOLE !!")
            sleep(2)
            print("It emits a strange energy and you start floating ......")
            sleep(3)
            blackhole(char) 
    elif choice==2:
        printt("I said he wanted to fight and you are hugging him ??? you are dead ")
        sleep(2)
        exit()
    elif choice==3 :
        printt("You are a coward , while running your heart stopped and you died !")
        sleep(2)
        exit()
    elif choice==4:
        printt("You run too fast and you reach the end of the world")
        sleep(2)
        printt("You fall in nothingness :O")
        sleep(2)
        exit()
    else :
        printt("Why are you scared , you are fighting your spiritual twin not a monster(ALGEBRA)")
        sleep(2)
        printt("You are dead anyways :/ ")
        sleep(2)
        exit()

def forest(char):
    printt("You keep following the feet traces and you reach a forest")
    sleep(2)
    printt("You find a kitten (TOO CUTEEE)")
    sleep(1)
    printt("What are you going to do ?")
    sleep(1)
    square=Square("Pet the kitten","Hit the kitten","Continue forward")
    square.display()
    choice = int(input("Enter your choice: "))
    while(choice!=3):
        while choice==2:
            if(char.stars==0):
                printt("The kitten turns into a tiger and eats you")
                sleep(2)
                exit()
            else:
                printt("The kitten rewinds time to avoid that  ( because she can )")
                sleep(2)
                char.stars=char.stars-1
                printt("You are now weaker")
                sleep(2)
                square=Square("Pet the kitten","Hit the kitten","Continue forward")
                square.display()
                choice = int(input("Enter your choice: "))
        while choice==1:
            printt("The kitten is happy and gives you a star")
            sleep(2)
            char.stars=char.stars+1
            if char.stars==6:
                char.armament_haki=1
            printt("You are now stronger")
            sleep(2)
            square=Square("Pet the kitten","Hit the kitten","Continue forward")
            square.display()
            choice = int(input("Enter your choice: "))
    
    printt("You continue forward")
    sleep(2)
    spiritual_twin(char)


def island(char,arg):
    if arg==0:
        printt("Welcome to the island!\nYour job here is to kill the final boss 'IMU' are you strong enough ???")
        sleep(2)
        printt("First of all can you give me your name ?")
        sleep(1)
        name = input("Name: ")
        char.name=name
        printt("Welcome to the island", name)
        sleep(1)
        printt("hmmm")
        sleep(1)
        printt("You love adventure right ???")
        sleep(1)
        printt("You look around you see a tight hole through two giant rocks and a path to the left which has human feet traces :O ")
        sleep(5)
    square=Square("Go through the hole","Follow the path","Just chill","Leave")
    square.display()
    choice = int(input("Enter your choice: "))
    if choice==3:
        printt("You drink coconut water and chill pheeewwwww....")
        sleep(2)
        printt("You are feeling lazy, STOP CHILLING AND GET UP !!! , am kidding you can sleep ")
        sleep(2)
        printt("You slept , and while sleeping a bear came and ate you, you are dead")
        exit()
    elif choice==2:
        printt("You follow the path")
        sleep(1)
        forest(char)
    elif choice==1:
        printt("You go through the hole")
        sleep(1)
        hole(char)
    elif choice==4:
        printt("You leave the island")
        sleep(1)
        exit()



char=character("")
try:
    island(char,0)
except:
    print("byebyeee")
    exit()
else:
    exit()