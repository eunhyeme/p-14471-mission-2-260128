package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class WsayingManager {
    public int listCount=0;
    public List<Wsaying> wsayList = new ArrayList<>();

    void create() {
        Wsaying wsaying = new Wsaying();
        Scanner sc = new Scanner(System.in);

        System.out.print("명언 : ");
        wsaying.setQuote(sc.nextLine());

        System.out.print("작가 : ");
        wsaying.setWriter(sc.nextLine());

        wsayList.add(wsaying);
        wsaying.setNum(++listCount);

        System.out.printf("%d번 명언이 등록되었습니다.\n", listCount);

    }

    void read() {

        System.out.println("번호 / 작가 / 명언 ");
        System.out.println("-------------------------");

        for (int i = wsayList.size() - 1; i >= 0; i--) {
            System.out.printf("%s / %s / %s\n", wsayList.get(i).getNum(), wsayList.get(i).getWriter(), wsayList.get(i).getQuote());
        }

    }

    void update(String com[])
    {
        if(com.length==2) {
            String[] com1 = com[1].split("=");
            if (com1.length == 2)
            {

                String com2=com1[1];
                Scanner sc = new Scanner(System.in);

                // id값 유효성 검사
                Wsaying wsay = findById(Integer.parseInt(com2));

                if(wsay!=null) {
                    System.out.printf("명언(기존) : %s\n", wsay.getQuote());
                    System.out.print("명언 : ");
                    wsay.setQuote(sc.nextLine());

                    System.out.printf("작가(기존) : %s\n", wsay.getWriter());
                    System.out.print("작가 : ");
                    wsay.setWriter(sc.nextLine());
                    System.out.printf("%d번 명언이 수정되었습니다.\n",wsay.getNum());

                }
                else
                    System.out.printf("%s번 명언은 존재하지 않습니다.\n",com2);



            }
            else
                System.out.println("\"수정?id=1\" 형식으로 작성해주세요.('=' 이하가 없음)");

        }
        else
            System.out.println("\"수정?id=1\" 형식으로 작성해주세요.('?' 이하가 없음)");

    }

    void delete(String com[])
    {
                    if(com.length==2) {
                        String[] com1 = com[1].split("=");
                        if (com1.length == 2)
                        {
                            String com2=com1[1];

                            // 인덱스값 유효성 검사 꼭하기
                            Wsaying wsay = findById(Integer.parseInt(com2));
                            if(wsay!=null) {
                                wsayList.remove(wsay);
                                System.out.printf("%s번 명언이 삭제되었습니다.\n",com2);

                            }
                            else
                                System.out.printf("%s번 명언은 존재하지 않습니다.\n",com2);

                        }
                        else
                            System.out.println("\"수정?id=1\" 형식으로 작성해주세요.('=' 이하가 없음)");

                    }
                    else
                        System.out.println("\"삭제?id=1\" 형식으로 작성해주세요.('?' 이하가 없음)");
                }

    void build() throws IOException{
//        BufferedOutputStream bs=null;
//        try {
//            bs=new BufferedOutputStream(new FileOutputStream())
//        }
//
    }

    public Wsaying findById(int id){
        for(Wsaying w:wsayList){

            if(w.getNum()==id)
                return w;
        }
        return null;
    }

}



