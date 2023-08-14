package easy;

public class ClimbStairs {
    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climb(45));
    }

    public int climb(int x){
        int memo[]= new int[x + 1];
        return climbMemo(x,memo);
    }

    public int climbMemo(int x,int memo[]){
        if (memo[x] > 0)
        {
            return memo[x];
        }
        if (x == 1) {
            memo[x] = 1;
        }else if(x == 2){
            memo[x] = 2;
        }
        else {
            memo[x] = climbMemo(x - 1,memo) + climbMemo(x-2,memo);
        }
        return memo[x];

    }
}
