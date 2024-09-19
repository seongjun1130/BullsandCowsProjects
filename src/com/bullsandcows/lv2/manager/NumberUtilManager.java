package com.bullsandcows.lv2.manager;

import java.util.*;

public class NumberUtilManager {
    // 정답, 유저입력 숫자 저장 List
    private final Set<Integer> numSet = new HashSet<>();
    private final List<Integer> numList = new ArrayList<>();
    private final List<Integer> userNumList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // 게임 시작시 3개의 숫자를 생성. Set으로 중복을 제거하고 List로 변환시켜 셔플.
    public void addNum() {
        numSet.clear();
        numList.clear();
        while (numSet.size() < 3) {
            // random 메소드를 통해 1~9 숫자 생성
            numSet.add((int) (Math.random() * 9) + 1);
        }
        numList.addAll(numSet);
        Collections.shuffle(numList);
        System.out.println("< 게임을 시작합니다 >");
    }

    // 유저에게 숫자를 연속된 문자열을 입력받아 List 저장
    public void inputNum() {
        // 외부에서 반복시 저장되어있던 값 삭제
        userNumList.clear();
        while (userNumList.size() < 3) {
            System.out.println("숫자를 3자리로 입력하세요.");
            userNumList.clear();
            String userNum = sc.nextLine();
            // 입력값 유효성 검사
            if (userNum.length() >= 4) {
                System.out.println("숫자를 3자리로 입력해주세요.");
            } else {
                // 문자열을 나누어서 각각의 int 타입 숫자로 일의 자릿수로 저장,
                for (int i = 0; i < userNum.length(); i++) {
                    char c = userNum.charAt(i);
                    // 입력값 유효성검사.
                    if (checkInputValidity(c)) {
                        // 올바른 데이터일 경우 List add
                        userNumList.add(Character.getNumericValue(c));
                    } else {
                        break;
                    }
                }
            }
        }
    }

    // 유저 숫자값 입력검증(중복, 0포함, 숫자외 문자열)
    private boolean checkInputValidity(char input) {
        if (userNumList.contains(Character.getNumericValue(input)) || Character.getNumericValue(input) == 0 || !Character.isDigit(input)) {
            System.out.println("올바르지 않은 입력값입니다.");
            userNumList.clear();
            return false;
        } else {
            return true;
        }
    }

    // 정답 숫자 List 반환
    public List<Integer> getNumber() {
        return numList;
    }

    // 유저 입력숫자 List 반환
    public List<Integer> getUserNum() {
        return userNumList;
    }
}
