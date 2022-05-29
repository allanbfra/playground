package challanges.playground.kis;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class KisPairProgramming {

    public String buildTranslatedSentence(String sentence) {
        String translatedSentence = sentence;

        String[] words = sentence.split("[\\W]");

        for (int i = 0; i < words.length; i++) {
            String currentWord = String.valueOf(words[i]).replaceAll("[\\d]", "");
            String translatedWord = translateAncientWord(currentWord);
            translatedSentence = translatedSentence.replace(currentWord, translatedWord);
        }

        return  translatedSentence;
    }

    private String translateAncientWord(final String ancientText) {
        if (ancientText.length() < 1) { return ""; }

        int firstVowelIndex = findFirstVowelPosition(ancientText.toCharArray());
        boolean hasConsonant = containsConsonant(ancientText);
        boolean isUpperCase = Character.isUpperCase(ancientText.toCharArray()[0]);

        String prefix = new String();
        String stem;

        if (!hasConsonant || firstVowelIndex <= 0) {
            stem = ancientText.toLowerCase();
        } else {
            prefix = ancientText.substring(0, firstVowelIndex).toLowerCase();
            stem = ancientText.substring(firstVowelIndex);
        }

        if (isUpperCase) { stem = StringUtils.capitalize(stem); }

        return stem + prefix + (hasConsonant ? "ay" : "yay");
    }

    private int findFirstVowelPosition(char[] word){
        List vowelList = Arrays.asList("a", "e", "i", "o", "u", "y");

        for (int i = 0; i < word.length; i++){
            if (vowelList.contains(String.valueOf(word[i]).toLowerCase())) {
                return i;
            }
        }

        return -1;
    }

    private boolean containsConsonant(String word) {
        char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z' };

        for (char consonant : consonants) {
            if (word.toLowerCase().contains(String.valueOf(consonant))) {
                return true;
            }
        }

        return false;
    }
}
