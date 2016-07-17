package com.csair.datatrs.common.segment;

import com.csair.datatrs.common.FieldSegment;

/**
 * 普通区分
 * Created by cloudoo on 2015/7/17.
 */
public class CommonsFieldSegment implements FieldSegment {

    private String  split = ",";
    public CommonsFieldSegment(){

    }
    public CommonsFieldSegment(String split){
        this.split = split;
    }

    public String segment(String... words) {

        return words[0];
    }
}
