def prepare_key_matrix(keyword):
    keyword = keyword.upper().replace("J","I").replace(" ","")
    key = ""
    for c in keyword:
        if c not in key:
            key += c
    for c in "ABCDEFGHIKLMNOPQRSTUVWXYZ":
        if c not in key:
            key += c
    matrix = [list(key[i:i+5]) for i in range(0,25,5)]
    return matrix

def prepare_plain_text(text):
    text = text.upper().replace("J","I").replace(" ","")
    p = ""
    i = 0
    while i < len(text):
        a = text[i]
        b = ""
        if i+1 < len(text):
            b = text[i+1]
            if a == b:
                b = "X"
                i += 1
            else:
                i += 2
        else:
            b = "X"
            i += 1
        p += a + b
    return p

def find_position(c, matrix):
    for i,row in enumerate(matrix):
        for j,ch in enumerate(row):
            if ch == c:
                return i,j

def playfair_encrypt(text, matrix):
    cipher = ""
    for i in range(0,len(text),2):
        a,b = text[i], text[i+1]
        r1,c1 = find_position(a,matrix)
        r2,c2 = find_position(b,matrix)
        if r1 == r2:
            cipher += matrix[r1][(c1+1)%5] + matrix[r2][(c2+1)%5]
        elif c1 == c2:
            cipher += matrix[(r1+1)%5][c1] + matrix[(r2+1)%5][c2]
        else:
            cipher += matrix[r1][c2] + matrix[r2][c1]
    return cipher

def playfair_decrypt(text, matrix):
    plain = ""
    for i in range(0,len(text),2):
        a,b = text[i], text[i+1]
        r1,c1 = find_position(a,matrix)
        r2,c2 = find_position(b,matrix)
        if r1 == r2:
            plain += matrix[r1][(c1-1)%5] + matrix[r2][(c2-1)%5]
        elif c1 == c2:
            plain += matrix[(r1-1)%5][c1] + matrix[(r2-1)%5][c2]
        else:
            plain += matrix[r1][c2] + matrix[r2][c1]
    return plain


keyword = "monar  c hy "
text = "he ll  o"

matrix = prepare_key_matrix(keyword)
plain = prepare_plain_text(text)
cipher = playfair_encrypt(plain,matrix)
decrypted = playfair_decrypt(cipher,matrix)

print("Key Matrix:")
for row in matrix:
    print(row)
print("Prepared Text:", plain)
print("Cipher Text:", cipher)
print("Decrypted Text:", decrypted)