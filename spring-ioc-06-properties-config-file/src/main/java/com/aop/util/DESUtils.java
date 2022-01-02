package com.aop.util;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class DESUtils {

	/**
	 * 对str进行base64加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {


		Base64.Encoder encoder = Base64.getEncoder();
		String encoderStr = "";
		try {
			encoderStr = encoder.encodeToString(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encoderStr;
	}

	/**
	 * 对str进行base64解密
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {

		Base64.Decoder decoder = Base64.getDecoder();

		byte[] decode = decoder.decode(str.getBytes());
		return new String(decode);

	}

	public static void main(String[] args) throws Exception {
		String username = "root";
		String password = "12345";
		Base64.Encoder encoder = Base64.getEncoder();
		System.out.println(encoder.encode(username.getBytes("UTF-8")));
		System.out.println(encoder.encode(password.getBytes("UTF-8")));


		Base64.Decoder decoder = Base64.getDecoder();
		System.out.println(new String(decoder.decode("[B@4783da3f"),"UTF-8"));

		//System.out.println(getDecryptString("WnplV/ietfQ="));
		//System.out.println(getDecryptString("gJQ9O+q34qk="));
	}
}
