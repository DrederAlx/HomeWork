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
        super.write(b);
    }
}
