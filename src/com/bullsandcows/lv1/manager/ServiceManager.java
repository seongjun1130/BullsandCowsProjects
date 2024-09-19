package com.bullsandcows.lv1.manager;

public class ServiceManager {
    private NumberUtilManager nm = new NumberUtilManager();
    private GameJudgeManager gm = new GameJudgeManager();

    // 전체적인 프로그램 흐름을 담당하는 메소드
    public void run() {
        nm.addNum();
        gm.judge(nm.getNumber());
    }
}
