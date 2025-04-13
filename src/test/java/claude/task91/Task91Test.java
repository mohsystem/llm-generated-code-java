package claude.task91;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Task91Test {

    @Test
    public void testParseDNSQuery() {
        // Valid DNS query for "example.com"
        byte[] query = new byte[] {
                0x12, 0x34,             // ID
                0x01, 0x00,             // Flags
                0x00, 0x01,             // QDCOUNT
                0x00, 0x00,             // ANCOUNT
                0x00, 0x00,             // NSCOUNT
                0x00, 0x00,             // ARCOUNT
                0x07, 'e', 'x', 'a', 'm', 'p', 'l', 'e',
                0x03, 'c', 'o', 'm',
                0x00,                   // End of domain name
                0x00, 0x01,             // QTYPE = A
                0x00, 0x01              // QCLASS = IN
        };

        var result = Task91_CLAUDE_claude_3_5_sonnet_20240620.parseDNSQuery(query);
        assertNotNull(result);
        assertEquals("example.com", result.domain);
        assertEquals(1, result.qtype);
        assertEquals(1, result.qclass);
    }

    @Test
    public void testCreateDNSResponse() {
        var msg = new Task91_CLAUDE_claude_3_5_sonnet_20240620.DNSMessage(
                (short) 0x1234, "example.com", (short) 1, (short) 1
        );
        List<String> answers = Arrays.asList("93.184.216.34");

        byte[] response = Task91_CLAUDE_claude_3_5_sonnet_20240620.createDNSResponse(msg, answers);

        assertNotNull(response);
        assertEquals(0x12, response[0]); // ID high byte
        assertEquals(0x34, response[1]); // ID low byte
        assertEquals((byte) 0x81, response[2]); // QR and flags
        assertEquals((byte) 0x80, response[3]); // Flags cont.
    }
}
