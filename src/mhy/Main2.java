package mhy;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int k = 0; k < n;k++){
            in.nextLine();
            String s = in.nextLine();
            String t = in.next();
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
            if (!isEqual(mapS,mapT)) {
                System.out.println("No");
            }
            else{
                int i = 0, j = 0;
                while (i < chars.length && j < chart.length){
                    if (chars[i] == 'm'){
                        return;
                    }
                }
            }

        }


    }

    public static  boolean isEqual(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        if (map1.size() != map2.size()){
            return false;
        }
        for(Map.Entry<Character,Integer> entry : map1.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(!map2.containsKey(key) || !map2.get(key).equals(value)){
                return false;
            }
        }
        return true;
    }
}
