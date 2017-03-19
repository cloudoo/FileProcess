package com.csair.datatrs.common.processor;

import com.csair.datatrs.common.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 向量均一化处理类
 * Created by cloudoo on 2015/7/17.
 */
public class NormalizeProcessor implements Processor<List<double[]>> {
    protected static final Logger log = LoggerFactory.getLogger(NormalizeProcessor.class);

    public List<double[]> vectors;


    public NormalizeProcessor(List<double[]> vectors){
        this.vectors = vectors;
    }

    public List<double[]> doit() {
        if(vectors==null||vectors.size()==0){
            log.info("数组为空，需要初始化");
            return null;
        }
        double[] firtLine = vectors.get(0);
        double[] mins = new double[firtLine.length];
        double[] max = new double[firtLine.length];
            int index=0;
            for(double[] vector:vectors){

                    for(int i=0;i<vector.length;i++){
                           if(vector[i]<mins[i])
                               mins[i]=vector[i];
                            else if(vector[i]>=max[i]){
                               max[i]=vector[i];
                           }
                    }
            }

        for(double[] vector:vectors){
            log.info("----------------------index:" + index+"-----------------------------");
            for(int i=0;i<vector.length;i++){
                log.info(" oral:vector[" + i + "]:" + vector[i]);
                vector[i] =( vector[i]-mins[i])/(max[i]-mins[i]);
                log.info(" vector[" + i + "]:" + vector[i]+"|"+" mins[" + i + "]:" + mins[i]+"|max["+i+"]:"+ max[i]);
            }
            index++;
        }
        return  vectors;
    }

    public static void main(String[] args){

        List<double[]> vectors = new ArrayList<double[]>();
        for(int i=0;i<10;i++){
            double[] temp = new double[4];
            temp[0]= Math.random()*10;
            temp[1]= Math.random()*20;
            temp[2]= Math.random();
            temp[3]= Math.random()*2;
            vectors.add(temp);
        }

        NormalizeProcessor normalizeProcessor = new NormalizeProcessor(vectors);
        normalizeProcessor.doit();
    }
}
