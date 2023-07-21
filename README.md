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

<h3>Used technologies:</h3>

- java (openjdk-20),
- junit5,
- IntelliJ.
