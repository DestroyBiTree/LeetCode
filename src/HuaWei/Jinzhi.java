package HuaWei;

import java.util.*;

public class Jinzhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String hex = "";
        for (int i = 0; i < (n + 15) / 16; i++) {
            hex += String.format("%04X", scanner.nextShort());
        }
        int[] holes = new int[n];
        for (int i = 0; i < n; i++) {
            holes[i] = hex.charAt(i) - '0';
        }
        int[][] schemes = getCompensationSchemes(holes);
        System.out.println(schemes.length);
        for (int[] scheme : schemes) {
            System.out.println(scheme[0]);
            for (int i = 0; i < n; i++) {
                System.out.print((scheme[1] + i < 0 || scheme[1] + i >= n || holes[i] == 0 || holes[scheme[1] + i] == 1) ? holes[i] : 1);
            }
            System.out.println();
        }
    }

    private static int[][] getCompensationSchemes(int[] holes) {
        int n = holes.length;
        List<int[]> schemes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (holes[i] == 0) {
                int[] scheme1 = getScheme(holes, i, true);
                if (scheme1 != null) {
                    schemes.add(scheme1);
                }
                int[] scheme2 = getScheme(holes, i, false);
                if (scheme2 != null) {
                    schemes.add(scheme2);
                }
            }
        }
        int[][] result = new int[schemes.size()][2];
        for (int i = 0; i < schemes.size(); i++) {
            result[i] = schemes.get(i);
        }
        Arrays.sort(result, (a, b) -> (a[0] == b[0] ? Integer.compare(Math.abs(a[1]), Math.abs(b[1])) : Integer.compare(a[0], b[0])));
        return result;
    }

    private static int[] getScheme(int[] holes, int index, boolean direction) {
        int n = holes.length;
        int[] holes2 = Arrays.copyOf(holes, n);
        int shift = 0;
        int count = 0;
        int i = index;
        int lastShift = 0;
        while (i >= 0 && i < n) {
            if (holes2[i] == 0) {
                if (i + shift < 0 || i + shift >= n || holes2[i + shift] == 1) {
                    return null;
                }
                holes2[i + shift] = -1;
                count++;
                lastShift = shift;
                shift = (direction ? shift + 1 : shift - 1);
            }
            i = (direction ? i + 1 : i - 1);
        }
        if (count == 0) {
            return null;
        }
        int[] scheme = new int[2];
        scheme[0] = direction ? lastShift + 1 : -(lastShift + 1);
        scheme[1] = index - lastShift;
        return scheme;
    }
}
