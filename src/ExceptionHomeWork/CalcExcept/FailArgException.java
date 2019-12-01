package ExceptionHomeWork.CalcExcept;

public class FailArgException extends Exception {
    @Override
    public String getMessage() {
        return ("Недопустимый ввод: Вы пытаетесь разделить на 0 или вводите дробные числа");
    }
}
