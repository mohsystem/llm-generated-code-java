package codestral.task91;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.xbill.DNS.*;
import org.xbill.DNS.Record;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramSocket;

public class Task91Test {

    @Test
    public void testParseDNSQuery() throws Exception {
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

        DatagramPacket packet = new DatagramPacket(query, query.length, InetAddress.getByName("127.0.0.1"), 53);

        // Parsing DNS query (Simulating DNS server behavior)
        Message request = new Message(packet.getData());
        assertNotNull(request);
        assertEquals("example.com.", request.getQuestion().getName().toString());
    }

    @Test
    public void testResolveDNS() throws Exception {
        // Simulating the DNS resolution method
        String domain = "example.com.";
        Message query = new Message();

        // Set flags for response
        query.getHeader().setFlag(Flags.QR);
        query.getHeader().setFlag(Flags.AA);
        query.getHeader().setFlag(Flags.RA);

        // Create question record
        Name name = Name.fromString(domain);
        Record question = Record.newRecord(name, Type.A, DClass.IN);
        query.addRecord(question, Section.QUESTION);

        // Simulate a resolved response with a simple A record
        Message response = resolveDNS(query);

        assertNotNull(response);
        assertTrue(response.getSection(Section.ANSWER).size() > 0);
        assertEquals(domain, response.getSection(Section.QUESTION).get(0).getName().toString());
    }

    @Test
    public void testDNSResponseFormat() throws Exception {
        // Simulate DNS query and response generation
        byte[] queryData = new byte[] {
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

        DatagramPacket packet = new DatagramPacket(queryData, queryData.length, InetAddress.getByName("127.0.0.1"), 53);
        DatagramSocket socket = new DatagramSocket();
        socket.send(packet);

        byte[] buffer = new byte[512];
        DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(responsePacket);

        byte[] responseData = responsePacket.getData();
        assertNotNull(responseData);
        assertTrue(responseData.length > 0);
    }

    // You must make `resolveDNS` public to test it
    public Message resolveDNS(Message request) {
        Header header = request.getHeader();
        header.setFlag(Flags.QR); // Response
        header.setFlag(Flags.AA); // Authoritative Answer
        header.setFlag(Flags.RA); // Recursion Available

        try {
            // Create a dummy A record as the answer
            Record answer = new ARecord(request.getQuestion().getName(), DClass.IN, 60, InetAddress.getByName("93.184.216.34"));
            Message response = new Message(request.getHeader().toWire());
            response.addRecord(answer, Section.ANSWER);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return request; // Returning the request in case of error
        }
    }
}
