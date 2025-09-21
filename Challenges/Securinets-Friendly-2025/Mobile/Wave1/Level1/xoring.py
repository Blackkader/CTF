# Obfuscate PNG bytes
ch="MASTER!"
key = [ord(c) for c in ch]
print(key)
sum=0
for i in range(len(key)):
    sum+=key[i]
key=sum-444

with open("flag.png", "rb") as f:
    data = bytearray(f.read())

# XOR each byte with the key
for i in range(len(data)):
    data[i] ^= key

with open("woho.png", "wb") as f:
    f.write(data)
