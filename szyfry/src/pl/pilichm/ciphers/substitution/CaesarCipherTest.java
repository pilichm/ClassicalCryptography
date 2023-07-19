package pl.pilichm.ciphers.substitution;

import pl.pilichm.util.SupportedLanguages;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {
    private final String plainText = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
    private final String encodedText = "QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD";

    private final String encodedWith123Offset = "MAX JNBVD UKHPG YHQ CNFIL HOXK MAX ETSR WHZ";
    private final int customTestOffset = 123;

    @org.junit.jupiter.api.Test
    void setChosenLanguage() {
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);
        cc.setChosenLanguage(SupportedLanguages.POLISH);
        assertSame(cc.getChosenLanguage(), SupportedLanguages.POLISH);
    }

    @org.junit.jupiter.api.Test
    void encode() {
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);
        assertEquals(cc.encode(plainText), encodedText);
    }

    @org.junit.jupiter.api.Test
    void encodeWithCustomOffset() {
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);
        cc.setOffset(customTestOffset);
        assertEquals(cc.encode(plainText, customTestOffset), encodedWith123Offset);
    }

    @org.junit.jupiter.api.Test
    void decode() {
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);
        assertEquals(cc.decode(encodedText), plainText);
    }

    @org.junit.jupiter.api.Test
    void decodeWithCustomOffset() {
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.ENGLISH);
        cc.setOffset(customTestOffset);
        assertEquals(cc.decode(encodedWith123Offset, customTestOffset), plainText);
    }

    @org.junit.jupiter.api.Test
    void setOffset() {
        CaesarCipher cc = new CaesarCipher(SupportedLanguages.POLISH);
        cc.setOffset(customTestOffset);
        assertSame(cc.getOffset(), customTestOffset);
    }
}