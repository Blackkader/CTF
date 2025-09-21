from Crypto.Cipher import DES

def rot13(text: str) -> str:
    result = []
    for c in text:
        if 'a' <= c <= 'z':
            result.append(chr((ord(c) - ord('a') + 13) % 26 + ord('a')))
        elif 'A' <= c <= 'Z':
            result.append(chr((ord(c) - ord('A') + 13) % 26 + ord('A')))
        else:
            result.append(c)
    return ''.join(result)
def des_decrypt(ciphertext: bytes, key: bytes) -> bytes:
    key = key.ljust(8, b'X')[:8]
    cipher = DES.new(key, DES.MODE_ECB)
    decrypted = cipher.decrypt(ciphertext)
    return decrypted.rstrip(b'\0')

def decrypt_flag_bytes(encrypted_bytes: bytes) -> str:
    key3 = "Securinets{test}"[2:6].encode('utf-8')
    layer3 = des_decrypt(encrypted_bytes, key3)
    key2 = "Securinets{test}"[6:10].encode('utf-8')
    layer2 = des_decrypt(layer3, key2)
    key1 = "Securinets{test}"[:8].encode('utf-8')
    layer1_bytes = des_decrypt(layer2, key1)
    layer1_str = layer1_bytes.decode('utf-8', errors='ignore')
    return rot13(layer1_str)



with open("output.dat", "rb") as f:
    encrypted = f.read()
decrypted = decrypt_flag_bytes(encrypted)
print(f"Decrypted: {decrypted}")