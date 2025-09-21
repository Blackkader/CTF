import base64

def rot6_char(c):
    if 'A' <= c <= 'Z':
        return chr((ord(c) - ord('A') + 20) % 26 + ord('A'))
    elif 'a' <= c <= 'z':
        return chr((ord(c) - ord('a') + 20) % 26 + ord('a'))
    elif '0' <= c <= '9':
        return chr((ord(c) - ord('0') + 20) % 10 + ord('0'))
    else:
        return c  # leave symbols as-is

def rot_6(text):
    return ''.join(rot6_char(c) for c in text)

# Original flag
flag = "Securinets{h0w_D1d_yoU_fInD_m3!!}"

# Apply ROT20
rot_flag = rot_20(flag)

# Encode in Base64
encoded_flag = base64.b64encode(rot_flag.encode("utf-8"))

# Save to file
with open("flag.dat", "wb") as f:
    f.write(encoded_flag)

print("Original flag: ", flag)
print("ROT20 flag: ", rot_flag)
print("Base64 encoded flag saved to flag.dat")
