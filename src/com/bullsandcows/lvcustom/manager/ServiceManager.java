package com.bullsandcows.lvcustom.manager;

import com.bullsandcows.lvcustom.MainMenuType;

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
        switch (MainMenuType.find(sc.nextLine())) {
            // 유저 난이도선택 메뉴
            case SETDIFFT:
                nm.setDifficulty();
                nm.addNum();
                gm.judge(nm.getNumber());
                break;
            // 게임 실행 메뉴
            case START:
                nm.addNum();
                gm.judge(nm.getNumber());
                break;
            // 유저 게임기록 출력 메뉴
            case HISTORY:
                dm.printGameLog(gm.getGameCountList());
                break;
            // 게임 종료 메뉴
            case EXIT:
                System.out.println("< 숫자 야구 게임을 종료합니다 >");
                System.exit(0);
                break;
        }
    }
}
