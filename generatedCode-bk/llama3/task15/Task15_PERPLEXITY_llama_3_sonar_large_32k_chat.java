package llama3.task15;

public class Task15_PERPLEXITY_llama_3_sonar_large_32k_chat {
    public static void main(String[] args) {
        int floors = 6;
        String[] tower = new String[floors];
        for (int i = 0; i < floors; i++) {
            String floor = "";
            for (int j = 0; j < floors - i - 1; j++) {
                floor += " ";
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                floor += "*";
            }
            for (int j = 0; j < floors - i - 1; j++) {
                floor += " ";
            }
            tower[i] = floor;
        }
        for (String floor : tower) {
            System.out.println(floor);
        }
    }
}