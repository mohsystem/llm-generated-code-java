package gtp4o.task68;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;
import java.util.Scanner;

public class Task68_OPENAI_gpt_4o {
    public static void main(String[] args) {
        String domainComponent = args[0];
        String username = args[1];
        
        String url = "ldap://localhost:389";
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        
        try {
            DirContext ctx = new InitialDirContext(env);
            String searchFilter = String.format("(sAMAccountName=%s)", username);
            String searchBase = String.format("DC=%s,DC=com", domainComponent);
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, controls);
            while (answer.hasMore()) {
                SearchResult result = answer.next();
                Attributes attrs = result.getAttributes();
                System.out.println(attrs);
            }
            ctx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}