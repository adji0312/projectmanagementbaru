//package project.ProjectManagement.security;
//
//import java.security.Security;
//
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.commons.codec.binary.Hex;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.codec.Hex;
//
//
//public class TripleDesEncoder {
//    private static final Logger LOG = LoggerFactory.getLogger(TripleDesEncoder.class);
//
//    // @Value("${bnos.interface.ad.key-id}")
//    // private static String keyId;
//
//    public static String encrypt(String message, String keyId) {
//        LOG.debug("encrypt()");
//        String cipherHex = null;
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//
//            byte[] keyBytes = keyId.getBytes();
//            LOG.debug("keyBytes = " + Hex.encodeHexString(keyBytes));
//
//            final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
//            final Cipher cipher = Cipher.getInstance("DESede/ECB/ZeroBytePadding");
//            // final Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//
//            final byte[] plainTextBytes = message.getBytes();
//            LOG.debug("plainTextBytes = " + Hex.encodeHexString(plainTextBytes));
//
//            final byte[] cipherBytes = cipher.doFinal(plainTextBytes);
//            cipherHex = Hex.encodeHexString(cipherBytes);
//            LOG.debug("cipherBytes = " + cipherHex);
//        } catch (Exception e) {
//            LOG.error("Encrypt password error", e);
//            throw new RuntimeException("Encrypt password error");
//        }
//        return cipherHex;
//    }
//
//    public static String decrypt(String cipherText, String keyId) {
//        LOG.debug("decrypt()");
//        String plainText = null;
//        try {
//            Security.addProvider(new BouncyCastleProvider());
//
//            byte[] keyBytes = keyId.getBytes();
//            LOG.debug("keyBytes = " + Hex.encodeHexString(keyBytes));
//
//            final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
//            final Cipher cipher = Cipher.getInstance("DESede/ECB/ZeroBytePadding");
//            cipher.init(Cipher.DECRYPT_MODE, key);
//
//            final byte[] cipherTextBytes = Hex.decodeHex(cipherText);
//            LOG.debug("cipherText = " + cipherText);
//
//            final byte[] plainBytes = cipher.doFinal(cipherTextBytes);
//            // plainHex = Hex.encodeHexString(plainBytes);
//            // LOG.debug("plainBytes = " + plainHex);
//            plainText = new String(plainBytes);
//        } catch (Exception e) {
//            LOG.error("Decrypt password error", e);
//            throw new RuntimeException("Decrypt password error");
//        }
//        return plainText;
//    }
//}
