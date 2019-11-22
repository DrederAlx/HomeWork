package IOHomeWork;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyInputStream extends FilterInputStream {

    private byte[] key;
    private int currentPos;

    public MyInputStream(InputStream in, String stringKey) {
        super(in);
        this.key = stringKey.getBytes();
    }

    @Override
    public int read() throws IOException {
        int inByte = super.read();

        inByte = inByte ^ key[currentPos++ % key.length];

        return inByte;
    }
}
