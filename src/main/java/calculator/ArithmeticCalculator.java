package calculator;

public class ArithmeticCalculator extends Calculator {
    // 연산자 객체 생성
    // final 이용하여 불변성 보장
    private final AddOperator add;
    private final SubtractOperator sub;
    private final MultiplyOperator mul;
    private final DivideOperator div;

    // 사칙 연산 생성자
    public ArithmeticCalculator() {
        super(); // Calculator 생성자 호출
        this.add = new AddOperator();
        this.sub = new SubtractOperator();
        this.mul = new MultiplyOperator();
        this.div = new DivideOperator();
    }

    // 사칙 연산 계산기
    public double calculate(double num1, double num2, char operator) throws DivideByZeroException, InvalidOperatorException {
        double result; // 결과 저장용 변수 선언

        switch (operator) {
            case '+': // 덧셈 연산
                result = add.operate(num1, num2);
                break;
            case '-': // 뺄셈 연산
                result = sub.operate(num1, num2);
                break;
            case '*': // 곱셈 연산
                result = mul.operate(num1, num2);
                break;
            case '/': // 나눗셈 연산
                result = div.operate(num1, num2);
                break;
            default: // 잘못된 연산 기호를 입력했을 때 예외 처리
                throw new InvalidOperatorException("잘못된 연산 기호입니다.");
        }
        resultList.add(result); // 결과 저장
        return result; // 결괏값 반환
    }

    // 연산 결과 중 가장 먼저 저장된 데이터 삭제하는 메서드 구현
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("삭제 후 현재 저장된 결과: " + resultList + "\n");
        }
        else { // 만약 리스트에 연산 결과가 없다면
            System.out.println("리스트가 비어 있습니다.\n"); // 안내문 출력
        }
    }
}
