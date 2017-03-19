package com.csair.datatrs.common.processor;

import com.csair.datatrs.common.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 *
 * Created by cloudoo on 2015/7/17.
 */
public class Vector2FileProcesssor implements Processor<File> {
    protected static final Logger log = LoggerFactory.getLogger(Vector2FileProcesssor.class);
    private String fileName;
    private List<double[]> temp;

    public Vector2FileProcesssor(String fileName,List<double[]> temp){
             this.fileName = fileName;
            this.temp = temp;

    }

    public File doit() {

        if(temp==null||temp.size()==0){
            log.error("数组为空！！");
        }
        BufferedWriter bw = null;
        File resultFile = new File(fileName);
        try {


                bw  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile)));

                for(double[] arr:temp){
                    for(int i=0;i<arr.length;i++){
                        if(i!=(arr.length-1)){
                            bw.write(arr[i]+ File2VectorProcessor.SPLIT_TEXT);
                        }else{
                            bw.write(String.valueOf(arr[i]));
                        }
                    }
                    bw.write("\n");
                }


        } catch (FileNotFoundException e) {
            log.error("文件没有找到",e);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            if(bw!=null)
                bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultFile;
    }
}
