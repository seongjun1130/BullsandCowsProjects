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
                String chanceIndex = sc.nextLine();
                if (chanceIndex.matches("[1-5]+")) {
                    int intChanceIndex = Integer.parseInt(chanceIndex);
                    if (nums.size() > intChanceIndex - 1) {
                        System.out.println(chanceIndex + " 번째 숫자는 " + nums.get(intChanceIndex - 1) + " 입니다.");
                        chance -= 2;
                        break;
                    } else {
                        System.out.println("자릿수입력을 확인해주세요.");
                    }
                } else {
                    System.out.println("숫자입력을 확인해주세요.");
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
            Loop1:
            while (true) {
                String chanceIndex = sc.nextLine();
                if (chanceIndex.matches("[1-5]+")) {
                    int intChance = Integer.parseInt(chanceIndex);
                    // 입력숫자와 Index 숫자를 비교하여 Up&Down 비교
                    if (nums.size() > intChance - 1) {
                        while (true) {
                            System.out.println("Up & Down 기준 숫자를 입력해주세요.");
                            String standardNum = sc.nextLine();
                            // 입력비교값이 1~9 사이일경우만 진행
                            if (standardNum.matches("[1-9]+") && Integer.parseInt(standardNum) > 0 && Integer.parseInt(standardNum) < 10) {
                                if (Integer.parseInt(standardNum) > nums.get(intChance - 1)) {
                                    System.out.println("DOWN");
                                } else if (Integer.parseInt(standardNum) < nums.get(intChance - 1)) {
                                    System.out.println("UP");
                                } else if (Integer.parseInt(standardNum) == nums.get(intChance - 1)) {
                                    System.out.println("Same");
                                }
                                chance--;
                                break Loop1;
                            } else {
                                System.out.println("1~9의 숫자만 입력해주세요");
                            }
                        }
                    } else {
                        System.out.println("자릿수입력을 확인해주세요.");
                    }
                } else {
                    System.out.println("숫자입력을 확인해주세요.");
                }
            }
        } else {
            System.out.println("가진 찬스횟수가 부족합니다.");
        }
    }

    // 모든 정답 숫자의 합 출력 메소드
    public void getSumAnswer(List<Integer> nums) {
        if (chance >= 1) {
            System.out.println("모든 번호의 합은");
            int sum = nums.stream().mapToInt(num -> num).sum();
            System.out.println(sum + " 입니다.");
            chance--;
        } else {
            System.out.println("가진 찬스횟수가 부족합니다.");
        }
    }

    // 유저가 찬스기능을 활요하는지에 대한 흐름분기 제어
    public void useChance(List<Integer> nums) {
        System.out.println("현재남은 찬스횟수 : " + getChanceNumber());
        System.out.println("찬스를 사용하려면 Y 입력 미사용시 N 입력");
        // 루프 라벨기능 추가
        Loop1:
        while (true) {
            String userSelChance = sc.nextLine();
            // 대소문자 구분없이 비교
            if (userSelChance.equalsIgnoreCase("Y")) {
                while (true) {
                    System.out.println("0. 찬스 사용 중지 1. 정확한 번호 알기(기회 2회 소모) 2. 번호 Up & Down(기회 1회 소모) 3. 모든 번호의 합(기회 1회 소모)");
                    int userSelChanceMenu = sc.nextInt();
                    sc.nextLine();
                    if (userSelChanceMenu == 0) {
                        break Loop1;
                    } else if (userSelChanceMenu == 1) {
                        getIndexNumber(nums);
                        break Loop1;
                    } else if (userSelChanceMenu == 2) {
                        getIndexNumberUpDown(nums);
                        break Loop1;
                    } else if (userSelChanceMenu == 3) {
                        getSumAnswer(nums);
                        break Loop1;
                    } else {
                        System.out.println("0, 1, 2, 3 번중 입력해주세요.");
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

    // 찬스횟수를 다시 충전시켜주는 메소드
    public void refillChance(int difficulty) {
        if (difficulty == 5) {
            chance = 3;
        } else {
            chance = 2;
        }
    }
}