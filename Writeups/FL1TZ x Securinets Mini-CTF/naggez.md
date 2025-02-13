**Challenge Name :** naggez

### **Category :** Reverse Engineering

### **Description :**

> can you jump long enough ????? the flag is shiny !
>
> 𝐀𝐮𝐭𝐡𝐨𝐫 : 𝐁𝐥𝐚𝐜𝐤𝐤𝐚𝐝𝐞𝐫

### **Files Given :** _'naggez.zip'_

---

### Solution

Let's extract the zip using the **unzip command** :

<img src="https://private-user-images.githubusercontent.com/144800528/413027314-c4bf0086-2904-4c88-9dc9-d957512b4b7a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzE0LWM0YmYwMDg2LTI5MDQtNGM4OC05ZGM5LWQ5NTc1MTJiNGI3YS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT04ZTQzZGNhYzA0ZTdiNTNjZmI5MjMzNTc1OWQ5MDI0Y2Y2MDgxOGIyMTBiNzdjMDYyZGU1M2JiOTZhYjZiODcwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.5x9lCor5YulMH6paWu6ciVlVIJmIf9AOHJSzU0d4s-Y" title="" alt="" data-align="center">

Oh a version for **Linux** and another for **Windows** 

I'll be using the linux one ig , let's start with our file command :

