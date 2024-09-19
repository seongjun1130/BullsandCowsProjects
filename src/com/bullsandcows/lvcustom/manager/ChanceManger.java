package com.bullsandcows.lvcustom.manager;

import java.util.List;
import java.util.Scanner;

public class ChanceManger {
    private static int chance = 1;
    private Scanner sc = new Scanner(System.in);

    public void getIndexNumber(List<Integer> nums) {
        if (chance > 0) {
            System.out.println("알고 싶은 자리의 숫자를 입력해주세요");
            while (true) {
                int chanceIndex = sc.nextInt();
                if (nums.size() > chanceIndex - 1) {
                    System.out.println(chanceIndex + " 번째 숫자는 " + nums.get(chanceIndex - 1) + " 입니다.");
                    chance--;
                    break;
                } else {
                    System.out.println("자리수 입력을 확인해주세요.");
                    sc.nextLine();
                }
            }
        } else {
            System.out.println("가진 찬스횟수가 없습니다.");
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
            chance = 2;
        } else {
            chance = 1;
        }
    }
}
