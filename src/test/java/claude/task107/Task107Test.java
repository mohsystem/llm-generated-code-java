package claude.task107;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class Task107Test {

    private Context mockContext;

    @BeforeEach
    public void setUp() throws Exception {
         mockContext = mock(Context.class);
        InitialContext initialContext = mock(InitialContext.class);
        InitialContextFactoryMock.setMockContext(mockContext);
    }

    @Test
    public void testValidJndiLookup() throws Exception {
        DataSource mockDataSource = mock(DataSource.class);
        Object customObject = new Object();

        when(mockContext.lookup("java:comp/env/jdbc/MyDataSource")).thenReturn(mockDataSource);
        when(mockContext.lookup("java:comp/env/customObject")).thenReturn(customObject);

        Context ctx = new InitialContext();
        assertEquals(mockDataSource, ctx.lookup("java:comp/env/jdbc/MyDataSource"));
        assertEquals(customObject, ctx.lookup("java:comp/env/customObject"));
    }

    @Test
    public void testInvalidJndiNameThrowsException() throws Exception {
        when(mockContext.lookup("java:comp/env/invalid")).thenThrow(new NamingException("Invalid name"));

        Context ctx = new InitialContext();
        assertThrows(NamingException.class, () -> ctx.lookup("java:comp/env/invalid"));
    }

    @Test
    public void testInjectionAttemptRejected() throws Exception {
         String maliciousName = "ldap://malicious.com/Object";

        when(mockContext.lookup(maliciousName)).thenThrow(new NamingException("Potential injection"));

        Context ctx = new InitialContext();
        assertThrows(NamingException.class, () -> ctx.lookup(maliciousName));
    }
}
