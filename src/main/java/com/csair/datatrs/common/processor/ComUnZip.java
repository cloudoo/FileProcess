package com.csair.datatrs.common.processor;


import com.csair.datatrs.common.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by cloudoo on 2015/5/12.
 */
public class ComUnZip implements Processor<List<File>> {
    protected static final Logger log = LoggerFactory.getLogger(ComUnZip.class);
    String fileName = "";
    String destPath = "";
    private static final int buffer = 2048;

    public ComUnZip(String fileName){
        this.fileName = fileName;
    }

    public ComUnZip(String fileName,String destPath){
        this.fileName = fileName;
        this.destPath = destPath;
    }

    public List<File> doit(){
        List<File> fileList = new ArrayList<>();
        int count = -1;
        int index = -1;

        String savepath = "";
        boolean flag = false;
        File file = null;
        if(destPath.length()>0){
            file = new File(destPath);
            if(!file.exists())
            file.mkdirs();
        }
        if(file!=null){
            savepath = destPath;
        }else{
            savepath = fileName.substring(0, fileName.lastIndexOf("\\")) + "\\";
        }

        log.info("开始解压文件"+fileName+"到："+savepath);
        try
        {
            BufferedOutputStream bos = null;
            ZipEntry entry = null;
            FileInputStream fis = new FileInputStream(fileName);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));

            while((entry = zis.getNextEntry()) != null)
            {
                byte data[] = new byte[buffer];

                String temp = entry.getName();
                index = temp.lastIndexOf("/");
                if(index > -1)
                    temp = temp.substring(index+1);
                temp = savepath +"//"+ temp;

                File f = new File(temp);
                fileList.add(f);
                f.createNewFile();

                FileOutputStream fos = new FileOutputStream(f);
                bos = new BufferedOutputStream(fos, buffer);

                while((count = zis.read(data, 0, buffer)) != -1)
                {
                    bos.write(data, 0, count);
                }

                bos.flush();
                bos.close();
            }

            zis.close();

        } catch (Exception e) {
            log.error("文件解压错误！",e);
        }
        return fileList;
    }

}

