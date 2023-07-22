package pl.pilichm.ciphers;

import pl.pilichm.util.Constants;
import pl.pilichm.util.SupportedLanguages;

import java.io.*;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.IntFunction;

public abstract class AbstractCipher {
    public SupportedLanguages chosenLanguage;
    public ArrayList<Character> nonLetterCharacters;

    public IntFunction<Integer> encodingFunction;
    public IntFunction<Integer> decodingFunction;

    public String decode(String textToDecode){
        StringBuilder decodedText = new StringBuilder();
        textToDecode = textToDecode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToDecode);
        ArrayList<Character> alphabet = getAlphabet();

        while (it.current() != CharacterIterator.DONE){
            if (alphabet.contains(it.current())) {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = decodingFunction.apply(currentLetterIdx);

                if (currentLetterIdx < 0) {
                    currentLetterIdx += alphabet.size();
                }

                decodedText.append(alphabet.get(currentLetterIdx));
            } else if (nonLetterCharacters.contains(it.current()) || it.current() == ' '){
                decodedText.append(it.current());
            }

            it.next();
        }

        return decodedText.toString();
    };

    public String encode(String textToEncode) {
        StringBuilder encodedText = new StringBuilder();
        textToEncode = textToEncode.toUpperCase();
        CharacterIterator it = new StringCharacterIterator(textToEncode);
        ArrayList<Character> alphabet = getAlphabet();

        while (it.current() != CharacterIterator.DONE) {
            if (alphabet.contains(it.current())) {
                int currentLetterIdx = alphabet.indexOf(it.current());
                currentLetterIdx = encodingFunction.apply(currentLetterIdx);
                encodedText.append(alphabet.get(currentLetterIdx));
            } else if (nonLetterCharacters.contains(it.current()) || it.current() == ' '){
                encodedText.append(it.current());
            }
            it.next();
        }

        return encodedText.toString();
    };

    private void processEncodingDecodingOnFile(String pathToInFile, String pathToOutFile, boolean isEncoded) {
        File inFile = new File(pathToInFile);
        BufferedWriter writer;

        try {
            if (!new File(pathToInFile).isFile()){
                File outFile = new File(pathToOutFile);
                boolean result = outFile.createNewFile();

                if (!result) {
                    System.out.println("Out file not created!");
                    return;
                }
            }

            writer = new BufferedWriter(new FileWriter(pathToOutFile));
        } catch (IOException ioEx) {
            System.out.println("IOException while processing out file!");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(inFile))){
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                String processedLine;

                if (isEncoded) {
                    processedLine = decode(currentLine);
                } else {
                    processedLine = encode(currentLine);
                }

                writer.append(processedLine).append("\n");
            }

        } catch (FileNotFoundException noFileEx) {
            System.out.println("Input file does not exist!");
        } catch (IOException ioEx) {
            System.out.println("IOException while reading input file!");
        } finally {
            try {
                writer.close();
            } catch (IOException ioEx) {
                System.out.println("Exception while saving output file!");
            }
        }
    }

    public void encodeFile(String pathToInFile, String pathToOutFile) {
        processEncodingDecodingOnFile(pathToInFile, pathToOutFile, false);
    }

    public void decodeFile(String pathToInFile, String pathToOutFile){
        processEncodingDecodingOnFile(pathToInFile, pathToOutFile, true);
    }

    public void setChosenLanguage(SupportedLanguages chosenLanguage) {
        this.chosenLanguage = chosenLanguage;
    }

    public SupportedLanguages getChosenLanguage() {
        return chosenLanguage;
    }

    public ArrayList<Character> getAlphabet(){
        if (Objects.requireNonNull(getChosenLanguage()) == SupportedLanguages.POLISH) {
            return new ArrayList<>(Constants.alphabetPolish);
        }
        return new ArrayList<>(Constants.alphabetEnglish);
    }
}
