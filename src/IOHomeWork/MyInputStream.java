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
        return super.read();
    }
}
