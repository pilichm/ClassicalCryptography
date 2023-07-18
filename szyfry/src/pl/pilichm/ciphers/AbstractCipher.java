package pl.pilichm.ciphers;

import java.io.*;

public abstract class AbstractCipher {

    public File readFile(String pathToFile) {
        return new File(pathToFile);
    }

    public abstract String decode(String textToDecode);

    public abstract String encode(String textToEncode);

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
}
