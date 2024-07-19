package codestral.task31;

public class Task31_MISTRAL_codestral_latest {
    public static String makeComplement(String dna) {
        StringBuilder result = new StringBuilder();
        for (char c : dna.toCharArray()) {
            switch (c) {
                case 'A':
                    result.append('T');
                    break;
                case 'T':
                    result.append('A');
                    break;
                case 'C':
                    result.append('G');
                    break;
                case 'G':
                    result.append('C');
                    break;
            }
        }
        return result.toString();
    }
}