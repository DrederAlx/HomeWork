package IOHomeWork;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyOutputStream extends FilterOutputStream {

    public MyOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        String keyWord = "Java";
        byte[] keyArr = keyWord.getBytes();
        byte[] result = new byte[keyArr.length];
        for(int i = 0; i< keyArr.length; i++) {
            result[i] = (byte) (b ^ keyArr[i % keyArr.length]);
        }
        super.write(result);
    }
}
