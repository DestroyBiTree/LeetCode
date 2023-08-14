package easy;

public class MySqrt {
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrtMthod(144));
    }
    public int mySqrtMthod(int x) {
    int l = 0, r = x, ans = -1;
    while (l <= r)
    {
        int mid = l + (r - l) / 2;
        if((long)mid * mid <= x)
        {
            ans = mid;
            l = mid + 1;
        }
        else
            r = mid - 1;
    }

        return ans;
    }

}
