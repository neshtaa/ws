package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Vocabulary {
    private Map<String, String> en_ukrVocab;


    Vocabulary(Map<String, String> inputVocab) {
        en_ukrVocab = inputVocab;
    }

    Vocabulary() {
        en_ukrVocab = new HashMap<>();
    }

    void addPair(String english, String ukrainian) {
        en_ukrVocab.put(english.toLowerCase(), ukrainian.toLowerCase());
    }

    String translatePhraseInUkrainian(String phrase) {
        String outputPhrase = "";
        String[] wordsForTranslation = phrase.split(" ");
        for (String str : wordsForTranslation) {
            outputPhrase += " " + en_ukrVocab.get(str.toLowerCase());
        }
        outputPhrase = outputPhrase.substring(1);
        return outputPhrase;
    }

    void readPairFromKeyboard() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter word in english->");
        String english = in.nextLine();
        System.out.print("Enter word in ukrainian->");
        String ukrainian = in.nextLine();
        en_ukrVocab.put(english, ukrainian);
    }
}
