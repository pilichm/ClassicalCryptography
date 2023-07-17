package pl.pilichm.util;

import java.util.List;

public class Constants {
    public static List<Character> alphabetEnglish = List.of(
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
            'Y','Z'
    );

    public static List<Character> alphabetPolish = List.of(
            'A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł', 'M', 'N', 'Ń',
            'O', 'Ó', 'P', 'Q', 'R', 'S', 'Ś', 'T', 'U', 'V', 'W','X', 'Y', 'Z', 'Ź', 'Ż'
    );

    public static List<Character> nonLetterCharacters = List.of(
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '~', '`', '{', '}', '[', ']', '!', '%', '^',
            '*', '-', '=', '+', '_', '|', '/', '\\', '@', ':', ';', '<', '>','?', '.', ',', '#', '&', '$', '(', ')'
    );

}
