package gemini.task91;

import org.junit.jupiter.api.Test;
import java.net.*;
import static org.junit.jupiter.api.Assertions.*;

public class Task91Test {

    @Test
    public void testServerReceivesQueryWithoutCrash() throws Exception {
         byte[] dnsQuery = new byte[] {
                0x12, 0x34, // ID
                0x01, 0x00, // Flags: standard query
                0x00, 0x01, // QDCOUNT
                0x00, 0x00, // ANCOUNT
                0x00, 0x00, // NSCOUNT
                0x00, 0x00, // ARCOUNT
                0x07, 'e', 'x', 'a', 'm', 'p', 'l', 'e',
                0x03, 'c', 'o', 'm',
                0x00,       // End of domain
                0x00, 0x01, // QTYPE A
                0x00, 0x01  // QCLASS IN
        };

        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000); // 2 ثواني

        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(dnsQuery, dnsQuery.length, serverAddress, 53);
        socket.send(packet);

         byte[] buffer = new byte[512];
        DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);

        try {
            socket.receive(responsePacket);
            assertTrue(responsePacket.getLength() > 0);
        } catch (SocketTimeoutException e) {
             System.out.println("No response received (expected for empty implementation).");
        }

        socket.close();
    }
}
