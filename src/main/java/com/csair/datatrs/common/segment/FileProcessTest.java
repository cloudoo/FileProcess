package com.csair.datatrs.common.segment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.csair.datatrs.common.FieldSegment;

public class FileProcessTest {

	public static void main(String[] args) {

		FieldSegment segment = new QarFieldSegment();
		
		
		String tempfilestr = "D:\\03_工作文件\\02_研究院\\01_项目\\06_QAR大数据\\datatest\\318273-B-2859-20150413.ENG";
		tempfilestr = "S:\\qar\\temp\\377803-B-6219-20150516.ENG";
		File tempfile = new File(tempfilestr);

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		BufferedWriter writer = null;
		File resultFile = null;
		try {
			fis = new FileInputStream(tempfile);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			// 写入另外文本中
			// 简写如下：
			resultFile = new File(tempfile.getAbsolutePath() + ".process");
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(resultFile), "UTF-8"));

			// 注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
			//
			String line = "";
			String tempLine = "";
			int count = 1;
			while ((line = br.readLine()) != null) {
				if (count % 10000 == 0) {
					System.out.print("*");
				}
				if(count>3){
//					System.out.println(count);
					tempLine = segment.segment(line);
					writer.write(tempLine + "\t\n");
				}
				count++;
			}
			
			System.out.println("");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			assert br != null;
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 

	}

}
