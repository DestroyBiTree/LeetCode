package programmercarl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return null;
        }
        HashSet<Integer> res = new HashSet<>();
        if (len1 < len2) {
            HashSet<Integer> set1 = new HashSet<>();
            for (int i = 0; i < len1; i++) {
                set1.add(nums1[i]);
            }
            for (int i = 0; i < len2; i++) {
                if (set1.contains(nums2[i])) {
                    res.add(nums2[i]);
                }
            }
        }
        else {
            HashSet<Integer> set2 = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                set2.add(nums2[i]);
            }
            for (int i = 0; i < len1; i++) {
                if (set2.contains(nums1[i])){
                    res.add(nums1[i]);
                }
            }
        }
        int i = 0;
        int []intersection = new int[res.size()];
        for(Integer integer : res) {
            intersection[i++] = integer;
        }

        return intersection;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] nums = s.split(",");
        int [] nums2 = new int[nums.length];
        int i = 0;
        for (String num : nums) {
            nums2[i++] = Integer.parseInt(num);
        }

        String t = scanner.nextLine();
        String[] nums3 = t.split(",");
        int [] nums4 = new int[nums3.length];
        int k = 0;
        for (String num : nums3) {
            nums4[k++] = Integer.parseInt(num);
        }

        System.out.println(Arrays.toString(intersection(nums2, nums4)));

    }
}
