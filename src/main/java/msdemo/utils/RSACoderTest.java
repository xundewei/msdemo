package msdemo.utils;
import java.util.Map;
import sun.misc.BASE64Encoder;
public class RSACoderTest {
		static String privateKey ;
		static String publicKey ;
		public static void getKey() throws Exception {
		Map<String, Object> keyMap = RSACoder.initKey();

		publicKey = RSACoder.getPublicKey(keyMap);
		privateKey = RSACoder.getPrivateKey(keyMap);
		//公钥生成
		System.out.println("public : "+publicKey);
		//私钥生成
		System.out.println("private : "+privateKey);
	}
	public static void main(String[] args) throws Exception {
		 getKey() ;
//		System.err.println("公钥加密——私钥解密");
                //将明文转换为字节数组
		byte[] data = "serricee1".getBytes();
               //用公钥加密
		byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
                //打印加密字符串 为什么使用BASE64Encoder 因为在RSACoder里加密用的是 BASE64Encoder 加密
		String s = (new BASE64Encoder()).encode(encodedData);  
		System.err.println("加密: " +s);
//                //用私钥解密
		byte[] decodedData = RSACoder.decryptByPrivateKey(RSACoder.decryptBASE64(s),privateKey);
//
//		
		System.out.println( "解密后: " + new String(decodedData));
	}
	

}





