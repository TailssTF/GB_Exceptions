import java.io.IOException;

public class MyInputException extends IOException {
    public MyInputException() {
        super();
    }

    public MyInputException(String s) {
        super(s);
    }
}
