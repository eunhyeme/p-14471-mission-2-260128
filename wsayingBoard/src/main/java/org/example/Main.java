package org.example;

import java.util.Scanner;


public class Main {

    public static void main(String[] args){

        // 명언객체 관리 매니저 선언
        WsayingManager wsayListManager= new WsayingManager();

        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        do {
            System.out.print("명령)");
            String command = sc.nextLine();

            // 명령 예시: 수정?id=1
            // 위 명령에서 ? 와 = 를 구분자로하여
            // 코드에선 com[0],com1[0],com2[0] 으로 명칭한다

            String[] com=command.split("\\?");
            switch (com[0]) {
                case "등록" -> wsayListManager.create();
                case "목록" -> wsayListManager.read();
                case "수정" ->wsayListManager.update(com);
                case "삭제" -> wsayListManager.delete(com);
                case "빌드" -> {continue;
                    //아직 구현 덜 함
                }
                case "종료" -> {
                    return;
                }
                default -> {
                    System.out.println("[ 등록 | 목록 | 수정 | 삭제 | 빌드 ] -- 택1");
                }
            }
        }while(true);



    }


}

