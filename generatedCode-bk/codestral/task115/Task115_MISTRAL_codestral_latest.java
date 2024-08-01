package codestral.task115;

public class Task115_MISTRAL_codestral_latest {
    private int bitField;

    public Task115_MISTRAL_codestral_latest(int bitField) {
        this.bitField = bitField;
    }

    public int getBitField() {
        return bitField;
    }

    public void setBitField(int bitField) {
        this.bitField = bitField;
    }

    public boolean getBit(int position) {
        return ((bitField & (1 << position)) != 0);
    }

    public void setBit(int position, boolean value) {
        if (value)
            bitField |= (1 << position);
        else
            bitField &= ~(1 << position);
    }
}