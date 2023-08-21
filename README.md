# ClassicalCryptography

Java project implementing various classical ciphers.

<h3>Substitution</h3>
<h4>Caesar</h4>
https://en.wikipedia.org/wiki/Caesar_cipher

It is a type of substitution cipher in which each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet.

<h4>Example:</h4>

<b>Plaintext:</b>  THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG

<b>Ciphertext:</b> QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD

<h4>ROT13</h4>
https://en.wikipedia.org/wiki/ROT13

Replaces a letter with the 13th letter after it in the latin alphabet. 
Because there are 26 letters (2×13) in the basic Latin alphabet, ROT13 is its own inverse; that is, to undo ROT13, the same algorithm is applied, so the same action can be used for encoding and decoding. 

<h4>Example:</h4>

<b>Plaintext:</b> Why did the chicken cross the road?

<b>Ciphertext:</b> Jul qvq gur puvpxra pebff gur ebnq?

<h4>Autokey</h4>
https://en.wikipedia.org/wiki/Autokey_cipher

Cipher that incorporates the message (the plaintext) into the key. The key is generated from the message in some automated fashion, sometimes by selecting certain letters from the text or, more commonly, by adding a short primer key to the front of the message.

<h4>Example:</h4>

<b>Plaintext:</b> attackatdawn

<b>Key:</b> QUEENLYATTACKATDAWN

<b>Ciphertext:</b> QNXEPVYTWTWP

<h4>Hill</h4>
https://en.wikipedia.org/wiki/Hill_cipher

Hill cipher is a polygraphic substitution cipher based on linear algebra. Invented by Lester S. Hill in 1929, it was the first polygraphic cipher in which it was practical (though barely) to operate on more than three symbols at once.

<b>Plaintext:</b> ATK

<b>Key:</b> <br>
6, 24, 1 <br>
13, 16, 10 <br>
20, 17, 15

<b>Ciphertext:</b> POH

<h3>Transposition</h3>
<h4>Columnar</h4>
https://en.wikipedia.org/wiki/Transposition_cipher#Columnar_transposition

In a columnar transposition, the message is written out in rows of a fixed length, and then read out again column by column, and the columns are chosen in some scrambled order.

<b>Plaintext: </b>WE ARE DISCOVERED
<br>
<b>Key: </b>ZEBRAS
<br>
<b>Encryption matrix:</b>
<br>
W E A R E D<br>
I S C O V E <br>
R E D F L E <br>
E A T O N C <br>
E Q K J E U <br>
<b>Ciphertext:</b><br>
EVLNE ACDTK ESEAQ ROFOJ DEECU WIREE
<br>
<br>
<h4>Rail fence</h4>
https://en.wikipedia.org/wiki/Rail_fence_cipher

In the rail fence cipher, the plaintext is written downwards diagonally on successive "rails" of an imaginary fence, then moving up when the bottom rail is reached, down again when the top rail is reached, and so on until the whole plaintext is written out.

<b>Plaintext: </b>WE ARE DISCOVERED
<br>
<b>Encryption matrix ('fence'):</b>
<br>
W . . . E . . . C . . . R . . . U . . . O . . . <br>
. E . R . D . S . O . E . E . R . N . T . N . E <br>
. . A . . . I . . . V . . . D . . . A . . . C . <br>
<b>Ciphertext:</b><br>
WECRUO ERDSOEERNTNE AIVDAC

<h3>Square</h3>
<h4>Playfair</h4>
https://en.wikipedia.org/wiki/Playfair_cipher

The technique encrypts pairs of letters (bigrams or digrams), instead of single letters.
Key is a matrix containing letters.
For encryption if letters form square then pick letters from opposite corners. If letters form column pick letter below each letter, wrap to top if needed. If letters rowm row select letters right to each letter, wrap to left if needed.

Decryption is similar, with difference that for letters forming column one should select letters above, and for letters forming row letters to the left.

<b>Plaintext: </b>hide the gold in the tree stump
<br>
<b>Encryption matrix:</b>
<br>
P L A Y F<br>
I R E X M<br>
B C D G H<br>
K N O Q S<br>
T U V W Z<br>

<b>Ciphertext:</b><br>
BM OD ZB XD NA BE KU DM UI XM MO UV IF

<h4>Two-Square</h4>
https://en.wikipedia.org/wiki/Two-square_cipher

The Two-square cipher, also called double Playfair, is a manual symmetric encryption technique.
The technique encrypts pairs of letters.
The two-square cipher uses two 5x5 matrices and comes in two varieties, horizontal and vertical.

<b>Plaintext: </b>he lp me ob iw an ke no bi
<br>
<b>Encryption matrix:</b>
<br>
E X A M P<br>
L B C D F<br>
G H I J K<br>
N O R S T<br>
U V W Y Z<br>
 <br><br>
K E Y W O<br>
R D A B C<br>
F G H I J<br>
L M N P S<br>
T U V X Z<br>
<br>
<b>Ciphertext:</b><br>
HE DL XW SD JY AN HO TK DG

<h4>Four-square</h4>
https://en.wikipedia.org/wiki/Four-square_cipher

The four-square cipher is a manual symmetric encryption technique.
The technique encrypts pairs of letters (digraphs).
The four-square cipher uses four 5 by 5 (5x5) matrices arranged in a square. Each of the 5 by 5 matrices contains the letters of the alphabet (usually omitting "Q" or putting both "I" and "J" in the same location to reduce the alphabet to fit).

<b>Plaintext: </b>he lp me ob iw an ke no bi
<br>
<b>Encryption matrix:</b>
<br>
a b c d e   E X A M P<br>
f g h i j   L B C D F<br>
k l m n o   G H I J K<br>
p r s t u   N O R S T<br>
v w x y z   U V W Y Z<br>
 
K E Y W O   a b c d e<br>
R D A B C   f g h i j<br>
F G H I J   k l m n o<br>
L M N P S   p r s t u<br>
T U V X Z   v w x y z<br>
<br>
<b>Ciphertext:</b><br>
FY GM KY HO BX MF KK KI MD

<h3>Used technologies:</h3>

- java (openjdk-20),
- junit5,
- IntelliJ.
