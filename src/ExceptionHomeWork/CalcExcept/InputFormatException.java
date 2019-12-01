package ExceptionHomeWork.CalcExcept;

public class InputFormatException extends Exception {
    @Override
    public String getMessage() {
        return ("Недопустиый ввод: введите выражения типа m+n, m-n, m*n, m/n");
    }
}
