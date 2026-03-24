# Tables
parity_drop = [
    57, 49, 41, 33, 25, 17, 9, 1,
    58, 50, 42, 34, 26, 18, 10, 2,
    59, 51, 43, 35, 27, 19, 11, 3,
    60, 52, 44, 36, 63, 55, 47, 39,
    31, 23, 15, 7, 62, 54, 46, 38,
    30, 22, 14, 6, 61, 53, 45, 37,
    29, 21, 13, 5, 28, 20, 12, 4 
]

shift_table = [
    1, 1, 2, 2, 2, 2, 2, 2,
    1, 2, 2, 2, 2, 2, 2, 1
]

compression_p_box = [
    14,17,11,24,1,5,3,28,
    15,6,21,10,23,19,12,4,
    26,8,16,7,27,20,13,2,
    41,52,31,37,47,55,30,40,
    51,45,33,48,44,49,39,56,
    34,53,46,42,50,36,29,32
]


# Conversion functions
def hex_to_bin(s):
    return bin(int(s, 16))[2:].zfill(64)

def bin_to_hex(s):
    return hex(int(s, 2))[2:].zfill(16)


# Permutation
def permute(data, table):
    result = ""   # FIX: remove space
    for i in table:
        result += data[i - 1]
    return result


# Left shift
def shift_left(data, n):
    return data[n:] + data[:n]


# Round key generation
def generate_round_keys(key_64bit):
    cipherkey = permute(key_64bit, parity_drop)  

    left, right = cipherkey[:28], cipherkey[28:]
    round_keys = []

    for i in range(16):
        left = shift_left(left, shift_table[i])  
        right = shift_left(right, shift_table[i])

        merged = left + right
        round_key = permute(merged, compression_p_box)

        round_keys.append(round_key)

    return round_keys


def des():
    key = input("Enter key in hex: ")
    key_64bit = hex_to_bin(key)

    round_keys = generate_round_keys(key_64bit)

    for i in range(len(round_keys)):
        print("Round Key", i + 1, "=", bin_to_hex(round_keys[i]))


def main():
    des()

if __name__ == "__main__":
    main()