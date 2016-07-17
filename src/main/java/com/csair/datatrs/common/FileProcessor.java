package com.csair.datatrs.common;


import com.csair.datatrs.common.segment.FieldSegment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


/**
 * 对文件按照 某个segment方法分割后，在存入文本中
 * Created by cloudoo on 2015/5/4.
 */
public class FileProcessor implements Processor {
    protected static final Logger log = LoggerFactory.getLogger(FileProcessor.class);
    private File tempfile;
    private FieldSegment segment;

    public FileProcessor(File file, FieldSegment segment){
        tempfile= file;
        this.segment = segment;
    }


    public void doit() {

        FileInputStream fis= null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        BufferedWriter writer = null;

        try {
            fis = new FileInputStream(tempfile);
            isr= new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);
            //简写如下
            //BufferedReader br = new BufferedReader(new InputStreamReader(
            //        new FileInputStream("E:/phsftp/evdokey/evdokey_201103221556.txt"), "UTF-8"));

            //写入另外文本中
            //简写如下：
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(new File(tempfile.getAbsolutePath()+".process")), "UTF-8"));

            //注意关闭的先后顺序，先打开的后关闭，后打开的先关闭
//
            String line="";
            String tempLine = "";
            int count=1;
            while ((line=br.readLine())!=null) {
                if(count%10000==0){
                    System.out.print("*");

                    count = 1;
                }
                tempLine = segment.segment(line);

                writer.write(tempLine+"\t\n");
                count++;
            }
            System.out.println("");

        } catch (FileNotFoundException e) {
            log.error("未找到文件",e);
        } catch (UnsupportedEncodingException e) {
            log.error("编码格式不支持", e);
        } catch (IOException e) {
            log.error("IO错误", e);
        }finally {
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
