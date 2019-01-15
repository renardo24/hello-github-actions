package omr.caesarcipher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarCipherSimpleRotationTest {

    @Test
    public void encryptAndDecrypt() {
        String input = "HELLO THERE!";
        CaesarCipher cipher = new CaesarCipher(input);

        String expectedEncryptedText = "MJQQT YMJWJ!";
        assertEquals(expectedEncryptedText, cipher.rotateRight(5).getText());
        assertEquals(input, cipher.rotateLeft(5).getText());
        assertEquals("HELLO THERE!", cipher.getOriginalText());
    }

    @Test
    public void encryptManyTimesAndDecryptOnce() {
        String input = "HELLO THERE!";
        CaesarCipher cipher = new CaesarCipher(input);
        String expectedEncryptedText = "MJQQT YMJWJ!";
        assertEquals(expectedEncryptedText, cipher.rotateRight(5).getText());

        expectedEncryptedText = "OLSSV AOLYL!";
        assertEquals(expectedEncryptedText, cipher.rotateRight(2).getText());

        expectedEncryptedText = "EBIIL QEBOB!";
        assertEquals(expectedEncryptedText, cipher.rotateRight(16).getText());

        assertEquals(input, cipher.rotateLeft(23).getText());
        assertEquals("HELLO THERE!", cipher.getOriginalText());
    }

    @Test
    public void encryptManyTimesFluentAPIAndDecryptOnce() {
        String input = "HELLO THERE!";
        CaesarCipher cipher = new CaesarCipher(input);

        String expectedEncryptedText = "DAHHK PDANA!";
        String encryptedText = cipher.rotateRight(5).rotateRight(2).rotateLeft(11).getText();
        assertEquals(expectedEncryptedText, encryptedText);

        assertEquals(input, cipher.rotateRight(4).getText());
        assertEquals("HELLO THERE!", cipher.getOriginalText());
    }
}
