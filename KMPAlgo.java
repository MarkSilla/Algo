public class KMPAlgo {

    private static int[] computeLPSArray(String pattern) {
        int length = 0;
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;  
        
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

  
    public static void KMPSearch(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0; 
        int j = 0; 

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                System.out.println("Pattern found at index: " + (i - j + 1));
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "kokokorokororokoro";
        String pattern = "kokoro";
        
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        KMPSearch(text, pattern);
    }
}
