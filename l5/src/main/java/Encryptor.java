package main.java;

import java.io.*;

public class Encryptor extends FilterReader {
    protected Encryptor(Reader in) {
        super(in);
    }

    public String decrypt(String str, char c) throws IOException {
        String result = "";
//        char symbol;
//        while (true) {
//            symbol = (char) super.read();
//            if (symbol != '\uFFFF')
        for(int i = 0; i < str.length(); i++) {
                result += (char) (str.charAt(i) - c);
//            else
//                break;
        }
//        super.close();
        return result;
    }
}

class Decryptor extends FilterWriter {
    protected Decryptor(Writer out) {
        super(out);
    }

    public String encrypt(String str, char c) throws IOException {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += (char) (str.charAt(i) + c);
        }
        return result;
    }
}
