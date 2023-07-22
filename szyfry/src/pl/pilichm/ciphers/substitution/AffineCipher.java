package pl.pilichm.ciphers.substitution;

import pl.pilichm.ciphers.AbstractCipher;
import pl.pilichm.ciphers.Cipher;
import pl.pilichm.util.Constants;
import pl.pilichm.util.SupportedLanguages;

import java.util.ArrayList;

public class AffineCipher extends AbstractCipher implements Cipher {
    private int parameter_a;
    private int parameter_b;

    public void setParameter_a(int parameter_a) {
        this.parameter_a = parameter_a;
    }

    public void setParameter_b(int parameter_b) {
        this.parameter_b = parameter_b;
    }

    public AffineCipher() {
        parameter_a = 5;
        parameter_b = 8;
        chosenLanguage = SupportedLanguages.ENGLISH;
        nonLetterCharacters = new ArrayList<>(Constants.nonLetterCharacters);
        this.encodingFunction = currentLetterIdx ->
                (parameter_a * currentLetterIdx + parameter_b) % getAlphabet().size();
        this.decodingFunction = currentLetterIdx ->
                getModularMultiplicativeInverse() * (currentLetterIdx - parameter_b) % getAlphabet().size();
    }

    private int getModularMultiplicativeInverse() {
        int currentNumber = 1;
        int alphabetSize = getAlphabet().size();

        while (currentNumber < alphabetSize) {
            if ((parameter_a * currentNumber) % alphabetSize == 1) {
                return currentNumber;
            } else {
                currentNumber ++;
            }
        }

        return currentNumber;
    }
}
