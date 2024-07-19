package codestral.task78;// Java
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMWriter;

import java.security.*;
import java.security.spec.*;
import java.io.*;

public class Task78_MISTRAL_codestral_latest {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();

        PEMWriter pemWriter = new PEMWriter(new OutputStreamWriter(System.out));
        //invalid code
        pemWriter.writeObject(new PrivateKeyInfo((ASN1Sequence) privateKey));
//        pemWriter.writeObject(new PEMWriter.PrivateKeyInfo(privateKey));
        pemWriter.close();
    }
}