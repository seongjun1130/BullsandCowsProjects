package com.bullsandcows.lvcustom;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ChanceMainMenuType {
    EXITCHANCE("0"),
    OPENNUM("1"),
    UPDOWN("2"),
    SUMNUM("3");

    // 프로그램이 실행되면 Map을 캐싱해 찾고자 하는 키값과 필드값을 매칭 스트림과 람다식을 활용.
    private static final Map<String, ChanceMainMenuType> ChanceMainMenu_TYPE_MAP_MAP =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(ChanceMainMenuType::getChanceMainMenu, Function.identity())));
    private final String chanceMainMenu;

    // 생성자를 통한 String 매칭
    ChanceMainMenuType(String chanceMainMenu) {
        this.chanceMainMenu = chanceMainMenu;
    }

    // 입력된 연산자를 통해 Map 안에서 열거 객체 리턴
    public static ChanceMainMenuType find(String chanceMainMenu) {
        if (ChanceMainMenu_TYPE_MAP_MAP.containsKey(chanceMainMenu)) {
            return ChanceMainMenu_TYPE_MAP_MAP.get(chanceMainMenu);
        } else {
            // 지정메뉴외 문자 입력시 예외발생
            throw new NullPointerException("올바른 숫자를 입력해주세요!");
        }
    }

    public String getChanceMainMenu() {
        return chanceMainMenu;
    }
}
