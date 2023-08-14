package meidi;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        String arr[] = new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        String arrs [] = dirReduc(arr);
        System.out.println(Arrays.toString(arrs));
    }
    public static String[] dirReduc (String[] arr)  {
        Stack<String> stack= new Stack<String>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty()){
                if (arr[i] == "WEST" && stack.peek() == "EAST" ||
                        arr[i] == "EAST" && stack.peek() == "WEST") {
                    stack.pop();
                }
                else if (arr[i] == "NORTH" && stack.peek() == "SOUTH" ||
                        arr[i] == "SOUTH" && stack.peek() == "NORTH") {
                    stack.pop();
                }
                else {
                    stack.push(arr[i]);
                }
            }
            else {
                stack.push(arr[i]);
            }
        }

        String res[] = new String[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
