//package test;
//
//import java.security.MessageDigest;
//
//import org.apache.shiro.crypto.hash.SimpleHash;
//import org.apache.shiro.util.ByteSource;
//
//public class mdTest {
//			
//	
//	
//	  /***
//     * MD5加码 生成32位md5码
//     */
//    public static String string2MD5(String inStr){
//        MessageDigest md5 = null;
//        try{
//            md5 = MessageDigest.getInstance("MD5");
//        }catch (Exception e){
//            System.out.println(e.toString());
//            e.printStackTrace();
//            return "";
//        }
//        char[] charArray = inStr.toCharArray();
//        byte[] byteArray = new byte[charArray.length];
// 
//        for (int i = 0; i < charArray.length; i++)
//            byteArray[i] = (byte) charArray[i];
//        byte[] md5Bytes = md5.digest(byteArray);
//        StringBuffer hexValue = new StringBuffer();
//        for (int i = 0; i < md5Bytes.length; i++){
//            int val = ((int) md5Bytes[i]) & 0xff;
//            if (val < 16)
//                hexValue.append("0");
//            hexValue.append(Integer.toHexString(val));
//        }
//        return hexValue.toString();
// 
//    }
// 
//    /**
//     * 加密解密算法 执行一次加密，两次解密
//     */
//    public static String convertMD5(String inStr){
// 
//        char[] a = inStr.toCharArray();
//        for (int i = 0; i < a.length; i++){
//            a[i] = (char) (a[i] ^ 't');
//        }
//        String s = new String(a);
//        return s;
// 
//    }
//
// // 测试主函数
//    public static void main(String args[]) {
////       String s = new String("admin111");
////        System.out.println("原始：" + s);
////       System.out.println("MD5后：" + string2MD5(s));
////        System.out.println("加密的：" + convertMD5(s));
////        System.out.println("解密的：" + convertMD5(convertMD5(s)));
//// 
////    	
////    	String hashAlgorithmName = "MD5";//加密方式
////        Object crdentials = "111";//密码原值
////        Object salt = "adminq";//盐值
////        int hashIterations = 1024;//加密1024次
////        String result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations).toBase64();
////        System.out.println(result);
//    	
//    		String hashAlgorithmName = "MD5";//加密方式
//    	    Object crdentials = "666666";//密码原值
//    	    Object salt = null;//盐值
//    	    int hashIterations = 1024;//加密1024次
//    	    Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
//    	    System.out.println(result);
//
// 
//    }
//
//
//}
