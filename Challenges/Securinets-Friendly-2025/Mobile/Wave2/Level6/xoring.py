# Obfuscate PNG bytes
import hashlib

key=b"sha256"
hash=(hashlib.sha256(key).hexdigest())
print(hash)


with open("flag.png", "rb") as f:
    data = bytearray(f.read())

# XOR each byte with the key
for i in range(len(data)):
    data[i] ^= key[i % len(key)]

with open("woho.png", "wb") as f:
    f.write(data)
