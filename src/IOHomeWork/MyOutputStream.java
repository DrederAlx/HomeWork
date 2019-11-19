package IOHomeWork;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends FilterOutputStream {

    private byte[] key;
    private int currentPos;

    public MyOutputStream(OutputStream out, String stringKey) {
        super(out);
        this.key = stringKey.getBytes();
    }

    @Override
    public void write(int b) throws IOException {
        b = b ^ key[currentPos % key.length];
        currentPos++;
        super.write(b);
    }
}
