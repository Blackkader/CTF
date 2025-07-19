**Challenge Name :** pyshell

### **Category :** Reverse Engineering

### **Description :**

> Can you unveil the secrets of this crazy malware (is it?) windows will help more here
> 
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'pyshell.py'_

---

### Solution
Ok let's take a look at the code :
```python
xxx="""WVZjeGQySXpTakJKU0U0eFdXNUNlV0l5VG14ak0wMU9RMjVDYUdOSFJuZFpXRUpvVUZOSmFVbG5NRXR(truncated)Zd2NBPT0="""
xxxx = f"import base64\nd={repr(xxx)}\nfor _ in range(3): d=base64.b64decode(d)\nexec(d)"
try :
    exec(xxxx)
except Exception as e:
    print(";(")
```
So we have a b64 python code  bein decoded 3 times then executed using **exec**.

Before anything , we execute it and something strange happens,  our mouse diappears , also our caps lock is turning on and off ??

let's just decode it 3 times and see the output : 

```python
import subprocess
papapapa="""
Add-Type -AssemblyName System.Windows.Forms
Add-Type @"
using System;
using System.Runtime.InteropServices;
public class Keyboard {
    [DllImport("user32.dll", EntryPoint = "keybd_event")]
    public static extern void KeybdEvent(byte bVk, byte bScan, uint dwFlags, UIntPtr dwExtraInfo);
    
    [DllImport("user32.dll")]
    public static extern short GetKeyState(int nVirtKey);
    
    public const int KEYEVENTF_EXTENDEDKEY = 0x0001;
    public const int KEYEVENTF_KEYUP = 0x0002;
}
"@

$pe5pe5 = [Keyboard]::GetKeyState(0x14)
if (($pe5pe5 -band 0x0001) -ne 0) {
    [Keyboard]::KeybdEvent(0x14, 0x45, [Keyboard]::KEYEVENTF_EXTENDEDKEY, [UIntPtr]::Zero)
    Start-Sleep -Milliseconds 50
    [Keyboard]::KeybdEvent(0x14, 0x45, [Keyboard]::KEYEVENTF_EXTENDEDKEY -bor [Keyboard]::KEYEVENTF_KEYUP, [UIntPtr]::Zero)
    Start-Sleep -Milliseconds 200 
}
$g7t = [System.Windows.Forms.Screen]::PrimaryScreen.Bounds
$k3p = [int]( $screen.Bottom +10000000)
$d1q = [int]($g7t.Width * 0.45)
$f4r = [int]($g7t.Width * 0.55)
$k3w = [int]($g7t.Width / 2)
$p7q = [int]( $screen.Bottom +10000000)
$x9v = 0
$m2z = 2
$m2r = 10  
$t5s = 0
for ($a8b = 0; $a8b -lt 360; $a8b += 40) {
    $j1n = [Math]::PI * $a8b / 180
    $x4v = [int]($k3w + $m2r * [Math]::Cos($j1n))
    $y6c = [int]($p7q + $m2r * [Math]::Sin($j1n))
    [System.Windows.Forms.Cursor]::Position = New-Object System.Drawing.Point($x4v, $y6c)
    Start-Sleep -Milliseconds $t5s
}
for ($c8s = $d1q; $c8s -le $f4r; $c8s += $m2z) {
    [System.Windows.Forms.Cursor]::Position = New-Object System.Drawing.Point($c8s, $k3p)
    Start-Sleep -Milliseconds $x9v
}
for ($c8s = $d1q; $c8s -le $f4r; $c8s += $m2z) {
    [System.Windows.Forms.Cursor]::Position = New-Object System.Drawing.Point($c8s, $k3p)
    Start-Sleep -Milliseconds $x9v
}
for ($a8b = 0; $a8b -lt 360; $a8b += 40) {
    $j1n = [Math]::PI * $a8b / 180
    $x4v = [int]($k3w + $m2r * [Math]::Cos($j1n))
    $y6c = [int]($p7q + $m2r * [Math]::Sin($j1n))
    [System.Windows.Forms.Cursor]::Position = New-Object System.Drawing.Point($x4v, $y6c)
    Start-Sleep -Milliseconds $t5s
}
(TRUNCATED AGAIN )
"""
subprocess.run(["powershell","-NoProfile","-ExecutionPolicy","Bypass", "-Command", papapapa])

```
That's a long powershell code ! Time to dig in :
So as we stated before , our mouse is being controlled as well as our caps lock , if we take a loog at the beginning of the powershell code we can notice this : 

```powershell
$k3p = [int]( $screen.Bottom +10000000)
$d1q = [int]($g7t.Width * 0.45)
$f4r = [int]($g7t.Width * 0.55)
$k3w = [int]($g7t.Width / 2)
$p7q = [int]( $screen.Bottom +10000000)

```

That's definitely the reason of our mouse's disappearance , let's patch that and make the mouse appear in our middle screen : 

```powershell

$k3p = [int]($g7t.Height / 2)
$d1q = [int]($g7t.Width * 0.45)
$f4r = [int]($g7t.Width * 0.55)
$k3w = [int]($g7t.Width / 2)
$p7q = [int]($g7t.Height / 2)
```

We execute again and , wow the mouse is moving at the speed of light , that's where our hint comes in hand xD slow down!!! , we should find the variables that control the speed of the mouse and change them to our liking ,
after doing that we can notice that the mouse is drawing very little circles and lines ?? what's the relation between the circles and lines , my bad that's not a meant to be a "circle" , the author is trying to draw a **DOT** (_a very little circle compared to your screen should look like a dot!_) cause he is showing us a morse code ! 

We can assume he is translating the flag characters to morse code , but how can we know where a morse code of a character stops ? that's when our caps lock comes in handy , (if you couldn't know that the caps lock is your stop sign , just know that the flag's first character is F and decode it to morse and u'll stop at the caps lock )

There are multiple ways to solve this :
* Using your eyes and your keyboard 
* Using your eyes and a pen xD
* String slicing with python script

and here is our morse code :

```python
..-. .-.. .---- - --.. .--. ----- .-- . .-. ... .... ...-- .-.. .-.. .-- --- --- .... ----- ----- -.-.--
```
Any online tool will help you decode it , i used this one :
[MorseToString](https://onlinestringtools.com/convert-morse-to-string)

And here is our flag :

```
FL1TZ{p0wersh3llwooh00!}
```

---