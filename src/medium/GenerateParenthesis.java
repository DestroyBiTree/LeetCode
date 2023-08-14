package medium;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> outList = generateParenthesis.generateParenthesisMe(2);
        for (String s : outList)
            System.out.println(s);

    }
    StringBuilder str = new StringBuilder();

    public List<String> generateParenthesisMe(int n) {
        List<String> list = new ArrayList<>();
        backTracking(n,list,0,0,"");
        return list;
    }


    public void backTracking(int n, List<String> list, int left, int right, String str){
        if (left < right){
            return;
        }

        if (left == right && left == n){
            list.add(str);
        }

        if (left < n){
            backTracking(n, list, left + 1, right, str + "(");
        }

        if (right < left){
            backTracking(n, list, left, right + 1,str + ")");
        }
    }
}
