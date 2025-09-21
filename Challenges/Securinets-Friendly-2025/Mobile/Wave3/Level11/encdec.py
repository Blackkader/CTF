#!/usr/bin/env python3
"""
encdec_fixed.py

Deterministic reversible pipeline:
  encrypt_part(plaintext, part_index) -> obfuscated bytes
  decrypt_part(ciphertext, part_index) -> plaintext

Deterministic permutation generator (per-length, per-part_index) based on
SHA-256(passphrase || salt || part_index || counter) so it's reproducible
and invertible for any input length (no true randomness).
"""

import hashlib
from textwrap import wrap

# ===== Constants (must match Java) =====
PASSPHRASE = "superidol"
SALT = "silksongisreal"

# ===== Utility: deterministic pseudorandom stream (SHA256-based) =====
def sha256_stream(part_index):
    """
    Yield successive 32-byte blocks deterministically based on PASSPHRASE, SALT and part_index.
    """
    counter = 0
    while True:
        m = hashlib.sha256()
        m.update(PASSPHRASE.encode("utf-8"))
        m.update(b"\xFF")
        m.update(SALT.encode("utf-8"))
        m.update(bytes([part_index & 0xFF]))
        m.update(counter.to_bytes(4, "big"))
        yield m.digest()
        counter += 1

# ===== Deterministic permutation generator (Fisher-Yates using SHA-256 stream) =====
def gen_perm(n, part_index):
    """
    Generate a deterministic permutation of [0..n-1] for the given part_index.
    Uses a SHA-256 based stream to produce pseudorandom values (fully deterministic).
    """
    if n <= 1:
        return list(range(n))
    perm = list(range(n))
    stream = sha256_stream(part_index)
    # We'll pull 4 bytes at a time to build a 32-bit integer for each step.
    # This is deterministic and repeatable.
    for i in range(n - 1, 0, -1):
        # get a 32-bit integer from stream
        block = b""
        while len(block) < 4:
            block += next(stream)
        r = int.from_bytes(block[:4], "big")
        j = r % (i + 1)
        perm[i], perm[j] = perm[j], perm[i]
    return perm

# ===== Permutation application / inverse =====
def apply_permutation(data: bytes, part_index: int) -> (bytearray, list):
    n = len(data)
    perm = gen_perm(n, part_index)
    out = bytearray(n)
    for i in range(n):
        out[perm[i]] = data[i]
    return out, perm

def inverse_permutation(data: bytes, perm: list) -> bytearray:
    n = len(data)
    out = bytearray(n)
    for i in range(n):
        out[i] = data[perm[i]]
    return out

# ===== Byte-pair mixing (forward) and unmix (reverse) =====
def bytepair_mix_forward(data: bytes) -> bytearray:
    out = bytearray(data)
    for i in range(1, len(out)):
        out[i] = (out[i] + out[i - 1]) & 0xFF
    return out

def bytepair_unmix_reverse(data: bytes) -> bytearray:
    out = bytearray(data)
    for i in range(len(out) - 1, 0, -1):
        out[i] = (out[i] - out[i - 1]) & 0xFF
    return out

# ===== Keystream (SHA-256 blocks) =====
def keystream(length: int, part_index: int) -> bytes:
    out = bytearray()
    counter = 0
    while len(out) < length:
        m = hashlib.sha256()
        m.update(PASSPHRASE.encode("utf-8"))
        m.update(b"\xFF")
        m.update(SALT.encode("utf-8"))
        m.update(bytes([part_index & 0xFF]))
        m.update(counter.to_bytes(4, "big"))
        out.extend(m.digest())
        counter += 1
    return bytes(out[:length])

# ===== Encrypt / Decrypt functions (public) =====
def encrypt_part(plaintext: str, part_index: int) -> bytes:
    raw = plaintext.encode("utf-8")
    # 1) deterministic permutation (and capture perm to embed later if you want)
    permuted, perm = apply_permutation(raw, part_index)
    # 2) byte-pair mixing
    mixed = bytepair_mix_forward(permuted)
    # 3) XOR with keystream
    ks = keystream(len(mixed), part_index)
    final = bytes([b ^ k for b, k in zip(mixed, ks)])
    return final

def decrypt_part(ciphertext: bytes, part_index: int) -> str:
    # 1) XOR with same keystream
    ks = keystream(len(ciphertext), part_index)
    step1 = bytes([c ^ k for c, k in zip(ciphertext, ks)])
    # 2) undo byte-pair mixing (reverse)
    step2 = bytepair_unmix_reverse(step1)
    # 3) inverse permutation: recompute the perm and undo it
    perm = gen_perm(len(step2), part_index)
    step3 = inverse_permutation(step2, perm)
    return step3.decode("utf-8")

# ===== Helper: format Java byte array initializer =====
def format_java_array(bdata: bytes, name="P", idx=1):
    # Format as private static final byte[] P{idx} = new byte[] { (byte)0x.., ... };
    hex_items = ["(byte)0x{:02X},".format(x) for x in bdata]
    perline = 12
    lines = []
    for i in range(0, len(hex_items), perline):
        lines.append("        " + " ".join(hex_items[i:i+perline]))
    body = "\n".join(lines)
    return "private static final byte[] {}{} = new byte[] {{\n{}\n    }};".format(name, idx, body)

# ===== Self-test & demo =====
if __name__ == "__main__":
    parts = ["Securinets", "{yOu_f0uNd", "_tH3_lO5t_p13cE5!}"]
    print("=== Encrypt + Decrypt test (deterministic) ===\n")
    for idx, p in enumerate(parts, start=1):
        enc = encrypt_part(p, idx)
        dec = decrypt_part(enc, idx)
        print("Part {}:".format(idx))
        print("  Plain :", p)
        print("  Encrypted bytes:", enc)
        print("  Decrypted back :", dec)
        print()
        # print Java ready array
        print(format_java_array(enc, name="P", idx=idx))
        print()

    # quick assert round-trip
    for idx, p in enumerate(parts, start=1):
        enc = encrypt_part(p, idx)
        dec = decrypt_part(enc, idx)
        assert dec == p, "round-trip failed for part {}: got {!r}".format(idx, dec)

    print("All parts round-trip OK.")
