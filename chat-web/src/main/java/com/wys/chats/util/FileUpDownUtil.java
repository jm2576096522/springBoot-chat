package com.wys.chats.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * 文件上传下载
 * Created by Administrator on 2017/5/10.
 */
public class FileUpDownUtil {
	/**
	 * 文件上传
	 *
	 * @param file
	 * @param fileUrl 文件保存路径
	 * @return 文件大小
	 */
	public static long uploadFile(MultipartFile file, String fileUrl) {
		File targetFile = new File(fileUrl);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		//保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return file.getSize();
	}

	/**
	 * 文件下载
	 *
	 * @param response
	 * @param fileUrl  文件地址
	 * @param fileName 文件名
	 */
	public static void downloadFile(HttpServletResponse response, String fileUrl, String fileName) {
		response.setContentType("application/force-download");// 设置强制下载不打开
		try {
			response.addHeader("Content-Disposition",
					"attachment;fileName=" +  URLEncoder.encode(fileName, "UTF-8"));// 设置文件名
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] buffer = new byte[1024];
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {

			File file = new File(fileUrl);
			if (file.exists()) {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				OutputStream os = response.getOutputStream();
				int i = bis.read(buffer);
				while (i != -1) {
					os.write(buffer, 0, i);
					i = bis.read(buffer);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * @功能 下载临时素材接口
	 * @param filePath 文件将要保存的目录
	 * @param method 请求方法，包括POST和GET
	 * @param fileName 文件保存名
	 * @param url 请求的路径
	 * @return
	 */

	public static File saveUrlAs(String url,String filePath,String fileName,String method){
		File file=new File(filePath);//创建不同的文件夹目录
		if (!file.exists()){//判断文件夹是否存在
			file.mkdirs();//如果文件夹不存在，则创建新的的文件夹
		}
		FileOutputStream fileOut = null;
		HttpURLConnection conn = null;
		InputStream inputStream = null;
		try{
			URL httpUrl=new URL(url);// 建立链接
			conn=(HttpURLConnection) httpUrl.openConnection();
			conn.setRequestMethod(method);//以Post方式提交表单，默认get方式
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);// post方式不能使用缓存
			conn.connect();//连接指定的资源
			inputStream=conn.getInputStream();//获取网络输入流
			BufferedInputStream bis = new BufferedInputStream(inputStream);
			if (!filePath.endsWith("/")) {//判断文件的保存路径后面是否以/结尾
				filePath += "/";
			}
			fileOut = new FileOutputStream(filePath+fileName);//写入到文件（注意文件保存路径的后面一定要加上文件的名称）
			BufferedOutputStream bos = new BufferedOutputStream(fileOut);
			byte[] buf = new byte[4096];
			int length = bis.read(buf);
			while(length != -1){//保存文件
				bos.write(buf, 0, length);
				length = bis.read(buf);
			}
			bos.close();
			bis.close();
			conn.disconnect();
		} catch (Exception e){
			e.printStackTrace();
		}
		return file;
	}

	/**
	 * 下载url地址的文件，并重命名
	 * @param response 响应对象
	 * @param url 文件完整URL地址
	 * @param fileName 文件名
	 */
	public static void downLoadUrl(HttpServletResponse response, String url,String fileName){
		response.setContentType("application/force-download");// 设置强制下载不打开
		try {
			response.addHeader("Content-Disposition",
					"attachment;fileName=" +  URLEncoder.encode(fileName, "UTF-8"));// 设置文件名
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] buffer = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		HttpURLConnection conn = null;
		InputStream inputStream = null;
		try {

			URL httpUrl=new URL(url);// 建立链接
			conn=(HttpURLConnection) httpUrl.openConnection();
			conn.setRequestMethod("GET");//以Post方式提交表单，默认get方式
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);// post方式不能使用缓存
			conn.connect();//连接指定的资源
			inputStream=conn.getInputStream();//获取网络输入流
			bis = new BufferedInputStream(inputStream);
			os = response.getOutputStream();
			int i = bis.read(buffer);
			while (i != -1) {
				os.write(buffer, 0, i);
				i = bis.read(buffer);
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
