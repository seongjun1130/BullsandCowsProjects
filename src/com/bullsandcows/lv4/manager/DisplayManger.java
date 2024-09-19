package com.bullsandcows.lv4.manager;

import java.util.List;
import java.util.Scanner;

public class DisplayManger {
    Scanner sc = new Scanner(System.in);
    NumberUtilManager nm = new NumberUtilManager();

    // 게임의 상황을 출력해주는 메소드
    public void printScoreBoard(int stkcnt, int ballcnt) {
        if (stkcnt == nm.getDifficulty()) {
            System.out.println("정답입니다.");
        } else if (ballcnt >= 1) {
            System.out.println(stkcnt + "스트라이크 " + ballcnt + " 볼");
        } else {
            System.out.println("아웃");
        }
    }

    // 게임 시작시 메인메뉴 출력
    public void printMainMenu() {
        System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }

    // 현재까지 진행한 게임 시도횟수
    public void printGameLog(List<Integer> gameLogList) {
        // 진행된 게임 기록이 있는지 유효성 검사
        if (gameLogList.isEmpty()) {
            System.out.println("진행된 게임 기록이 없습니다.");
        } else {
            int gameCnt = 0;
            System.out.println("<게임 기록 보기>");
            // 패싱 받은 List 를 전체반복하며 유저 게임횟수 출력
            for (int item : gameLogList) {
                System.out.println(++gameCnt + " 번째 게임 : 시도횟수 - " + item);
            }
        }
    }
}
