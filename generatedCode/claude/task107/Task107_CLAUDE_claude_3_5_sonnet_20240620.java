package claude.task107;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Task107_CLAUDE_claude_3_5_sonnet_20240620 {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            
            // Look up a DataSource
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDataSource");
            System.out.println("DataSource found: " + ds);
            
            // Look up a custom object
            Object customObj = ctx.lookup("java:comp/env/custom/MyObject");
            System.out.println("Custom object found: " + customObj);
            
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
