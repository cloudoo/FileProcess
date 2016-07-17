 package com.csair.datatrs.common;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.util.Enumeration;


/**
 * Created by cloudoo on 2015/5/8.
 */
@Deprecated
public class UnZipProcessor implements Processor {

    private static final int buffer = 2048;
    private String path;

    public UnZipProcessor(String path){
        this.path = path;
    }


    public void doit() {
        int count = -1;
        int index = -1;
        String savepath = "";
        boolean flag = false;

        File file = null;
        InputStream is = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        savepath = path.substring(0, path.lastIndexOf("\\")) + "\\";

        try
        {
            ZipFile zipFile = new ZipFile(path);

            Enumeration<?> entries = zipFile.getEntries();

            while(entries.hasMoreElements())
            {
                byte buf[] = new byte[buffer];

                ZipEntry entry = (ZipEntry)entries.nextElement();

                String filename = entry.getName();
                index = filename.lastIndexOf("/");
                if(index > -1)
                    filename = filename.substring(index+1);

                filename = savepath + filename;

//                flag = isPics(filename);
//
//                if(!flag)
//                    continue;

                file = new File(filename);
                file.createNewFile();

                is = zipFile.getInputStream(entry);

                fos = new FileOutputStream(file);
                bos = new BufferedOutputStream(fos, buffer);

                while((count = is.read(buf)) > -1)
                {
                    bos.write(buf, 0, count );
                }

                fos.close();

                is.close();
            }

            zipFile.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public  boolean isPics(String filename)
    {
        boolean flag = false;

        if(filename.endsWith(".jpg") || filename.endsWith(".gif")  || filename.endsWith(".bmp") || filename.endsWith(".png"))
            flag = true;

        return flag;
    }
}
