package com.yfhl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CryptoTools {
	public static String encryptKey = "123qwe!@#";
	public static byte[] IV = { 0x12, 0x34, 0x56, 0x78, (byte) 0x90,
			(byte) 0xAB, (byte) 0xCD, (byte) 0xEF };

	/**
	 * 加密
	 */
	@SuppressWarnings("restriction")
	public static String encrypt(String message) throws Exception {

		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(encryptKey.getBytes("utf-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(IV);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(message.getBytes("UTF-8"));
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(retByte);
	}

	/**
	 * 解密
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public static String decrypt(String message) throws Exception {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytesrc = decoder.decodeBuffer(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(encryptKey.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(IV);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte, "UTF-8");
	}
	/**
	 * 读取文件
	 * @param path
	 * @return
	 * @throws Exception
	 */

	public static String read(String path) throws Exception {
		File f = new File(path);
		FileReader fileReader = new FileReader(f);
		BufferedReader br = new BufferedReader(fileReader);
		String str;
		StringBuffer sb = new StringBuffer("");

		while ((str = br.readLine()) != null) {
			//sb.append(str);
			System.out.println(str);
		}
		System.out.println("读取方法中的：");
		System.out.println(sb.toString());
		str = decrypt(sb.toString());
		return str;
	}

}
