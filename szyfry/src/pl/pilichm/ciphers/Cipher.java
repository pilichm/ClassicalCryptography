package pl.pilichm.ciphers;

public interface Cipher {
    public String encode(String textToEncode);

    public String decode(String textToDecode);
}
