package com.csair.datatrs.common.processor;

import com.csair.datatrs.common.Processor;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by cloudoo on 2015/10/28.
 */
public class ZipByAntProcessor  implements Processor<File> {
    protected static final Logger log = LoggerFactory.getLogger(ZipByAntProcessor.class);
    private File zipFile;
    private String srcPathName;
    private String include;


    public ZipByAntProcessor(String pathName,String srcPathName,String include) {
        zipFile = new File(pathName);
        this.srcPathName = srcPathName;
        this.include = include;
    }

    @Override
    public File doit() {
        File srcdir = new File(srcPathName);
        if (!srcdir.exists())
            throw new RuntimeException(srcPathName + "不存在！");

        Project prj = new Project();
        Zip zip = new Zip();
        zip.setProject(prj);
        zip.setDestFile(zipFile);
        FileSet fileSet = new FileSet();
        fileSet.setProject(prj);
        fileSet.setDir(srcdir);
        fileSet.setIncludes("*." + include); //包括哪些文件或文件夹 eg:zip.setIncludes("*.java");
        //fileSet.setExcludes(...); 排除哪些文件或文件夹
        zip.addFileset(fileSet);
        log.info("压缩中.....");
        zip.execute();
        log.info("压缩完成.....");
        return zipFile;
    }

    public static void main(String[] args){
        Processor test = new ZipByAntProcessor(  "S:\\B-9930\\leisy",  "S:\\B-9930",  "ENG");
        test.doit();
    }
}
