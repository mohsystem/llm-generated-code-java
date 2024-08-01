package gtp4o.task58;

public class Task58_OPENAI_gpt_4o {
    public static void main(String[] args) {
        System.out.println(XO("ooxx"));
        System.out.println(XO("xooxx"));
        System.out.println(XO("ooxXm"));
        System.out.println(XO("zpzpzpp"));
        System.out.println(XO("zzoo"));
    }

    public static boolean XO(String str) {
        long countX = str.chars().filter(ch -> ch == 'x' || ch == 'X').count();
        long countO = str.chars().filter(ch -> ch == 'o' || ch == 'O').count();
        return countX == countO;
    }
}