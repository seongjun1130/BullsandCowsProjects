package com.bullsandcows.lvcustom.manager;

import java.util.List;
import java.util.Scanner;

public class ChanceManger {
    private static int chance = 2;
    private Scanner sc = new Scanner(System.in);

    // 유저입력값을 받아 입력값 Index 에 해당하는 숫자 반환 메소드
    public void getIndexNumber(List<Integer> nums) {
        if (chance >= 2) {
            System.out.println("알고 싶은 자리수를 입력해주세요");
            while (true) {
                int chanceIndex = sc.nextInt();
                if (nums.size() > chanceIndex - 1) {
                    System.out.println(chanceIndex + " 번째 숫자는 " + nums.get(chanceIndex - 1) + " 입니다.");
                    chance -= 2;
                    break;
                } else {
                    System.out.println("자리수 입력을 확인해주세요.");
                    sc.nextLine();
                }
            }
        } else {
            System.out.println("가진 찬스횟수가 부족합니다.");
        }
    }

    // 유저입력값을 받아 입력값 Index 에 해당하는 숫자 가 큰지 작은지 반환하는 메소드
    public void getIndexNumberUpDown(List<Integer> nums) {
        if (chance >= 1) {
            System.out.println("알고 싶은 자리수를 입력해주세요");
            while (true) {
                int chanceIndex = sc.nextInt();
                if (nums.size() > chanceIndex - 1) {
                    System.out.println("Up & Down 기준 숫자를 입력해주세요.");
                    int standardNum = sc.nextInt();
                    if (standardNum > nums.get(chanceIndex - 1)) {
                        System.out.println("DOWN");
                    } else if (standardNum < nums.get(chanceIndex - 1)) {
                        System.out.println("UP");
                    } else {
                        System.out.println("Same");
                    }
                    chance--;
                    break;
                } else {
                    System.out.println("자리수 입력을 확인해주세요.");
                    sc.nextLine();
                }
            }
        } else {
            System.out.println("가진 찬스횟수가 부족합니다.");
        }
    }

    // 유저가 찬스기능을 활요하는지에 대한 흐름분기 제어
    public void useChance(List<Integer> nums) {
        System.out.println("현재남은 찬스횟수 : " + getChanceNumber());
        System.out.println("찬스를 사용하려면 Y 입력 미사용시 N 입력");
        Loop1:
        while (true) {
            String userSelChance = sc.nextLine();
            if (userSelChance.equalsIgnoreCase("Y")) {
                while (true) {
                    System.out.println("1. 정확한 번호 알기(기회 2회 소모) 2. 번호 Up & Down(기회 1회 소모)");
                    int userSelChanceMenu = sc.nextInt();
                    if (userSelChanceMenu == 1) {
                        getIndexNumber(nums);
                        break Loop1;
                    } else if (userSelChanceMenu == 2) {
                        getIndexNumberUpDown(nums);
                        break Loop1;
                    } else {
                        System.out.println("1, 2 번중 입력해주세요.");
                        sc.nextLine();
                    }
                }
            } else if (userSelChance.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Y, N 중 입력해주세요.");
            }
        }
    }

    public void setChance(int chance) {
        ChanceManger.chance = chance;
    }

    public int getChanceNumber() {
        return chance;
    }

    public void refillChance(int difficulty) {
        if (difficulty == 5) {
            chance = 3;
        } else {
            chance = 2;
        }
    }
}