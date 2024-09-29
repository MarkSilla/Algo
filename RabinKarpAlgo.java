public class RabinKarpAlgo {
    public final static int d = 256;

    public static void search(String pattern, String text, int q) {
        int m = pattern.length();  
        int n = text.length();    
        int i, j;
        int pHash = 0; 
        int tHash = 0; 
        int h = 1;

        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;

        for (i = 0; i < m; i++) {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }

        for (i = 0; i <= n - m; i++) {
            if (pHash == tHash) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Pattern found at index " + (i + 1)); 
            }

            if (i < n - m) {
                tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;

                if (tHash < 0)
                    tHash = (tHash + q);
            }
        }
    }

    public static void main(String[] args) {
        String text = "I LOVE PROGRAMMING";
        String pattern = "PROG";
        int q = 101; 

        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        search(pattern, text, q);
    }
}

