package gtp4o.task91;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.net.*;

public class Task91Test {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5353;
    private static DatagramSocket socket;

    @BeforeAll
    public static void setup() throws Exception {
        socket = new DatagramSocket();
    }

    @AfterAll
    public static void tearDown() throws Exception {
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

    @Test
    public void testReceiveAndEchoData() throws Exception {
        // Create a mock DNS query packet for "example.com"
        byte[] query = new byte[] {
                0x12, 0x34,             // ID
                0x01, 0x00,             // Flags
                0x00, 0x01,             // QDCOUNT
                0x00, 0x00,             // ANCOUNT
                0x00, 0x00,             // NSCOUNT
                0x00, 0x00,             // ARCOUNT
                0x07, 'e', 'x', 'a', 'm', 'p', 'l', 'e', // "example"
                0x03, 'c', 'o', 'm',     // "com"
                0x00,                   // End of domain name
                0x00, 0x01,             // QTYPE = A
                0x00, 0x01              // QCLASS = IN
        };

        // Send a packet to the DNS resolver
        DatagramPacket sendPacket = new DatagramPacket(query, query.length, InetAddress.getByName(SERVER_IP), SERVER_PORT);
        socket.send(sendPacket);

        // Receive the response from the DNS resolver
        byte[] buffer = new byte[512];
        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivePacket);

        // Ensure the response matches the sent query
        assertArrayEquals(query, receivePacket.getData(), "The received data should match the sent data.");
    }
}
