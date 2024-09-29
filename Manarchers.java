public class Manarchers {
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("^#");
        for (char c : s.toCharArray()) sb.append(c).append('#');
        sb.append('$');
        return sb.toString();
    }

    public static String longestPalindromicSubstring(String s) {
        String T = preprocess(s);
        int n = T.length(), C = 0, R = 0;
        int[] P = new int[n];

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;
            if (R > i) P[i] = Math.min(R - i, P[mirror]);

            while (T.charAt(i + P[i] + 1) == T.charAt(i - P[i] - 1)) P[i]++;

            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "babadsacomputer";
        System.out.println("Longest Palindromic Substring: " + longestPalindromicSubstring(s));
    }
}
