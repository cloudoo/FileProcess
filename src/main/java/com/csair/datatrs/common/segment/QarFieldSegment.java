package com.csair.datatrs.common.segment;



import com.csair.datatrs.common.FieldSegment;
import com.csair.datatrs.common.processor.ComUnZip;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cloudoo on 2015/10/27.
 */
public class QarFieldSegment implements FieldSegment {

	protected static final Logger log = LoggerFactory.getLogger(QarFieldSegment.class);
	
    public static Map<String,String> map = new HashMap<String,String>();

    
    @Override
    public String segment(String... words) {
    	
        String[] tempValues = words[0].split(FieldSegment.separator);
        log.debug(words[0]);
        log.debug("tempValues.length="+tempValues.length);
        tempValues[1] = String.valueOf((int)mean(tempValues[1].trim()));
        tempValues[4] = tempValues[4].replaceAll("/", "-");
        tempValues[18] = String.valueOf(mean(tempValues[18].trim()));
        tempValues[20] = String.valueOf(mean(tempValues[20].trim()));
        tempValues[21] = String.valueOf(mean(tempValues[21].trim()));
        tempValues[22] = String.valueOf(mean(tempValues[22].trim()));
        tempValues[25] = String.valueOf(mean(tempValues[25].trim()));
        tempValues[26] = String.valueOf(mean(tempValues[26].trim()));

        lastValue("drift",31,tempValues);

        tempValues[32] = String.valueOf(mean(tempValues[32].trim()));
        tempValues[34] = String.valueOf(mean(tempValues[34].trim()));//
        //APU_ON
        tempValues[36] = String.valueOf(mean(tempValues[36].trim()));
        lastValue("apuOn",38,tempValues);
        
        tempValues[43] = String.valueOf(mean(tempValues[43].trim()));
        tempValues[45] = String.valueOf(mean(tempValues[45].trim()));
        tempValues[46] = String.valueOf(mean(tempValues[46].trim()));
        tempValues[47] = String.valueOf(mean(tempValues[47].trim()));
        tempValues[50] = String.valueOf(mean(tempValues[50].trim()));
        tempValues[51] = String.valueOf(mean(tempValues[51].trim()));
        tempValues[64] = String.valueOf(mean(tempValues[64].trim()));
        tempValues[65] = String.valueOf(mean(tempValues[65].trim()));
        
        tempValues[59] = String.valueOf(mean(tempValues[59].trim()));
        tempValues[70] = String.valueOf(mean(tempValues[70].trim()));
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
    public float mean(String floats){
        if(StringUtils.isBlank(floats)){
            return 0f;
        }
        String[] a = floats.split("\\s+");
        
        float temp = 0f;
        
        try{
        	for(String t:a){
                temp+=Float.parseFloat(t);
            }
        	
        }catch(NumberFormatException e){
        	log.debug("NumberFormatException:"+floats);
        }
        
        return  temp / a.length ;
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