![](https://private-user-images.githubusercontent.com/144800528/413027337-14de5f6c-9a63-4627-bf3b-48eb20cec66f.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzM3LTE0ZGU1ZjZjLTlhNjMtNDYyNy1iZjNiLTQ4ZWIyMGNlYzY2Zi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1kMWY2NmY3MWE4MTNmMWU5NTc0NmZhNmZiMDZkZmY1YTZhMTE0YzFjMDBkOWI5ZWJhZmM5NjMxMTRjNTZmMWFiJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9._i2nyNmjt1Qt80GzADBHLCk-UvlbdTtPeksHrCsoPZA)

Let's launch our executable then : 

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027303-867d3352-c3cc-4cc1-bdc6-667b340eee6d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzAzLTg2N2QzMzUyLWMzY2MtNGNjMS1iZGM2LTY2N2IzNDBlZWU2ZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yYTk2NTIxYTliNzA0NzEyMjcwMWFhNGFhMzBmNGExZTQ0MDI5Y2U0NDY0ZTdlZDM0NGI5N2JjMjY0MWJhODQ0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.PRfdJc4gJdZE_HP0e6hecUQoC3zw8uac2vv0WisbCsI" alt="" width="547" data-align="center">

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027321-6581f563-76f3-4ef8-9cb2-bf5378b6b486.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzIxLTY1ODFmNTYzLTc2ZjMtNGVmOC05Y2IyLWJmNTM3OGI2YjQ4Ni5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT04MTIzZWJhNjc1ZDE1YTFmZWMzNDgxY2Y1ZDQ4M2M3Zjk2ZDYyYjMyODNhZWM0ZTdiNDk0MGUzNWQ3NWE2YzQwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.7DvS8apfStQLXbAfa3qbeuSUyjfBC2CN0Avl_TsXbTU" alt="" width="551" data-align="center">

Oh what is that xDD , we got **GODOT game engine** ? , well it's self explanatory , this is a game and it was made with the game engine [**GODOT**](https://godotengine.org/)

What we can first observe are flags scattered around , and i guess the flag characters randomized around the screen too ! 

I can't jump enough come on !  , also when playing on full screen i could see more of the platform 

<img src="https://private-user-images.githubusercontent.com/144800528/413027310-232ee983-8708-497d-86cd-d1f883c4342c.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzEwLTIzMmVlOTgzLTg3MDgtNDk3ZC04NmNkLWQxZjg4M2M0MzQyYy5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iZTYxZDliNmYxMmJiMzUwMWU2ZWFkYWM2NTllZWE0ODI3MTQyZjdhYjY0ZmRmZTBiZWI4M2MyMGE4YjAzOGJmJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.Rb3yG0ZuaOjdkb6Y5qsJ4j6dWR6KxT6HS0Zjos8aVQk" title="" alt="" width="627">

Let's try reaching the flag on right :

<img src="https://private-user-images.githubusercontent.com/144800528/413027312-9279f8c3-648a-49c7-b815-a17ccfadfdfd.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzEyLTkyNzlmOGMzLTY0OGEtNDljNy1iODE1LWExN2NjZmFkZmRmZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03NzZiMzA5NTVlOTBhMTBkOGYzZjc3OGY2NDFlNDhmNTRmMjU0MjczNTc2YWJlYTU1YmQzYjU4NGM0YTAzNWYwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.eghp3XLqJcQ_Q0O31N5j5rW-BhO-xEIRyiDdipTEo2U" title="" alt="" width="626">

Oh ! the characters moved around the screen , we can assume that the author wants us to jump to that suspicious flag covered with emojis xD as he stated in the description **" can you jump long enough ????? the flag is shiny ! "**

Time to reverse engineer then .. , How can we get the files used to create a godot game ?? a little research will get us to this tool : [Gdre_Tools](https://github.com/GDRETools/gdsdecomp)

Which helps us decompile the game, let's  give it a try : 

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027319-2de43f1e-a25f-4a58-8afe-52fa2e10321b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzE5LTJkZTQzZjFlLWEyNWYtNGE1OC04YWZlLTUyZmEyZTEwMzIxYi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0yOTk3YjZkOTQ4YmNmN2NiYzZiMDQ5NzZjZjEyMWVmOGFkN2E0MDgwNTVlMDMxY2VmYzA3MjM3M2Y4OWFhMDg5JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.j1dLQlq7ZHPlDhLHNEzb5njGgeWOmyBZd8X0QjPDQWc" alt="" width="521" data-align="center">

Let's try recover project ? We choose our file and the extract location and we successfully get our project back : 

![](https://private-user-images.githubusercontent.com/144800528/413027332-198fff15-8374-409b-bd3d-6772bd771b2b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzMyLTE5OGZmZjE1LTgzNzQtNDA5Yi1iZDNkLTY3NzJiZDc3MWIyYi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iOWJjN2Y2YzdjZDJjYTRlZWE2MDFiYTgyZTRiMzM3YmNhOWZhN2FiNTc5NGNlN2QwNmU2MTUyNDc5ODNkYzViJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.mc-0r1Wpw6NUINzcdM6bOvQcq6FEBLgyI6WixQtj-C0)

Now how can we open the project files  ??? as we can see the _Recovery Report_ , it says **Use Godot editor version 4.2.1 to edit this project** , time to install that and import our project :

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027315-d463037f-90cc-4cbe-8e6a-7663cd12c58e.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzE1LWQ0NjMwMzdmLTkwY2MtNGNiZS04ZTZhLTc2NjNjZDEyYzU4ZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT05NWU3OGNlZTUxM2MxNDQ1YWNkY2FlMGQzNzA4MTEyNmE4OGViOGQyMDkzMGVmNWM4NmFhOGI1ZjIyN2ViNmZkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.CkTFJp7zqUrIWHD7Vd64RhexVna67zdO1iaimn8QYpA" alt="" width="536" data-align="center">

And there we go ,  we got our project back : 

<img title="" src="https://private-user-images.githubusercontent.com/144800528/413027316-cc919472-4b8f-4a7f-a7f5-94f83c5d7f2b.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzE2LWNjOTE5NDcyLTRiOGYtNGE3Zi1hN2Y1LTk0ZjgzYzVkN2YyYi5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01MGEzMmYyOTFmNDNlYzNhNzAzYTVjOTdkNzI4NjQ1N2YyYzkwNDJhYWUxNjFiZmQyNGU3Y2U1MmI4ZjY2NjkzJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.XWmO-mPyzSSStURXLpmAe1WOt8aWzYGtztpXoXqqxOg" alt="" width="599" data-align="center">

We are interested in reverse engineering right ? While analyzing the scripts out there we find out that the most interesting script among them is **arena.tscn**

```python
extends Node2D

var flag_objects
# Called when the node enters the scene tree for the first time.
func _ready():
    flag_objects = get_children().filter(func(child): return child.name.match("Flag_*"))


func convert_hex_to_int(hex_val):
    if hex_val >= 0x30 && hex_val <= 0x39:
        return hex_val - 0x30
    else:
        return hex_val - 0x37

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
    var flag_states = []
    for flag in flag_objects:
        flag_states.append(int(flag.target_state))
    var concatenated_flags = "".join(flag_states)
    var character_nodes = %FlagText.get_children()
    var transformation_values = [0x10e, -0x32, 0xaa, -0x46, -0xfa, -0x10e, 0x46, 0xfa, -0x1e, -0x6e, 0xd2, 0xbe, 0x6e, -0x5a, 0x96, 0x1e, -0xbe, -0x96, 0xe6, -0x122, 0x32, 0x82, -0xd2, -0xa, -0x82, -0xe6, 0x5a, -0xaa, 0xa]
    #1111011111 

    if (concatenated_flags != "1111011111"):
        var hash_value = concatenated_flags.sha1_text().to_upper()
        hash_value += concatenated_flags.md5_text().to_upper()
        character_nodes[0].target_y = 0
        character_nodes[1].target_x = 1
        for i in character_nodes.size():
            character_nodes[i].target_x = convert_hex_to_int(hash_value.unicode_at(i * 2)) - 8
            character_nodes[i].target_y = convert_hex_to_int(hash_value.unicode_at((i * 2) + 1)) - 8
    else:
        var hash_value = concatenated_flags.sha1_text().to_upper()
        hash_value += concatenated_flags.md5_text().to_upper()
        for i in character_nodes.size():
            character_nodes[i].target_x = transformation_values[i]
            character_nodes[i].target_y = convert_hex_to_int(hash_value.unicode_at((i * 2) + 1)) - 8
        var unused_variable
        for loop_x in range(-290, 290, 20):
            var loop_index = 0
            for character_node in character_nodes:
                if character_node.target_x == loop_x:
                    if character_node.text != "XXX":
                        print("_\nb" if character_node.text == "b" else character_node.text)
```

func process is handling flag states ? that's what we want ! 

We can see that this part of code :

```python
var flag_states = []
    for flag in flag_objects:
        flag_states.append(int(flag.target_state))
    var concatenated_flags = "".join(flag_states)
    var character_nodes = %FlagText.get_children()
    var transformation_values = [0x10e, -0x32, 0xaa, -0x46, -0xfa, -0x10e, 0x46, 0xfa, -0x1e, -0x6e, 0xd2, 0xbe, 0x6e, -0x5a, 0x96, 0x1e, -0xbe, -0x96, 0xe6, -0x122, 0x32, 0x82, -0xd2, -0xa, -0x82, -0xe6, 0x5a, -0xaa, 0xa]
    #1111011111 
```

is actually storing the flag states in a variable called **concatenated_flags** 

and in the if statement there is something interesting : 

```python
if (concatenated_flags != "1111011111"):
```

we can assume that **1** and **0** represent whether the flag was touched or no , but how do we know if **1** corresponds to yes or no ??  we can find our answer in **flag.tscn** :

```python
extends StaticBody2D
class_name Flag

const TRANSITION_TICKS = 100
var target_state = true
var is_transitioning = false
@export var current_state = 1.0
```

when loaded , initial value is **1** = not touched yet 

How do we know if flags are in order ? that's in the ready func :

```python
func _ready():
    flag_objects = get_children().filter(func(child): return child.name.match("Flag_*"))
```

**match("Flag_*"))** we can assume that flag names will be : Flag_0 / Flag_1 etc...

We need to confirm that , and that's by checking the scene section in the upper left corner : 

![](https://private-user-images.githubusercontent.com/144800528/413027338-a952c9e8-7a3a-4762-89c1-09296f337d11.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzM4LWE5NTJjOWU4LTdhM2EtNDc2Mi04OWMxLTA5Mjk2ZjMzN2QxMS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01M2JmNTgxNWE4ZmNiZThiZmNjMjRiNzBmYWFiNDNkOTkyMTU4NThlNzQ4YzI0Zjk2ZWY3MGU4ZjRkZmFkMGM0JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.JjxGnN3CZYX2IFmvIfoI-mfnJjRo46eZz6sQceX4Tv4)

Yes ! they are in order 

Then we can totally say  that we have to touch the 5th flag (position of 0 in the string) But which flag is that ? is it the shiny one that's surrounded with emojis ?

Let's select the 5th flag while we open the arena in 2d , so it shows us which object we are currently selecting : 

![](https://private-user-images.githubusercontent.com/144800528/413027327-5bf4b293-e0ff-4dfb-bb88-7498f1b780e8.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzI3LTViZjRiMjkzLWUwZmYtNGRmYi1iYjg4LTc0OThmMWI3ODBlOC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1mMzNhZTc5NmUzYjgzODM4MmE3NGViYjA1MjBhZTNlNDhlZWY2YzAwM2M3YWI4ZDdiMmRhYWEzNTBiNGJmZWJkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.m809ORnUQ7KrTYozgCiwleOo91JP3kYI4vH8S0d2-tA)

It's not there ? maybe it is , but it's  TOO FARR ! , we can see the that the flag's position is actually **(-245,500000)** !!!

Let's bring it closer to us ! We change the **Y**'s value to something smaller like **50**

Then the flag will appear in the screen and we grab it and put it closer to us , so when we spawn we get it easily like this :

<img src="https://private-user-images.githubusercontent.com/144800528/413027346-992f828b-7f07-4e70-80ca-caff5467281a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQ2LTk5MmY4MjhiLTdmMDctNGU3MC04MGNhLWNhZmY1NDY3MjgxYS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0wNmQ0YTNmOWMxMzIzYjVmMDA0OTdkMmFiOWJjYmFlNjVkNGNiMjhmOTEzYWVjZTVhYjY5ZTJjN2NhMTBhZmZjJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.LtxRsFpHtgjruJRffrr0gKjYBD3Giu9W2cEKH_nSfMc" title="" alt="" data-align="center">

Time to launch our modified game now ! and see what happens :

![](https://private-user-images.githubusercontent.com/144800528/413027342-6ca64607-de1b-4800-b962-36cd738c8abe.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3Mzk0NzQxOTAsIm5iZiI6MTczOTQ3Mzg5MCwicGF0aCI6Ii8xNDQ4MDA1MjgvNDEzMDI3MzQyLTZjYTY0NjA3LWRlMWItNDgwMC1iOTYyLTM2Y2Q3MzhjOGFiZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwMjEzJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDIxM1QxOTExMzBaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03ZTlmMWNlZTllOTY0ZDk0NjkyMjE2NGRiYTQ2Mjk1NzQ3NGJlOTAwYTk3ZDU5YzM4YTM3OTQ3NDk4YWZjNmI4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.khxpf67tA3vaw1bLokEKGKGVbJAvs6_TAOwaNjz3GCM)

Damn , we can see characters are being printed in the log down there : 

And they are the flag :

```
FL1TZ{g0dOt_IS_not_th4t_b4d!}
```

There are many other ways to solve this , for example we take what's happening in the else statement and copy it , inside the proc function , so when we start the game , the flag appears in the log 

Another way is just a python script imitating the else statement as well ! 

---

