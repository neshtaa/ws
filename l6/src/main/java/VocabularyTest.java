package main.java;

import org.junit.Assert;

//import static org.junit.jupiter.api.Assertions.*;

class VocabularyTest {

    @org.junit.jupiter.api.Test
    void translatePhraseInUkrainian() {
        Vocabulary v1 = new Vocabulary();
        v1.addPair("chair", "������");
        v1.addPair("red", "��������");
        String expected = "�������� ������",
                actual = v1.translatePhraseInUkrainian("Red chair");
        Assert.assertEquals(expected, actual);
    }
}