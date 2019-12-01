package ExceptionHomeWork.CalcExcept;

public class OperatorsException extends Exception {
    @Override
    public String getMessage() {
        return ("Недопустимый ввод: введите один оператор +, -, *, /");
    }
}
