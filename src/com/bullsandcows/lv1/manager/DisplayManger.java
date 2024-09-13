package com.bullsandcows.lv1.manager;

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
}
