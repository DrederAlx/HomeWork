package IOHomeWork;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyInputStream extends FilterInputStream {

    public MyInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        byte[] result = new byte[text.length];
        byte[] keyArr = keyWord.getBytes();
        for(int i = 0; i < text.length;i++) {
            result[i] = (byte) (text[i] ^ keyArr[i % keyArr.length]);
        }
        return super.read();
    }
}
