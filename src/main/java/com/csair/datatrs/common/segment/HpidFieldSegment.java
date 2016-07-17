package com.csair.datatrs.common.segment;

/**
 *
 * Created by cloudoo on 2015/10/27.
 */
public class HpidFieldSegment implements FieldSegment{
    @Override
    public String segment(String... words) {

        String[] temp = new String[62];
        temp[0]= words[0].substring(0, 1);
        temp[1]= words[0].substring(1, 7);
        temp[2]= words[0].substring(7, 14);
        temp[3]= words[0].substring(14, 22);
        temp[4]= words[0].substring(22, 25);
        temp[5]= words[0].substring(25, 28);
        temp[6]= words[0].substring(28, 31);
        temp[7]= words[0].substring(31, 35);
        temp[8]= words[0].substring(35, 37);
        temp[9]= words[0].substring(37, 40);
        temp[10]= words[0].substring(40, 41);
        //////////////////////////////////////////
        temp[11]= words[0].substring(41, 50);
        temp[12]= words[0].substring(50, 58);
        temp[13]= words[0].substring(58, 59);
        temp[14]= words[0].substring(59, 60);
        temp[15]= words[0].substring(60, 61);
        temp[16]= words[0].substring(61, 63);
        temp[17]= words[0].substring(63, 73);
        temp[18]= words[0].substring(73, 74);
        temp[19]= words[0].substring(74, 78);
        temp[20]= words[0].substring(78, 86);
        //////////////////////////////////////
        temp[21]= words[0].substring(86, 94);
        temp[22]= words[0].substring(94, 102);
        temp[23]= words[0].substring(102, 106);
        temp[24]= words[0].substring(106, 110);
        temp[25]= words[0].substring(110, 115);
        temp[26]= words[0].substring(115, 119);
        temp[27]= words[0].substring(119, 123);
        temp[28]= words[0].substring(123, 128);
        temp[29]= words[0].substring(128, 129);
        temp[30]= words[0].substring(129, 131);
        /////////////////////////////////////
        temp[31]= words[0].substring(131, 134);
        temp[32]= words[0].substring(134, 137);
        temp[33]= words[0].substring(137, 141);
        temp[34]= words[0].substring(141, 146);
        temp[35]= words[0].substring(146, 149);
        temp[36]= words[0].substring(149, 152);
        temp[37]= words[0].substring(152, 154);
        temp[38]= words[0].substring(154, 156);
        temp[39]= words[0].substring(156, 159);
        temp[40]= words[0].substring(159, 162);
        ///////////////////////////////////////////
        temp[41]= words[0].substring(162, 174);
        temp[42]= words[0].substring(174, 177);
        temp[43]= words[0].substring(177, 180);
        temp[44]= words[0].substring(180, 182);
        temp[45]= words[0].substring(182, 190);
        temp[46]= words[0].substring(190, 198);
        temp[47]= words[0].substring(198, 200);
        temp[48]= words[0].substring(200, 203);
        temp[49]= words[0].substring(203,206);
        temp[50]= words[0].substring(206, 209);
        ////////////////////////////////////
        temp[51]= words[0].substring(209, 218);
        temp[52]= words[0].substring(218,219);
        temp[53]= words[0].substring(219, 223);
        temp[54]= words[0].substring(223, 225);
        temp[55]= words[0].substring(225, 232);
        temp[56]= words[0].substring(232, 236);
        temp[57]= words[0].substring(236, 237);
        temp[58]= words[0].substring(237, 238);
        temp[59]= words[0].substring(238, 241);
        temp[60]= words[0].substring(241, 242);
        ////////////////////////////////////////
        temp[61]= words[0].substring(242, 298);
//        System.out.println(words.length());
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<temp.length;i++){
            sb.append(temp[i]);
            sb.append("@");
        }

        return sb.substring(0,sb.length()-1);
    }
}
