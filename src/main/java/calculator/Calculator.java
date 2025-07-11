package calculator;

import java.util.*;

public class Calculator {
    private List<Integer> resultList; // 연산 결과를 저장하는 리스트 생성
    private List<Double> radiusList; // 원의 넓이 결괏값을 저장할 리스트 생성

    // PI는 수학적으로 불변인 상수이기 때문에 final과 static 사용
    final static double PI = 3.14159;

    // 기본 생성자 구현
    Calculator() {
        this.resultList = new ArrayList<>(); // 사칙 연산 결과 저장 리스트 초기화
        this.radiusList = new ArrayList<>(); // 원의 넓이 결괏값 저장 리스트 초기화
    }

    // 사칙 연산 - Getter 메서드 구현
    public List<Integer> getResultList() {
        return new ArrayList<>(resultList); // 복사본을 반환하여 캡슐화 유지
    }

    // 사칙 연산 - Setter 메서드 구현
    public void setResultList(List<Integer> newResultList) {
        this.resultList = new ArrayList<>(newResultList); // 리스트 복사본으로 안전한 수정이 가능하게 함
    }

    // 원의 넓이 - Getter 메서드 구현
    public List<Double> getRadiusList() {
        return new ArrayList<>(this.radiusList);
    }

    // 원의 넓이 - Setter 메서드 구현
    public void setRadiusList(List<Double> newRadiusList) {
        this.radiusList = new ArrayList<>(newRadiusList); // 리스트 복사본으로 안전한 수정이 가능하게 함
    }

    // 생성자와 메서드 공간 구분

    public int calculate(int num1, int num2, char operator) throws DivideByZeroException, InvalidOperatorException {
        int result; // 결과 저장용 변수 선언

        switch (operator) {
            case '+': // 덧셈 연산
                result = num1 + num2;
                break;
            case '-': // 뺄셈 연산
                result = num1 - num2;
                break;
            case '*': // 곱셈 연산
                result = num1 * num2;
                break;
            case '/': // 나눗셈 연산
                if (num2 == 0) { // 나눗셈에서 0으로 나누는 경우 예외 처리
                    throw new DivideByZeroException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                }
                result = num1 / num2;
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
            System.out.println("삭제 후 현재 저장된 결과: " + resultList);
        }
        else { // 만약 리스트에 연산 결과가 없다면
            System.out.println("리스트가 비어 있습니다."); // 안내문 출력
        }
    }

    // 저장된 연산 결과를 조회하는 메서드 구현
    public void inquiryResults() {
        System.out.print("저장된 연산 결과: ");
        for (int number : resultList) { // 향상된 for문 사용하여 연산 결과 출력
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // 원의 넓이를 계산하는 메서드 구현
    public double calculateCircleArea(double radius) {
        double result = radius * radius * PI; // 원의 넓이 계산
        radiusList.add(result); // 결과 저장
        return result; // 결괏값 반환
    }

    // 저장된 원의 넓이 결괏값을 조회하는 메서드 구현
    public void inquiryCircleResults() {
        System.out.print("저장된 원의 넓이 결과: ");
        for (double number : radiusList) { // 향상된 for문 사용하여 연산 결과 출력
            System.out.print(number + " | " + "\n");
        }
        System.out.println();
    }
}