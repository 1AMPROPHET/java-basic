package doudizhu3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {

    // 准备牌
    // 静态代码块，随着类的加载而加载，只执行一次
    static ArrayList<String> list = new ArrayList<>();
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 牌盒
        for (String n : number) {
            for (String c : color) {
                list.add(c + n);
            }
        }
        list.add(" JOKER");
        list.add(" joker");

        // 指定牌的价值
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("joker", 50);
        hm.put("JOKER", 100);
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
        order(lord);
        order(player1);
        order(player2);
        order(player3);

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

    public void order(ArrayList<String> list) {
        list.sort((o1, o2) -> {
            // o1: 表示当前要插入到有序序列中的牌
            // o2：表示已经在有序列表中存在的牌

            String color1 = o1.substring(0, 1);
            int value1 = getValue(o1);

            String color2 = o2.substring(0, 1);
            int value2 = getValue(o2);

            int i = value1 - value2;

            return i == 0 ? color1.compareTo(color2) : i;
        });
    }

    public int getValue(String poker) {
        // 获取数字
        String number = poker.substring(1);
        if (hm.containsKey(number)) {
            return hm.get(number);
        } else {
            return Integer.parseInt(number);
        }
    }
}
