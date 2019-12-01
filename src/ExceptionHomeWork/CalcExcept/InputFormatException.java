package ExceptionHomeWork.CalcExcept;

public class InputFormatException extends Exception {
    @Override
    public String getMessage() {
        return ("Недопустиый ввод: введите выражение типа m+n, m-n, m*n, m/n");
    }
}
