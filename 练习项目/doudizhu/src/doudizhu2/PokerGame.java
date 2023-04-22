package doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    // 牌盒map
    // 只需要把牌跟序号产生对应关系就可以了
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // 序号
        int serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }

        hm.put(serialNumber, "joker");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "JOKER");
        list.add(serialNumber);

        System.out.println(hm);
    }

    public PokerGame () {
        Collections.shuffle(list);

        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);

            if (i <= 2) {
                lord.add(serialNumber);
            }

            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }

        System.out.println(lord);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);

        lookPoker("Bottom", lord);
        lookPoker("P1", player1);
        lookPoker("P2", player2);
        lookPoker("P3", player3);
    }

    public void lookPoker(String name, TreeSet<Integer> ts) {
        for (int serialNumber : ts) {
            String poker = hm.get(serialNumber);
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
