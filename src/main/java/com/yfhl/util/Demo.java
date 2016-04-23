package com.yfhl.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yfhl.util.EncryptUtil;

public class Demo {

	public static void main(String[] args) {
		try {
			long beginTime = (new Date()).getTime();
			InputStream is = new FileInputStream("E:\\123\\2015-6-17日造价员考试成绩.json");
			
			ObjectMapper mapper = new ObjectMapper();
			String json = EncryptUtil.desedeDecoder(is,
					EncryptUtil.DesDecoderKey);
			System.out.println(json);
			long endTime = (new Date()).getTime();
			System.out.println("解密耗时："+(endTime-beginTime)/1000);
			
			String filePath="d:\\personInfo.json";
			
			FileWriter writer = new FileWriter(filePath, false);  
            writer.write(json);  
            writer.close();  
            
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		{"cardId":"532524199109042824","examCode":"151K2300744","examItems":[{"batchNum":"20150617工程造价管理基础知识与相关法规03","examTime":"2015-06-17 13:00:00-14:00:00","examType":"工程造价管理基础知识与相关法规","isPassed":"不合格","reasult":60,"seatNumber":"24","siteCode":"3"}],"gender":"女","name":"何娅琪","specialty":"土建","year":"2015"}
	}

}
