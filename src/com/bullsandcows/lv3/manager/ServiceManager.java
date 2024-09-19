package com.bullsandcows.lv3.manager;

import com.bullsandcows.lv3.MainMnuType;

import java.util.Scanner;

public class ServiceManager {
    private NumberUtilManager nm = new NumberUtilManager();
    private GameJudgeManager gm = new GameJudgeManager();
    private DisplayManger dm = new DisplayManger();
    private Scanner sc = new Scanner(System.in);

    // 전체적인 프로그램 흐름을 담당하는 메소드
    public void run() {
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요.");
        while (true) {
            try {
                dm.printMainMenu();
                controlMainMenuSelection();
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // MainMenu 선택에 따른 행동흐름 제어
    private void controlMainMenuSelection() {
        switch (MainMnuType.find(sc.nextLine())) {
            case YES:
                nm.addNum();
                gm.judge(nm.getNumber());
                break;
            case HISTORY:
                dm.printGameLog(gm.getGameCountList());
                break;
            case EXIT:
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                System.exit(0);
                break;
        }
    }
}
