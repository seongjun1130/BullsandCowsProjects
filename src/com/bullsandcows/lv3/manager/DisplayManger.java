package com.bullsandcows.lv3.manager;

import java.util.List;

public class DisplayManger {
    // 게임의 상황을 출력해주는 메소드
    public void printScoreBoard(int stkcnt, int ballcnt) {
        if (stkcnt == 3) {
            System.out.println("정답입니다.");
        } else if (stkcnt >= 1 || ballcnt >= 1) {
            System.out.println(stkcnt + "스트라이크 " + ballcnt + " 볼");
        } else {
            System.out.println("아웃");
        }
    }

    // 게임 시작시 메인메뉴 출력
    public void printMainMenu() {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }

    // 현재까지 진행한 게임 시도횟수
    public void printGameLog(List<Integer> gameLogList) {
        // 진행된 게임 기록이 있는지 유효성 검사
        if (gameLogList.isEmpty()) {
            System.out.println("진행된 게임 기록이 없습니다.");
        } else {
            int gameCnt = 0;
            System.out.println("<게임 기록 보기>");
            for (int item : gameLogList) {
                System.out.println(++gameCnt + " 번째 게임 : 시도횟수 - " + item);
            }
        }
    }
}
