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
    public int read(byte[] b) throws IOException {
        byte[] d = new byte[10];
        for (int i = 0; i < b.length; i++) {
            d[i] = (byte) (b[i] ^ key[currentPos % key.length]);
            currentPos++;
        }
        return super.read(d);
    }
}
