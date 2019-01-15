package omr.caesarcipher;

public class CaesarCipher {

    public static final int LOWER_LIMIT = (int) 'A';
    public static final int UPPER_LIMIT = (int) 'Z';

    public enum ROTATION_DIRECTION {
        LEFT, RIGHT
    }

    private String originalText;
    private String text;

    public CaesarCipher(final String text) {
        this.text = text.toUpperCase();
        this.originalText = this.text;
    }

    private int getModuloShift(int shift) {
        return shift % 26;
    }

    private static char doRightRotation(final int charIntValue, final int moduloShift) {
        int newCharIntValue = charIntValue + moduloShift;
        if (newCharIntValue > UPPER_LIMIT) {
            int diff = newCharIntValue - UPPER_LIMIT;
            newCharIntValue = LOWER_LIMIT + diff - 1;
        }
        return (char) newCharIntValue;
    }

    private static char doLeftRotation(final int charIntValue, final int moduloShift) {
        int newCharIntValue = charIntValue - moduloShift;
        if (newCharIntValue < CaesarCipher.LOWER_LIMIT) {
            int diff = CaesarCipher.LOWER_LIMIT - newCharIntValue;
            newCharIntValue = CaesarCipher.UPPER_LIMIT - diff + 1;
        }
        return (char) newCharIntValue;
    }

    private boolean hasNoEffect(final int shift) {
        if (shift == 0 || shift % 26 == 0) return true;
        return false;
    }

    private void doRotation(final int shift, final CaesarCipher.ROTATION_DIRECTION direction) {
        if (hasNoEffect(shift)) return;
        int moduloShift = getModuloShift(shift);
        StringBuilder sb = new StringBuilder();
        for (char theChar : text.toCharArray()) {
            int charIntValue = (int) theChar;
            if (charIntValue < CaesarCipher.LOWER_LIMIT || charIntValue > CaesarCipher.UPPER_LIMIT) {
                sb.append(theChar);
            }
            else {
                if (direction == CaesarCipher.ROTATION_DIRECTION.LEFT) {
                    sb.append(doLeftRotation(charIntValue, moduloShift));
                } else {
                    sb.append(CaesarCipher.doRightRotation(charIntValue, moduloShift));
                }
            }
        }
        this.text = sb.toString();
    }

    public CaesarCipher rotateLeft(final int shift) {
        doRotation(shift, CaesarCipher.ROTATION_DIRECTION.LEFT);
        return this;
    }

    public CaesarCipher rotateRight(final int shift) {
        doRotation(shift, CaesarCipher.ROTATION_DIRECTION.RIGHT);
        return this;
    }

    public String getText() {
        return text;
    }

    public String getOriginalText() {
        return originalText;
    }
}
