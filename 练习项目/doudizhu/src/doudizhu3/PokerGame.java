package doudizhu1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

    // 准备牌
    // 静态代码块，随着类的加载而加载，只执行一次
    static ArrayList<String> list = new ArrayList<>();

    static {
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        // 牌盒
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add("JOKER");
        list.add("joker");

        // 指定牌的价值

    }
    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        // 四个集合，包括底牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if (i <= 2) {
                lord.add(poker);
            }
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }

        // 排序


        // 看牌
        lookPoker("bottom", lord);
        lookPoker("P1", player1);
        lookPoker("P2", player2);
        lookPoker("P3", player3);
    }

    public void lookPoker(String name, ArrayList<String> list) {
        System.out.print(name + ": ");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
