package codestral.task106;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106_MISTRAL_codestral_latest {
    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;

    public Task106_MISTRAL_codestral_latest() {
        SecureRandom r = new SecureRandom();
        p = BigInteger.probablePrime(1024, r);
        q = BigInteger.probablePrime(1024, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(1024 / 2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, N);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, N);
    }
}