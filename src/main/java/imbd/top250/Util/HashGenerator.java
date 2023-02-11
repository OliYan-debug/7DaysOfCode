package imbd.top250.Util;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
        public static String getHashMd5(String value) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                BigInteger hash = new BigInteger(1, md.digest(value.getBytes(StandardCharsets.UTF_8)));
                return hash.toString(16);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
}
