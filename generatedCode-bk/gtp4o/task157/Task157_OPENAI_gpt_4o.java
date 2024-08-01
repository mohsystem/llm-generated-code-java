package gtp4o.task157;

public class Task157_OPENAI_gpt_4o {
    public static void main(String[] args) {
        // Allocate memory for an integer
        Integer myVar = new Integer(42);
        System.out.println("Java: Value = " + myVar);

        // Deallocate memory
        myVar = null;
        System.gc(); // Request garbage collection
    }
}