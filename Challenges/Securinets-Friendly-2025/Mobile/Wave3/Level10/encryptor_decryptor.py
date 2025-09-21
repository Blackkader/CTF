# double_encrypt_same_tags.py
# Requires: pycryptodome
# pip install pycryptodome

import hashlib
import base64
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad, unpad
from typing import List

BLOCK = 16

def derive_key_from_tags(tags: List[str]) -> bytes:
    """
    Key derivation from tags:
    - sort tags
    - concatenate with '|' separators + trailing '|'
    - sha256
    - first 16 bytes = AES key
    """
    tags_sorted = sorted(tags)
    concat = "|".join(tags_sorted) + "|"
    return hashlib.sha256(concat.encode('utf-8')).digest()[:16]

def aes_ecb_encrypt(key16: bytes, plaintext: bytes) -> bytes:
    cipher = AES.new(key16, AES.MODE_ECB)
    return cipher.encrypt(pad(plaintext, BLOCK))

def aes_ecb_decrypt(key16: bytes, ciphertext: bytes) -> bytes:
    cipher = AES.new(key16, AES.MODE_ECB)
    return unpad(cipher.decrypt(ciphertext), BLOCK)

def double_encrypt(flag: str, tags: List[str]) -> str:
    """
    Double AES encryption using the SAME tags for both layers:
    AES1(tags, padded) -> AES2(tags, padded) -> Base64
    """
    flag_bytes = flag.encode('utf-8')

    # AES1 with padding
    key = derive_key_from_tags(tags)
    enc1 = aes_ecb_encrypt(key, flag_bytes)
    base64_first = base64.b64encode(enc1)  # Base64 string

    # AES2 with padding
    enc2 = aes_ecb_encrypt(key, base64_first)
    base64_second = base64.b64encode(enc2)

    return base64_second.decode('utf-8')


def double_decrypt(ciphertext_b64: str, tags: List[str]) -> str:
    """
    Reverse double_encrypt using the SAME tags for both layers
    Base64 -> AES2 decrypt (padded) -> AES1 decrypt (padded) -> flag string
    """
    key = derive_key_from_tags(tags)
    
    enc2 = base64.b64decode(ciphertext_b64)

    # AES2 decrypt
    dec2 = aes_ecb_decrypt(key, enc2)

    # AES1 decrypt
    enc1 = base64.b64decode(dec2)
    dec1 = aes_ecb_decrypt(key, enc1)
    return dec1.decode('utf-8')


if __name__ == "__main__":
    tags = [
        "TIP: hook the return value",
        "2131230877",
        "2131230878",
        "2131230879",
        "2131230880",
        "2131230881",
        "6",
        "7",
        "8",
        "9",
        "10",
        "io.securinets.level10",
        "io.securinets.level10.WinHelper",
    ]
    flag = "Securinets{yOU_jUsT_r0LLEd_THE_p3rF3cT_sCOrE}"
    print("[*] Flag:", flag)

    encrypted = double_encrypt(flag, tags)
    print("[+] Encrypted (base64):", encrypted)

    decrypted = double_decrypt(encrypted, tags)
    print("[+] Decrypted:", decrypted)
