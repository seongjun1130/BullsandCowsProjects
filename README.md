#     BullsandCowsProject 📝
이 프로젝트는 숫자 야구 게임을 객체 지향 프로그래밍(OOP)의 원칙에 따라 설계하고 구현한 것입니다. 사용자는 임의로 생성된 숫자를 맞추는 게임으로, 각 라운드마다 입력한 숫자와 정답 사이의 일치 정도를 알려줍니다. 이 게임은 코드의 재사용성, 유지보수성, 그리고 확장성을 고려하여 OOP의 원칙을 충실히 반영했습니다.

해당 프로그램은 하단 구현 가이드라인에 초점을 맞추어 구현하였습니다.

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fseongjun1130%2FBullsandCowsProjects&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://github.com/seongjun1130)

## 목차
- [개요](#개요)
- [기능 구현 가이드라인](#기능-구현-가이드라인)
- [프로그램 기능구현표](#프로그램-기능구현표)
- [프로그램 플로우차트](#프로그램-플로우차트)
- [프로그램 동작화면](#프로그램-동작-화면)
- [아키텍쳐](#architecture)

## 개요
- 프로젝트 이름 : BullsandCowsProjects
- 프로젝트 지속기간 : 2024.09.12 ~ 2024.09.24
- 개발언어 : JAVA
- 멤버 : 조성준

## 기능 구현 가이드라인
<details>
<summary>접기/펼치기</summary>
  
![image](https://github.com/user-attachments/assets/77cc4908-dcad-4744-8b1a-e7d12c8c56f2)
![image-1](https://github.com/user-attachments/assets/01456cec-13f4-40d9-881e-920efe392f67)
![image](https://github.com/user-attachments/assets/ef87ab24-367e-4adc-a015-bc1dc34bee8a)
![image-1](https://github.com/user-attachments/assets/5f99b01c-18a6-46a1-802c-aae2ce2371d9)
![image](https://github.com/user-attachments/assets/fdc61479-0683-4159-8324-fa73838b3aea)



</details>

## 프로그램 기능구현표
![image](https://github.com/user-attachments/assets/989e6f32-e21b-48ee-a017-5d31418355f0)


## 프로그램 플로우차트
- ### Main Flow
![image-1](https://github.com/user-attachments/assets/1de5916f-d1ef-4fac-8bc2-6318202ac046)

- ### Chance Flow
![image](https://github.com/user-attachments/assets/3a0e038f-7085-44c7-97bd-4ba9767dd262)

## 주요기능
- 랜덤 숫자 생성: 게임이 시작되면 시스템이 임의의 숫자 조합을 생성하여 정답으로 사용합니다.
- 입력 검증 : 사용자가 입력한 숫자를 검증하고, 자릿수와 숫자의 일치 여부에 따라 스트라이크와 볼의 개수를 알려줍니다.
- 게임 기록 관리: 각 라운드의 결과와 게임 진행 상황을 기록하여 사용자가 게임의 경과를 확인할 수 있도록 합니다.
- 찬스기능 제공 : 유저가 가지고 있는 찬스점수를 소모하여 다양한 힌트를 통해 숫자를 찾아낼 수 있습니다.


## 프로그램 동작 화면
<details>
<summary>접기/펼치기</summary>
  
![image](https://github.com/user-attachments/assets/6b570178-16d0-4881-ae53-558df64a48cc)![image-1](https://github.com/user-attachments/assets/f266d22b-c218-4ea1-912e-8d6bef6e269a)![image](https://github.com/user-attachments/assets/30347c91-ba75-4758-bbad-677687031247)






</details>

## Stacks
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
## Communication
- ### Main blog
https://velog.io/@lionjojo/posts
- ### project troubleshooting
[https://velog.io/@lionjojo/JAVA-%EA%B3%84%EC%82%B0%EA%B8%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85](https://velog.io/@lionjojo/JAVA-%EC%88%AB%EC%9E%90%EC%95%BC%EA%B5%AC%EA%B2%8C%EC%9E%84-%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85)

## Architecture
```
📦 
├─ .gitignore
├─ .idea
│  ├─ .gitignore
│  ├─ material_theme_project_new.xml
│  ├─ misc.xml
│  ├─ modules.xml
│  ├─ uiDesigner.xml
│  └─ vcs.xml
├─ BullsandCowsProjects.iml
├─ README.md
└─ src
   └─ com
      └─ bullsandcows
         ├─ lv1 : Lv.1 필수기능구현 숫자야구
         │  ├─ Main.java : main 메소드 실행 Class
         │  └─ manager : 각 기능별 Manager Class 집합 패키지
         │     ├─ DisplayManger.java : 콘솔 출력 담당 Class
         │     ├─ GameJudgeManager.java : 게임 승패 및 게임 결과(Strike, Ball) 체크 Class
         │     ├─ NumberUtilManager.java : 정답숫자 생성, 유저 입력 숫자 유효성 검사 Class
         │     └─ ServiceManager.java : 게임 전체 흐름 담당 Class
         ├─ lv2 : Lv.2 필수기능구현 숫자야구
         │  ├─ Main.java
         │  ├─ MainmenuType.java : MainMenu Enum Class
         │  └─ manager
         │     ├─ DisplayManger.java
         │     ├─ GameJudgeManager.java
         │     ├─ NumberUtilManager.java
         │     └─ ServiceManager.java
         ├─ lv3 : Lv.3 필수기능구현 숫자야구
         │  ├─ Main.java
         │  ├─ MainMnuType.java
         │  └─ manager
         │     ├─ DisplayManger.java
         │     ├─ GameJudgeManager.java
         │     ├─ NumberUtilManager.java
         │     └─ ServiceManager.java
         ├─ lv4 : Lv.4 필수기능구현 숫자야구
         │  ├─ Main.java
         │  ├─ MainMnuType.java
         │  └─ manager
         │     ├─ DisplayManger.java
         │     ├─ GameJudgeManager.java
         │     ├─ NumberUtilManager.java
         │     └─ ServiceManager.java
         └─ lvcustom : 찬스 추가 기능구현 숫자야구
            ├─ ChanceMainMenuType.java : 찬스메뉴 Enum Class
            ├─ Main.java
            ├─ MainMenuType.java
            └─ manager
               ├─ ChanceManger.java : 찬스 추가 기능 담당 Class
               ├─ DisplayManger.java
               ├─ GameJudgeManager.java
               ├─ NumberUtilManager.java
               └─ ServiceManager.java
```
©generated by [Project Tree Generator](https://woochanleee.github.io/project-tree-generator)
