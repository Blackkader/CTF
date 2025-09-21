import base64

# Example static permutation for shamble (must be same length as input)
# We'll generate it dynamically for any length
def get_static_permutation(length):
    # Simple deterministic permutation: swap even and odd positions
    perm = list(range(length))
    for i in range(0, length - 1, 2):
        perm[i], perm[i + 1] = perm[i + 1], perm[i]
    return perm

def apply_permutation(data, perm):
    return bytes([data[i] for i in perm])

def inverse_permutation(perm):
    inv = [0] * len(perm)
    for i, p in enumerate(perm):
        inv[p] = i
    return inv

def rot13_bytes(data):
    result = bytearray()
    for b in data:
        c = chr(b)
        if 'a' <= c <= 'z':
            result.append((ord(c) - ord('a') + 13) % 26 + ord('a'))
        elif 'A' <= c <= 'Z':
            result.append((ord(c) - ord('A') + 13) % 26 + ord('A'))
        else:
            result.append(b)
    return bytes(result)

def unrot13_bytes(data):
    result = bytearray()
    for b in data:
        c = chr(b)
        if 'a' <= c <= 'z':
            result.append((ord(c) - ord('a') - 13) % 26 + ord('a'))
        elif 'A' <= c <= 'Z':
            result.append((ord(c) - ord('A') - 13) % 26 + ord('A'))
        else:
            result.append(b)
    return bytes(result)

def encrypt(plaintext, key, rounds=4):
    data = plaintext.encode('utf-8')
    key_bytes = key.encode('utf-8')

    for r in range(rounds):
        # XOR
        xor_bytes = bytes([b ^ key_bytes[i % len(key_bytes)] for i, b in enumerate(data)])
        # ROT13
        rot_bytes = rot13_bytes(xor_bytes)
        # Shuffle in 2nd and 4th rounds
        if r == 1 or r == 3:
            perm = get_static_permutation(len(rot_bytes))
            rot_bytes = apply_permutation(rot_bytes, perm)
        # Base64
        data = base64.b64encode(rot_bytes)

    return data.decode('utf-8')

def decrypt(ciphertext, key, rounds=4):
    data = ciphertext.encode('utf-8')
    key_bytes = key.encode('utf-8')

    for r in reversed(range(rounds)):
        # Base64 decode
        rot_bytes = base64.b64decode(data)
        # Unshuffle in 2nd and 4th rounds
        if r == 1 or r == 3:
            perm = get_static_permutation(len(rot_bytes))
            inv_perm = inverse_permutation(perm)
            rot_bytes = apply_permutation(rot_bytes, inv_perm)
        # Reverse ROT13
        xor_bytes = unrot13_bytes(rot_bytes)
        # XOR with key
        data = bytes([b ^ key_bytes[i % len(key_bytes)] for i, b in enumerate(xor_bytes)])

    return data.decode('utf-8')


# --- Example usage ---
PASS="AAAAAAAAAAAAAAAA"
plaintext="Securinets{AwWw_1ts_A_c4t!!_a_L0GCAT!!!}"
key = "SuperSecretKey123"

encrypted = encrypt(plaintext, key)
print("Encrypted:", encrypted)

decrypted = decrypt(encrypted, key)
print("Decrypted:", decrypted)
