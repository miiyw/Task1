package calculator;

public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message); // 부모 클래스 Exception에 메시지 전달
    }
}
