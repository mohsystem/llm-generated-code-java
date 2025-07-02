package claude.task107;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class InitialContextFactoryMock extends InitialContext {
    private static Context mockContext;

    public static void setMockContext(Context context) {
        mockContext = context;
    }

    public InitialContextFactoryMock() throws NamingException {
        super(true); // bypass the default constructor
    }

    @Override
    public Object lookup(String name) throws NamingException {
        return mockContext.lookup(name);
    }
}
