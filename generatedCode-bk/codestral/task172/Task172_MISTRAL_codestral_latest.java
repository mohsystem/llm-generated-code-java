package codestral.task172;

public class Task172_MISTRAL_codestral_latest {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }
}