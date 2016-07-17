package com.csair.datatrs.common.segment;

/**
 * 针对无分隔符的文本，分割位置类
 * Created by cloudoo on 2015/7/1.
 *
 */
public class SegmentPosition {

    public int startIndex;
    public int endIndex;

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
