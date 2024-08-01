package codestral.task107;

import javax.naming.*;
import javax.naming.directory.*;

public class Task107_MISTRAL_codestral_latest {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            Object obj = ctx.lookup("java:comp/env/jdbc/MyDB");
            System.out.println("Object found: " + obj);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}