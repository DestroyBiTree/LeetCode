package mhy;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            String s = in.nextLine();
        String t = in.nextLine();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        HashMap<Character,Integer> mapS = new HashMap<Character,Integer>();
        HashMap<Character,Integer> mapT = new HashMap<Character,Integer>();

        for (int i = 0; i < chars.length; i++){
            if (chars[i] == 'm' || chars[i] == 'h'|| chars[i] == 'y'){
                continue;
            }
            else {
                if(!mapS.containsKey(chars[i])) {mapS.put(chars[i],1);}
                else {
                    mapS.put(chars[i],mapS.get(chars[i] + 1));
                }
            }
        }

        for (int i = 0; i < chart.length; i++){
            if (chart[i] == 'm' || chart[i] == 'h'|| chart[i] == 'y'){
                continue;
            }
            else {
                if(!mapT.containsKey(chart[i])) {mapT.put(chart[i],1);}
                else {
                    mapT.put(chart[i],mapT.get(chart[i] + 1));
                }
            }
        }
        for(Map.Entry<Character,Integer> entry : mapS.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " +value);
        }

        for(Map.Entry<Character,Integer> entry : mapT.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " " +value);
        }

        }



}
