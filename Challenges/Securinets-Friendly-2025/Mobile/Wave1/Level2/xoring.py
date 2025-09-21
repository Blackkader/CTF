# Obfuscate PNG bytes

key = 10

with open("fakeflag.png", "rb") as f:
    data = bytearray(f.read())

# XOR each byte with the key
for i in range(len(data)):
    data[i] ^= key

with open("woho.png", "wb") as f:
    f.write(data)
