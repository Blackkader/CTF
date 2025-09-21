scrambled = "inecsuretS0yOu_dN{fu!tEO1_5t3c5lH}3__p"

mapping=[5, 6, 1, 2, 9, 3, 4, 7, 8, 0, 16, 11, 12, 13, 14, 19, 18, 10, 15, 17, 36, 21, 34, 26, 31, 20, 27, 28, 23, 33, 35, 25, 22, 37, 32, 24, 29, 30]

reconstructed = [''] * len(scrambled)
for i, idx in enumerate(mapping):
    reconstructed[idx] = scrambled[i]

reconstructed_str = ''.join(reconstructed)
print("Reconstructed:", reconstructed_str)
