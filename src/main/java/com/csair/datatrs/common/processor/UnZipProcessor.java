 package com.csair.datatrs.common.processor;

import com.csair.datatrs.common.Processor;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


 /**
 * Created by cloudoo on 2015/5/8.
 */
public class UnZipProcessor implements Processor<List<File>> {

    private static final int buffer = 2048;
    private String path;

    public UnZipProcessor(String path){
        this.path = path;
    }


    public List<File> doit() {
        List<File> fileList = new ArrayList<>();
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
                fileList.add(file);
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

        return fileList;
    }

    public  boolean isPics(String filename)
    {
        boolean flag = false;

        if(filename.endsWith(".jpg") || filename.endsWith(".gif")  || filename.endsWith(".bmp") || filename.endsWith(".png"))
            flag = true;

        return flag;
    }
}
