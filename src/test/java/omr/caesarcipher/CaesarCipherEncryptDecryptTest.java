package omr.caesarcipher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarCipherEncryptDecryptTest {

    @Test
    public void caesarCipherRotateLeft() {
        assertEquals("E", new CaesarCipher("E").rotateLeft(0).getText());
        assertEquals("D", new CaesarCipher("E").rotateLeft(1).getText());
        assertEquals("C", new CaesarCipher("E").rotateLeft(2).getText());
        assertEquals("B", new CaesarCipher("E").rotateLeft(3).getText());
        assertEquals("A", new CaesarCipher("E").rotateLeft(4).getText());
        assertEquals("Z", new CaesarCipher("E").rotateLeft(5).getText());
        assertEquals("Y", new CaesarCipher("E").rotateLeft(6).getText());
        assertEquals("E", new CaesarCipher("E").rotateLeft(26).getText());

        assertEquals("C", new CaesarCipher("E").rotateLeft(28).getText());
        assertEquals("A", new CaesarCipher("E").rotateLeft(30).getText());
        assertEquals("Z", new CaesarCipher("E").rotateLeft(31).getText());

        assertEquals("E", new CaesarCipher("E").rotateLeft(52).getText());
        assertEquals("L", new CaesarCipher("E").rotateLeft(19).getText());

        assertEquals("!", new CaesarCipher("!").rotateLeft(12).getText());
        assertEquals(".", new CaesarCipher(".").rotateLeft(2).getText());
        assertEquals(".", new CaesarCipher(".").rotateLeft(1).getText());
    }

    @Test
    public void caesarCipherRotateRight() {
        assertEquals("V", new CaesarCipher("V").rotateRight(0).getText());
        assertEquals("W", new CaesarCipher("V").rotateRight(1).getText());
        assertEquals("X", new CaesarCipher("V").rotateRight(2).getText());
        assertEquals("Y", new CaesarCipher("V").rotateRight(3).getText());
        assertEquals("Z", new CaesarCipher("V").rotateRight(4).getText());
        assertEquals("A", new CaesarCipher("V").rotateRight(5).getText());
        assertEquals("B", new CaesarCipher("V").rotateRight(6).getText());
        assertEquals("V", new CaesarCipher("V").rotateRight(26).getText());

        assertEquals("X", new CaesarCipher("V").rotateRight(28).getText());
        assertEquals("Z", new CaesarCipher("V").rotateRight(30).getText());
        assertEquals("A", new CaesarCipher("V").rotateRight(31).getText());

        assertEquals("V", new CaesarCipher("V").rotateRight(52).getText());
        assertEquals("L", new CaesarCipher("V").rotateRight(16).getText());

        assertEquals("!", new CaesarCipher("!").rotateRight(12).getText());
        assertEquals(".", new CaesarCipher(".").rotateRight(2).getText());
        assertEquals(".", new CaesarCipher(".").rotateRight(1).getText());
    }
}
