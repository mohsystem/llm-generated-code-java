package claude2.task31;

public class Task31_CLAUDE_claude_3_5_sonnet_20240620 {
    public static String makeComplement(String dna) {
        StringBuilder complement = new StringBuilder();
        for (char c : dna.toCharArray()) {
            switch (c) {
                case \'A\':
                    complement.append(\'T\');
                    break;
                case \'T\':
                    complement.append(\'A\');
                    break;
                case \'C\':
                    complement.append(\'G\');
                    break;
                case \'G\':
                    complement.append(\'C\');
                    break;
            }
        }
        return complement.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeComplement("ATTGC")); // Output: TAACG
        System.out.println(makeComplement("GTAT"));  // Output: CATA
    }
}
