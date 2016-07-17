package com.csair.datatrs.common.segment;

import com.csair.datatrs.utils.DateUtils;

/**
 * Created by cloudoo on 2015/10/27.
 */
public class MidtFieldSegment implements FieldSegment{

    public static String divline = "----------------------------------------------------------------";
    @Override
    public String segment(String... words) {
        String[] temp = new String[42];
        temp[0]= words[0].substring(0, 8).trim();//agency
        temp[1]= words[0].substring(8, 17).trim();//PseudoCityCode
        temp[2]= words[0].substring(17, 19).trim();//Agencycountry

        temp[3]= words[0].substring(19, 27).trim();temp[3]= DateUtils.string2HiveDateFormat(temp[3]);//TransactionDate
//        temp[4]= words[0].substring(27, 33).trim();temp[4]=temp[4]+"01";//日期 ProcessDate
        String processDate=words[0].substring(27, 33).trim()+"01";
        temp[4]=DateUtils.string2HiveDateFormat(processDate);
        temp[5]= words[0].substring(33, 34).trim();//CRS
        temp[6]= words[0].substring(34, 40).trim();//RecordLocatorPNR
        temp[7]= words[0].substring(40, 46).trim();//CityPair
        temp[8]= words[0].substring(46, 52).trim();//Route
        temp[9]= words[0].substring(52, 55).trim();//TripCarrier
        temp[10]= words[0].substring(55, 57).trim();//TripClass
        //////////////////////////////////////////
        temp[11]= words[0].substring(57, 58).trim();//TripCompartment
        temp[12]= words[0].substring(58, 65).trim();//Passengers
        temp[13]= words[0].substring(65, 66).trim();//DomesticInternational
        temp[14]= words[0].substring(66, 67).trim();//PassiveIndicator
        temp[15]= words[0].substring(67, 70).trim();//PointofOrigin
        temp[16]= words[0].substring(70, 73).trim();//MetroPointofOrigin
        temp[17]= words[0].substring(73, 76).trim();//PointofDestination
        temp[18]= words[0].substring(76, 79).trim();//MetroPointofDestination
        temp[19]= words[0].substring(79, 87).trim();temp[19]= DateUtils.string2HiveDateFormat(temp[19]);//PNRcreatedate
        temp[20]= words[0].substring(87, 95).trim();temp[20]= DateUtils.string2HiveDateFormat(temp[20]);//PNRfirstdeparturedate
        /////////////////////////////////////.trim()/
        temp[21]= words[0].substring(95, 103).trim();temp[21]= DateUtils.string2HiveDateFormat(temp[21]);//PNRlastdeparturedate
        temp[22]= words[0].substring(103, 106).trim();//TripEquipment
        temp[23]= words[0].substring(106, 107).trim();//TripEquipmentType
//        temp[24]= words[0].substring(107, 111).trim();//TripElapsedTime
        temp[24]=DateUtils.hhmm2second(words[0].substring(107, 111).trim());//TripElapsedTime
        temp[25]= words[0].substring(111, 116).trim();//TripMiles
        temp[26]= words[0].substring(116, 119).trim();//TotalStops
        temp[27]= words[0].substring(119, 123).trim();//OriginWAC
        temp[28]= words[0].substring(123, 127).trim();//DestinationWAC
        temp[29]= words[0].substring(127, 129).trim();//ISOFrom
        temp[30]= words[0].substring(129, 131).trim();//ISOTo
        temp[31]= words[0].substring(131, 134).trim();//MetroFrom
        /////////////////////////////////////

        temp[32]= words[0].substring(134, 137).trim();//MetroTo
//        temp[33]=dateFormat(words[0].substring(137, 145).trim(), words[0].substring(145, 149).trim());
        temp[33]=DateUtils.string2HiveTimeFormat(words[0].substring(137,149));
//        temp[33]= words[0].substring(137, 145).trim();//TripDepartDate
//        temp[34]= words[0].substring(145, 149).trim();//TripDepartTime
        temp[34]= words[0].substring(149, 150).trim();//TripDepartDay
//        temp[35]=dateFormat(words[0].substring(150, 158).trim().trim(), words[0].substring(158, 162).trim());
        temp[35]=DateUtils.string2HiveTimeFormat(words[0].substring(150, 162));
//        temp[36]= words[0].substring(150, 158).trim();//TripArriveDate
//        temp[37]= words[0].substring(158, 162).trim();//TripArriveTime
        temp[36]= words[0].substring(162, 163).trim();//TripArriveDay
        temp[37]=DateUtils.string2HiveTimeFormat(words[0].substring(163, 175));
//        temp[37]=dateFormat(words[0].substring(163, 171).trim(), words[0].substring(171, 175).trim());
//        temp[39]= words[0].substring(163, 171).trim();//TripGMTDepartDate
//        temp[40]= words[0].substring(171, 175).trim();//TripGMTDepartTime
        ///////////////////////////////////////////
        temp[38]=DateUtils.string2HiveTimeFormat(words[0].substring(175, 187));
//        temp[38]=dateFormat(words[0].substring(175, 183).trim(), words[0].substring(183, 187).trim());
//        temp[41]= words[0].substring(175, 183).trim();//TripGMTArriveDate
//        temp[42]= words[0].substring(183, 187).trim();//TripGMTArriveTime
        temp[39]= words[0].substring(187, 192).trim();//Filler
        temp[40]= words[0].substring(192, 194).trim();//segment域名
        int segmentCount = Integer.parseInt(temp[40]);
        temp[41]= processDate+words[1];
        String[] segmentString = new String[22*segmentCount];

        for(int i=0;i<segmentCount;i++){
            int step = i*105;
            int sjstep = i*22;
            segmentString[0+sjstep]= words[0].substring(194 + step, 197 + step).trim();//Origin
            segmentString[1+sjstep]=DateUtils.string2HiveTimeFormat(words[0].substring(197 + step, 209 + step));
//            segmentString[1+sjstep]= words[0].substring(197 + step, 205 + step).trim();//SegDepartDateTime
//            segmentString[2+sjstep]= words[0].substring(205 + step, 209 + step).trim();//SegDepartDateTime
            segmentString[2+sjstep]=DateUtils.string2HiveTimeFormat(words[0].substring(209 + step, 221 + step));
//            segmentString[3+sjstep]= words[0].substring(209 + step, 217 + step).trim();//SegDepartGMTDateTime
//            segmentString[4+sjstep]= words[0].substring(217 + step, 221 + step).trim();//SegDepartGMTDateTime
            segmentString[3+sjstep]= words[0].substring(221 + step, 223 + step).trim();//SegDepartISOCode
            ////////////////////////////////////
            segmentString[4+sjstep]= words[0].substring(223 + step, 227 + step).trim();//SegDepartWAC
            segmentString[5+sjstep]= words[0].substring(227 + step, 228 + step).trim();//SegDepartDay
            segmentString[6+sjstep]= words[0].substring(228 + step, 231 + step).trim();//SegDestination
            segmentString[7+sjstep]=DateUtils.string2HiveTimeFormat(words[0].substring(231 + step, 243 + step));
//            segmentString[9+sjstep]= words[0].substring(231 + step, 239 + step).trim();//SegArrivalDateTime
//            segmentString[10+sjstep]= words[0].substring(239 + step, 243 + step).trim();//SegArrivalDateTime
            segmentString[8+sjstep]=DateUtils.string2HiveTimeFormat(words[0].substring(243 + step, 255 + step));
//            segmentString[11+sjstep]= words[0].substring(243 + step, 251 + step).trim();//SegArrivalGMTDateTime
//            segmentString[12+sjstep]= words[0].substring(251 + step, 255 + step).trim();//SegArrivalGMTDateTime
            segmentString[9+sjstep]= words[0].substring(255 + step, 257 + step).trim();//SegArrivalISOCode
            segmentString[10+sjstep]= words[0].substring(257 + step, 261 + step).trim();//SegArrivalWAC
            segmentString[11+sjstep]= words[0].substring(261 + step, 264 + step).trim();//Carrier
            ////////////////////////////////////////
            segmentString[12+sjstep]= words[0].substring(264 + step, 268 + step).trim();//Flight
            segmentString[13+sjstep]= words[0].substring(268 + step, 270 + step).trim();//Clazz
            segmentString[14+sjstep]= words[0].substring(270 + step, 271 + step).trim();//Compartment
            segmentString[15+sjstep]= words[0].substring(271 + step, 274 + step).trim();//SegEquipment
            segmentString[16+sjstep]= words[0].substring(274 + step, 275 + step).trim();//SegEquipmentType
            segmentString[17+sjstep]= words[0].substring(275 + step, 280 + step).trim();//Miles
            segmentString[18+sjstep]= words[0].substring(280 + step, 283 + step).trim();//Stops
            segmentString[19 + sjstep] = DateUtils.hhmm2second(words[0].substring(283 + step, 287 + step).trim());
//            segmentString[23+sjstep]= words[0].substring(283 + step, 287 + step).trim();//SegElapsedTime
            segmentString[20+sjstep]= words[0].substring(287 + step, 290 + step).trim();//OperatingCarrier
            segmentString[21+sjstep]= words[0].substring(290 + step, 294 + step).trim();//OperatingFlightNumber
        }

//        temp[71]= words.substring(294,299);





//        System.out.println(words.length());
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<temp.length;i++){
            sb.append(temp[i]);
            sb.append(",");
        }
        sb=sb.deleteCharAt(sb.length()-1);
        sb.append(MidtFieldSegment.divline);
        int seg=1;
        for(int j=0;j<segmentString.length;j++){
            sb.append(segmentString[j]);

            if((j+1)%22==0){
                //增加表的关键字字段
                sb.append(",");
                sb.append(temp[0]);//agency
                sb.append(",");
                sb.append(temp[41]);//id
                sb.append(",");
                sb.append(temp[4]);//ProcessDate
                sb.append(",");
                sb.append(temp[6]);//RecordLocatorPNR
                sb.append(",");
                sb.append(String.valueOf(seg));
                sb.append("\n");
                seg++;
            }else{
                sb.append(",");
            }
        }

        return sb.toString();
    }

    public String dateFormat(String yyyyMMdd,String hhmm){

        return  DateUtils.string2HiveDateFormat(yyyyMMdd)+" "+DateUtils.hhmmFormat(hhmm);

    }
}
