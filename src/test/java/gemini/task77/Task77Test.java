package gemini.task77;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class Task77Test {

    private Task77_GEMINI_gemini_1_5_pro_001 ftpTask;

    @Mock
    private FTPClient mockFtpClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ftpTask = new Task77_GEMINI_gemini_1_5_pro_001();
    }

    @Test
    public void testDownloadFile_Success() throws IOException {
        // Arrange
        String hostname = "localhost";
        String username = "testuser";
        String password = "password";
        String remoteFilename = "testfile.txt";

        // Mocking FTPClient methods
        InputStream mockInputStream = mock(InputStream.class);
        OutputStream mockOutputStream = new ByteArrayOutputStream();

        // Simulate FTPClient methods
        when(mockFtpClient.isConnected()).thenReturn(true);
        when(mockFtpClient.retrieveFileStream(remoteFilename)).thenReturn(mockInputStream);
        when(mockFtpClient.completePendingCommand()).thenReturn(true);
        when(mockInputStream.read(Mockito.any(byte[].class))).thenReturn(-1); // End of stream

        // Mock connection and login
        doNothing().when(mockFtpClient).connect(hostname);
        when(mockFtpClient.login(username, password)).thenReturn(true);

        // Act
        ftpTask.main(new String[] { hostname, username, password, remoteFilename });

        // Assert
        verify(mockFtpClient).connect(hostname);
        verify(mockFtpClient).login(username, password);
        verify(mockFtpClient).retrieveFileStream(remoteFilename);
        verify(mockFtpClient).completePendingCommand();
    }

    @Test
    public void testDownloadFile_Failure() throws IOException {
        // Arrange
        String hostname = "localhost";
        String username = "testuser";
        String password = "password";
        String remoteFilename = "testfile.txt";

        // Mocking FTPClient methods for failure scenario
        InputStream mockInputStream = mock(InputStream.class);
        OutputStream mockOutputStream = new ByteArrayOutputStream();

        // Simulate FTPClient methods for failure scenario
        when(mockFtpClient.isConnected()).thenReturn(true);
        when(mockFtpClient.retrieveFileStream(remoteFilename)).thenReturn(mockInputStream);
        when(mockFtpClient.completePendingCommand()).thenReturn(false);

        // Mock connection and login
        doNothing().when(mockFtpClient).connect(hostname);
        when(mockFtpClient.login(username, password)).thenReturn(true);

        // Act
        ftpTask.main(new String[] { hostname, username, password, remoteFilename });

        // Assert
        verify(mockFtpClient).connect(hostname);
        verify(mockFtpClient).login(username, password);
        verify(mockFtpClient).retrieveFileStream(remoteFilename);
        verify(mockFtpClient).completePendingCommand();
    }

    @Test
    public void testInvalidArguments() {
        // Arrange
        String[] invalidArgs = new String[] {}; // Empty args

        // Act & Assert
        // Should print usage message and return without doing any FTP operations
        assertDoesNotThrow(() -> ftpTask.main(invalidArgs));
    }
}
