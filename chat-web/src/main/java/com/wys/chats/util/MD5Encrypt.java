package com.wys.chats.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {

    public MD5Encrypt() {

    }

    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));//若使用本函数转换则可得到加密结果的16进制表示，即数字字母混合的形式
//      resultSb.append(byteToNumString(b[i]));//使用本函数则返回加密结果的10进制数字字串，即全数字形式
        }
        return resultSb.toString();
    }

    private static String byteToNumString(byte b) {

        int _b = b;
        if (_b < 0) {
            _b = 256 + _b;
        }

        return String.valueOf(_b);
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static String MD5Encode(String origin) {
        String resultString = null;

        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     */
    public static String getFileMD5String(MultipartFile file) {
        InputStream fis;
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
            fis = file.getInputStream();
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                messagedigest.update(buffer, 0, numRead);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayToString(messagedigest.digest());
    }

    /**
     * 生成文件的md5校验值
     *
     * @param file
     * @return
     */
    public static String getFileMD5String(File file) {
        InputStream fis;
        MessageDigest messagedigest = null;
        try {
            messagedigest = MessageDigest.getInstance("MD5");
            fis = new FileInputStream(file) ;
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                messagedigest.update(buffer, 0, numRead);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayToString(messagedigest.digest());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//    MD5Encrypt md5encrypt = new MD5Encrypt();
        System.out.println(MD5Encode("123456"));
    }
}

