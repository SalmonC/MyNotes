package study.part4;

import java.util.*;

public class DouDiZhu {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>(Arrays.asList("♠", "♥", "♣", "♦"));
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,0,11,12,13);
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            points.add(i);
        }
        Collections.shuffle(points);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> bottom = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            if(0<=i && i<=16) {
                list1.add(points.get(i));
            } else if(17<=i && i<=33) {
                list2.add(points.get(i));
            } else if(34<=i && i<=50) {
                list3.add(points.get(i));
            } else {
                bottom.add(points.get(i));
            }
        }
        Player p1 = new Player(list1, "玩家1");
        Player p2 = new Player(list2, "玩家2");
        Player p3 = new Player(list3, "玩家3");
        Player bot = new Player(bottom, "底牌");
        print(p1);
        print(p2);
        print(p3);
        print(bot);
    }
    static class Player{
        List<Integer> cards;
        String name;
        Player(List<Integer> list, String name){this.cards = list; this.name = name;}
    }
    static void print(Player player){
        player.cards.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(player.name+"的牌是:");
        for(int i : player.cards){
            if(i == 0)sb.append(" 大王");
            else if(i == 1)sb.append(" 小王");
            else{
                if((i-2) % 4 == 0)sb.append(" ♠");
                if((i-2) % 4 == 1)sb.append(" ♥");
                if((i-2) % 4 == 2)sb.append(" ♣");
                if((i-2) % 4 == 3)sb.append(" ♦");
                if((i-2) / 4 == 0)sb.append("2");
                else if((i-2) / 4 == 1)sb.append("A");
                else if((i-2) / 4 == 2)sb.append("K");
                else if((i-2) / 4 == 3)sb.append("Q");
                else if((i-2) / 4 == 4)sb.append("J");
                else sb.append(15 - (i-2) / 4 + "");
            }
        }
        System.out.println(sb.toString());
    }
}

