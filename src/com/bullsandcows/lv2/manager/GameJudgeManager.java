package com.bullsandcows.lv2.manager;

import java.util.ArrayList;
import java.util.List;

public class GameJudgeManager {
    private int gamecnt = 0;
    private boolean judgeflag = false;
    private List<Integer> gameCountList = new ArrayList<>();
    private List<Integer> numList = new ArrayList<>();
    private List<Integer> userList = new ArrayList<>();
    private NumberUtilManager nm = new NumberUtilManager();
    private DisplayManger dm = new DisplayManger();

    // 게임의 승패를 판정하는 메소드
    public void judge(List<Integer> nums) {
        judgeflag = !judgeflag;
        while (judgeflag) {
            numList = nums;
            // 3개이상의 strike 시 게임승리
            if (judgeStrikesAndBalls() == 3) {
                gameCountList.add(gamecnt);
                gamecnt = 0;
                judgeflag = !judgeflag;
            } else {
                gamecnt++;
            }
        }
    }

    // Strike 와 Ball 의 갯수를 집계하는 메소드
    public int judgeStrikesAndBalls() {
        printAnswerLog();
        int stkcnt = 0;
        int ballcnt = 0;
        nm.inputNum();
        userList = nm.getUserNum();
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == userList.get(i)) {
                stkcnt++;
            } else {
                for (int j = 0; j < numList.size(); j++) {
                    if (userList.get(i) == numList.get(j)) {
                        ballcnt++;
                    }
                }
            }
        }
        dm.printScoreBoard(stkcnt, ballcnt);
        return stkcnt;
    }
    // 게임 기록 통계반환용 메소드
    public List<Integer> getGameCountList() {
        return gameCountList;
    }

    // 테스트용 정답 로그출력용 메소드.
    public void printAnswerLog() {
        for (int item : numList) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
