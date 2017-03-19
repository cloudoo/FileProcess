package com.csair.datatrs.common.processor;

import com.csair.datatrs.common.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cloudoo on 2015/7/17.
 */
public class File2VectorProcessor implements Processor<List<double[]>> {
    protected static final Logger log = LoggerFactory.getLogger(File2VectorProcessor.class);

    public static String SPLIT_TEXT=" ";
    private String fileName;
    private List<double[]> vectors;


    public File2VectorProcessor(String fileName,List<double[]> vectors){
            this.fileName = fileName;
            this.vectors = vectors;
    }


    public List<double[]> doit() {
        if(vectors==null){
            log.error("未传入listֹ");
            return null;
        }

        try {
            String line="";
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            while ((line=br.readLine())!=null) {

                String[] temp = line.split(File2VectorProcessor.SPLIT_TEXT);
                double[] tempDouble = new double[temp.length];

                for(int i=0;i<temp.length;i++){
                    tempDouble[i]= Double.parseDouble(temp[i]);
                }
                vectors.add(tempDouble);
            }
        } catch (FileNotFoundException e) {
            log.error("文件" + fileName + "没有找到", e);
        } catch (IOException e) {
            log.error("文件读取io错误",e);
        }

        return vectors;
    }

    public static void main(String[] args){
        String fileName = "D:\\03_工作文件\\02_研究院\\01_项目\\05_大数据平台\\00_项目文档\\09_数据\\02_MIDT\\demo_,_div.txt";
        List<double[]> vectors = new ArrayList<double[]>();
        File2VectorProcessor file2VectorProcessor = new File2VectorProcessor(fileName,vectors);
        file2VectorProcessor.doit();
        NormalizeProcessor normalizeProcessor = new NormalizeProcessor(vectors);
        normalizeProcessor.doit();


    }
}
