package medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String strs[] = new String[]{"hello", "nintendo", "sony", "sega"};
        for (String s : strs){
            char[] arrys = s.toCharArray();
            String key = new String(arrys);
//            String keys = "adf";
            System.out.println(arrys);
        }
    }


}
