package security.rsa;

import java.util.Map;

/**
 * 注意： RSA加密明文最大长度117字节，解密要求密文最大长度为128字节，所以在加密和解密的过程中需要分块进行。 RSA加密对明文的长度是有限制的
 * 
 * @author mht
 *
 */
public class RSATester {
    //公钥
    static String publicKey;
    //私钥
    static String privateKey;

    static {
        try {
            //生成密钥对
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            //获得密钥对中的公钥
            publicKey = RSAUtils.getPublicKey(keyMap);
            //获得密钥对中的私钥
            privateKey = RSAUtils.getPrivateKey(keyMap);
            System.err.println("公钥: \n\r" + publicKey);
            System.err.println("私钥： \n\r" + privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        test();
        testSign();
    }

    static void test() throws Exception {
        System.err.println("公钥加密——>私钥解密");
        String source = "这是一行没有任何意义的文字，你看完了等于没看，不是吗？";
        System.out.println("\r加密前文字：\r\n" + source);
        byte[] data = source.getBytes();
        //公钥加密
        byte[] encodedData = RSAUtils.encryptByPublicKey(data, publicKey);
        System.out.println("加密后文字：\r\n" + new String(encodedData));
        //私钥解密
        byte[] decodedData = RSAUtils.decryptByPrivateKey(encodedData, privateKey);
        System.out.println("解密后文字: \r\n" + new String(decodedData));
    }

    static void testSign() throws Exception {
        System.err.println("私钥加密——>公钥解密");
        String source = "这是一行测试RSA数字签名的无意义文字";
        System.out.println("原文字：\r\n" + source);
        byte[] data = source.getBytes();
        //加密
        byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
        System.out.println("加密后：\r\n" + new String(encodedData));
        //解密
        byte[] decodedData = RSAUtils.decryptByPublicKey(encodedData, publicKey);
        System.out.println("解密后: \r\n" + new String(decodedData));
        //--------------------------------------------------------------------------
        System.err.println("私钥签名——>公钥验证签名");
        String sign = RSAUtils.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);
        boolean status = RSAUtils.verify(encodedData, publicKey, sign);
        System.err.println("验证结果:\r" + status);
    }

}
