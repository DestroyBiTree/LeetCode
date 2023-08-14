package easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
    PlusOne plusOne = new PlusOne();
//    plusOne.plusOne(new int[]{1, 2, 3});
    System.out.println(Arrays.toString(plusOne.plusOne(new int[]{2,3,9,9,9})));
    }
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int count = 0;

        for (int i = 0;i < digits.length;i++)
        {
            if (digits[i] == 9)
                count++;
        }

        if(count == length)
        {
            int newArr[] = new int[length+1];
            newArr[0] = 1;
            return newArr;
        }


        if (digits[length - 1] == 9)
        {
            int flag = length - 1;
            while (digits[flag] == 9)
            {
                digits[flag] = 0;
                flag--;
            }
            digits[flag] += 1;

        }

        else {
            digits[length - 1] += 1;
        }
        return digits;

    }

}
