package calculator;

import java.util.*;

public abstract  class Calculator {
    protected List<Double> resultList; // 연산 결과와 원의 넓이를 저장하는 리스트

    // 연산을 수행하는 추상 메서드
    // 매개변수에 가변 인자를 사용하여 다양한 입력에 반응할 수 있도록 함
    //          => 타입... 변수명: 가변 인자 형식, 인자 개수를 구애받지 않고 입력할 수 있음
    public abstract double calculate(double... numbers);

    // 기본 생성자 구현
    public Calculator() {
        this.resultList = new ArrayList<>(); // 사칙 연산 결과 저장 리스트 초기화
    }

    // Getter 메서드 구현
    public List<Double> getResultList() {
        return new ArrayList<>(this.resultList);
    }

    // Setter 메서드 구현
    public void setResultList(List<Double> newResultList) {
        this.resultList = new ArrayList<>(newResultList); // 리스트 복사본으로 안전한 수정이 가능하게 함
    }

    // 저장된 연산 결과를 조회하는 메서드 구현
    public void inquiryResults() {
        System.out.print("저장된 연산 결과: ");
        for (double number : resultList) { // 향상된 for문 사용하여 연산 결과 출력
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println();
    }
}