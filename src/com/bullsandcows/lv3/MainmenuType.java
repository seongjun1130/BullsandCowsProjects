package com.bullsandcows.lv3;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MainmenuType {
    YES("1"),
    HISTORY("2"),
    EXIT("3");

    // 프로그램이 실행되면 Map을 캐싱해 찾고자 하는 키값과 필드값을 매칭 스트림과 람다식을 활용.
    private static final Map<String, MainmenuType> MAINMENU_TYPE_MAP_MAP =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(MainmenuType::getMainmenu, Function.identity())));
    private final String mainmenu;

    // 생성자를 통한 String 매칭
    MainmenuType(String mainmenu) {
        this.mainmenu = mainmenu;
    }

    // 입력된 연산자를 통해 Map 안에서 열거 객체 리턴
    public static MainmenuType find(String mainmenu) {
        if (MAINMENU_TYPE_MAP_MAP.containsKey(mainmenu)) {
            return MAINMENU_TYPE_MAP_MAP.get(mainmenu);
        } else {
            // 지정메뉴외 문자 입력시 예외발생
            throw new NullPointerException("메뉴중에서 입력해주세요.");
        }
    }

    public String getMainmenu() {
        return mainmenu;
    }
}
