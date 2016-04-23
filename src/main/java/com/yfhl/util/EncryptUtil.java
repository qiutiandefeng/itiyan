package com.yfhl.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*
 * 经常用到的几种加密、解密方法封装

 */
public class EncryptUtil {
	private static final String UTF8 = "utf-8";
	// 定义 加密算法,可用 DES,DESede,Blowfish
	private static final String ALGORITHM_DESEDE = "DESede";
	private static final String iv="01234567";
	public static final String DesDecoderKey="EA22DAB57022E2560A376749E3408196A9E287D800E068E8";
	/**
	 * MD5数字签名
	 * 
	 * @param src
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws Exception
	 */
	public static String md5Digest(String src) {
		byte[] source = src.getBytes();
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符

		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s.toUpperCase();
	}

	/**
	 * BASE64 加密
	 * 
	 * @param src
	 * @return
	 * @throws Exception
	 */
	public static String base64Encoder(String src) throws Exception {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(src.getBytes(UTF8));
	}

	/**
	 * BASE64解密
	 * 
	 * @param dest
	 * @return
	 * @throws Exception
	 */
	public static String base64Decoder(String dest) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		return new String(decoder.decodeBuffer(dest), UTF8);
	}

	/**
	 * 3DES加密
	 * 
	 * @param src
	 * @param key
	 * @returns
	 * @throws Exception
	 */
	public static String desedeEncoder(String src, String key) throws Exception {
		
		Key deskey = null;

		DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(src.getBytes("utf8"));
        BASE64Encoder encoder = new BASE64Encoder();
        
		return encoder.encode(encryptData);
	}

	/**
	 * 3DES解密
	 * 
	 * @param dest
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String desedeDecoder(String dest, String key)
			throws Exception {
		Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decryptData = cipher.doFinal(decoder.decodeBuffer(dest));
        return new String(decryptData,"utf8");


	}
	public static String desedeDecoder(InputStream is, String key)
			throws Exception {
		Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] decryptData = cipher.doFinal(decoder.decodeBuffer(is));
        return new String(decryptData,"utf8");


	}
	/**
	 * 3DES加密
	 * 
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String desedeEncoder(byte[] bytes, String key) throws Exception {
		Key deskey = null;

		DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
        byte[] encryptData = cipher.doFinal(bytes);
        BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(encryptData);
	}

	/**
	 * 字节数组转化为大写16进制字符串

	 * 
	 * @param b
	 * @return
	 */
	private static String byte2HexStr(byte[] b) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < b.length; i++) {
			String s = Integer.toHexString(b[i] & 0xFF);
			if (s.length() == 1) {
				sb.append("0");
			}
			sb.append(s.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 字符串转字节数组
	 * 
	 * @param s
	 * @return
	 */
	private static byte[] str2ByteArray(String s) {
		int byteArrayLength = s.length() / 2;
		byte[] b = new byte[byteArrayLength];
		for (int i = 0; i < byteArrayLength; i++) {
			byte b0 = (byte) Integer.valueOf(s.substring(i * 2, i * 2 + 2), 16)
					.intValue();
			b[i] = b0;
		}

		return b;
	}

	/**
	 * 构造3DES加解密方法key
	 * 
	 * @param keyStr
	 * @return
	 * @throws Exception
	 */
	private static byte[] build3DesKey(String keyStr) {
		byte[] key = new byte[24];
		try {
			byte[] temp = keyStr.getBytes(UTF8);
			if (key.length > temp.length) {
				System.arraycopy(temp, 0, key, 0, temp.length);
			} else {
				System.arraycopy(temp, 0, key, 0, key.length);
			}
		} catch (Exception e) {

		}
		return key;
	}
	
	/**
	  * 把base64位字符串转成图片
	  * @param base64 字符串
	  * @param path 输出路径
	  */
	  public static void decodeBase64ToImage(String base64, String path) {
		 BASE64Decoder decoder = new BASE64Decoder();
		 try {
		      FileOutputStream write = new FileOutputStream(new File(path));
		      byte[] decoderBytes = decoder.decodeBuffer(base64);
		      write.write(decoderBytes);
		      write.close();
		 }catch (IOException e) {
		    e.printStackTrace();
		 }
	} 

}
