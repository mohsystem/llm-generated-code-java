package llama3.task58;

public class Task58_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static boolean xo(String str) {
        int xCount = 0;
        int oCount = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'x') xCount++;
            if (c == 'o') oCount++;
        }
        return xCount == oCount;
    }

    public static void main(String[] args) {
        System.out.println(xo("ooxx")); // true
        System.out.println(xo("xooxx")); // false
        System.out.println(xo("ooxXm")); // true
        System.out.println(xo("zpzpzpp")); // true
        System.out.println(xo("zzoo")); // false
    }
}