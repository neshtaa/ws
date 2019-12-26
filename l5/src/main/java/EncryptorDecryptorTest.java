package main.java;

import org.junit.Assert;
import org.junit.Test;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import static org.junit.Assert.*;

public class EncryptorDecryptorTest {

    private Decryptor d1;
	private Encryptor e1;

	@Test
    public void decrypt() throws IOException {
        String expected = "Test";
        char[] array = {(char)(201), (char)(218), (char)(232), (char)(233)};
        String inputLine = new String(array);
        e1 = new Encryptor(new FileReader("input.txt"));
        String actual = e1.decrypt(inputLine, 'u');
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void encrypt() throws IOException {
        char[] array = {(char)(201), (char)(218), (char)(232), (char)(233)};
        String expected = new String(array);
        d1 = new Decryptor(new FileWriter("output.txt"));
        String actual = d1.encrypt("Test", 'u');
        Assert.assertEquals(expected, actual);
    }
}