package com.csair.datatrs.common.segment;



import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cloudoo on 2015/10/27.
 */
public class QarFieldSegment implements FieldSegment{

    public static Map<String,String> map = new HashMap<String,String>();

    @Override
    public String segment(String... words) {

        String[] tempValues = words[0].split(FieldSegment.separator);

        tempValues[4] = tempValues[4].replaceAll("/", "-");
        tempValues[20] = mean(tempValues[20].trim());
        tempValues[21] = mean(tempValues[21].trim());
        tempValues[22] = mean(tempValues[22].trim());


        lastValue("drift",31,tempValues);

        tempValues[32] = mean(tempValues[32].trim());
        tempValues[34] = mean(tempValues[34].trim());
        //APU_ON
        lastValue("apuOn",38,tempValues);

        tempValues[44] = mean(tempValues[44].trim());
        tempValues[47] = mean(tempValues[47].trim());
        tempValues[70] = mean(tempValues[70].trim());
        lastValue("OIL_PRS1",71,tempValues);
        lastValue("OIL_PRS2",72,tempValues);
        lastValue("DFC", 98, tempValues);

        for(int i=0;i<tempValues.length;i++){
            tempValues[i] = StringUtils.trimToEmpty(tempValues[i]);
        }
        return   StringUtils.join(tempValues,",");
    }

    /**
     * 计算平均值
     * @param floats
     * @return
     */
    public String mean(String floats){
        if(StringUtils.isBlank(floats)){
            return "0";
        }
        String[] a = floats.split("\\s+");

        float temp = 0;
        for(String t:a){
            temp+=Float.parseFloat(t);
        }
        return String.valueOf(temp / a.length);
    }


    public void lastValue(String segmentName,int segmentIndex,String[] tempValues){
        String temp = tempValues[segmentIndex].trim();
        if(temp.length()>0){
            map.put(segmentName,temp);
        }else{
            if(map.containsKey(segmentName)){
                tempValues[segmentIndex] = map.get(segmentName);
            }
        }

    }

    public static void main(String[] args){
        QarFieldSegment afs = new QarFieldSegment();
        System.out.println("2015/13/11".replaceAll("/","-"));
    }


}
