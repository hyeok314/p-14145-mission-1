package com.back.src.main.java.com.back;

import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int lastId = 0;
    WiseSaying[] wiseSayings = new WiseSaying[100];
    int wiseSayingsLastIndex = -1;

    void run() {
        System.out.println("== 명언 앱 ==");

        while(true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if (cmd.equals("종료")) break;

            if(cmd.equals("목록")) actionList();

            if(cmd.equals("등록")) actionWrite();

        }
        sc.close();
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        WiseSaying[] forListWiseSayings = findForList();

        for (WiseSaying wiseSaying : forListWiseSayings) {
            System.out.printf("%d. %s/ %s\n", wiseSaying.id, wiseSaying.author, wiseSaying.content);

        }
    }

    void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = write(content, author);

        System.out.println(wiseSaying.id + "번 명연이 등록되었습니다.");
    }

    // 내부 로직
    int getSize() {
        return wiseSayingsLastIndex + 1;
    }

    WiseSaying[] findForList() { // 목록 간편화
        WiseSaying[] forListWiseSayings = new WiseSaying[getSize()];

        int forListWiseSayingsIndex = -1;

        for(int i=wiseSayingsLastIndex; i >= 0; i--) {
            forListWiseSayings[++forListWiseSayingsIndex] = wiseSayings[i];
        }

        return forListWiseSayings;
    }


    WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = ++lastId;
        wiseSaying.content = content;
        wiseSaying.author = author;
        wiseSayings[++wiseSayingsLastIndex] = wiseSaying;

        return wiseSaying;
    }



}
