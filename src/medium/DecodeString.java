package medium;

import java.util.Stack;
//394.字符串解码
public class DecodeString {
    public static void main(String[] args) {

    }
    public String decodeStringMethod(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> kstack = new Stack<>();
        Stack<StringBuilder> restack = new Stack<>();

        for (char c : s.toCharArray()){
            //碰到左括号记录当前的k和res然后清零
            if (c == '['){
                kstack.push(k);
                restack.push(res);
                k = 0;
                res = new StringBuilder();
            }
            else if (c == ']'){
                //k出栈
                int curk = kstack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curk ; i++){
                    temp.append(res);
                }

                //与括号外的字符串进行合并
                res = restack.pop().append(temp);
            }
            else if (c >= '0' && c <= '9'){
                k = c - '0' + k * 10;
            }
            else{
                //如果是字母直接添加
                res.append(c);
            }
        }
        return res.toString();
    }
}
