def encrypt_password(login, password):
    encrypted = []
    login_bytes = [ord(c) for c in login]

    for i, c in enumerate(password):
        xor_char = ord(c) ^ login_bytes[i % len(login_bytes)]
        rot_char = ((xor_char << 3) & 0xFF) | (xor_char >> 5)  # rotate left 3
        encrypted.append(rot_char)
    return encrypted

def decrypt_password(login, encrypted):
    login_bytes = [ord(c) for c in login]
    decrypted = ""

    for i, val in enumerate(encrypted):
        
        xor_char = ((val & 0xFF) >> 3) | ((val << 5) & 0xFF)
        original_char = xor_char ^ login_bytes[i % len(login_bytes)]
        decrypted += chr(original_char)
    return decrypted

login = "logedin"
password = "GRANDMASTER!"
enc = encrypt_password(login, password)
print("Encrypted:", enc)

secrets = [89, 233, 49, 89, 1, 33, 121, 249, 217, 17, 185, 42]
dec = decrypt_password(login, secrets)
print("Decrypted pass :", dec)
