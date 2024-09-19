package com.bullsandcows.lvcustom.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameJudgeManager {
    private int gamecnt = 0;
    private boolean judgeflag = false;
    private List<Integer> gameCountList = new ArrayList<>();
    private List<Integer> numList = new ArrayList<>();
    private List<Integer> userList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private NumberUtilManager nm = new NumberUtilManager();
    private DisplayManger dm = new DisplayManger();
    private ChanceManger cm = new ChanceManger();

    // 게임의 승패판정 및 게임시도횟수 집계 메소드
    public void judge(List<Integer> nums) {
        judgeflag = !judgeflag;
        while (judgeflag) {
            numList = nums;
            // 난이도 수 만큼 strike 시 게임승리
            // 시도횟수를 CountList 에 저장
            if (judgeStrikesAndBalls() == nm.getDifficulty()) {
                gamecnt++;
                gameCountList.add(gamecnt);
                gamecnt = 0;
                cm.refillChance(nm.getDifficulty());
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
        // 유저가 찬스를 사용할지 여부확인
        if (cm.getChanceNumber() > 0) {
            cm.useChance(numList);
        }
        nm.inputNum();
        userList = nm.getUserNum();
        // 2중 반복문을 사용하여 strike, ball 집계
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

    // 테스트용 정답 출력용 메소드.
    public void printAnswerLog() {
        for (int item : numList) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
