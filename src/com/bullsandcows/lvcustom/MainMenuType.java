package com.bullsandcows.lvcustom;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MainMenuType {
    SETDIFFT("0"),
    START("1"),
    HISTORY("2"),
    EXIT("3");

    // 프로그램이 실행되면 Map을 캐싱해 찾고자 하는 키값과 필드값을 매칭 스트림과 람다식을 활용.
    private static final Map<String, MainMenuType> MAINMENU_TYPE_MAP_MAP =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(MainMenuType::getMainMenu, Function.identity())));
    private final String mainMenu;

    // 생성자를 통한 String 매칭
    MainMenuType(String mainMenu) {
        this.mainMenu = mainMenu;
    }

    // 입력된 연산자를 통해 Map 안에서 열거 객체 리턴
    public static MainMenuType find(String mainMenu) {
        if (MAINMENU_TYPE_MAP_MAP.containsKey(mainMenu)) {
            return MAINMENU_TYPE_MAP_MAP.get(mainMenu);
        } else {
            // 지정메뉴외 문자 입력시 예외발생
            throw new NullPointerException("올바른 숫자를 입력해주세요!");
        }
    }

    public String getMainMenu() {
        return mainMenu;
    }
}
