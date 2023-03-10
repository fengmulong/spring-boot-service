package com.lyd.util;

import com.lyd.entity.LuckyBall;
import com.lyd.entity.Ssq;
import com.lyd.service.SsqService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/**
 * @author liyd
 * @date 2023年02月23日 10:54
 */
@Component
public class SSQUtils {

    public List<LuckyBall> historyList(String endTime) {
        List<LuckyBall> list = new ArrayList<>();
        String url = "https://datachart.500.com/ssq/history/newinc/history.php?start=03001&end=" + endTime;
        //03001代表03年第一期彩票  21036代表21年第36期彩票
        Document doc = null;
        try {
            doc = Jsoup.connect(url).timeout(5000).get();
            Elements trs = doc.select("tbody[id=tdata]").select("tr");
            trs.forEach(e -> {
                Elements tds = e.select("td");
                LuckyBall luckyBall=new LuckyBall();
                luckyBall.setRed1(tds.get(1).text());
                luckyBall.setRed2(tds.get(2).text());
                luckyBall.setRed3(tds.get(3).text());
                luckyBall.setRed4(tds.get(4).text());
                luckyBall.setRed5(tds.get(5).text());
                luckyBall.setRed6(tds.get(6).text());
                luckyBall.setBlue(tds.get(7).text());
                list.add(luckyBall);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list= Arrays.asList("05","04","03","09","03","14");
        numberContent(list);
    }
    public static int numberContent(List<String> ErPoints){
        for(int i=0;i<ErPoints.size();i++){
            ErPoints.set(i,String.format("%04d", Integer.parseInt(ErPoints.get(i))));
        }
        List<String> 二进制=new ArrayList<>();
        for(int i=0;i<ErPoints.size();i++){
            if(i==ErPoints.size()-1){
                break;
            }
            int j=i+1;
            StringBuffer stringBuffer=new StringBuffer("");
            char[] er1=ErPoints.get(i).toCharArray();
            char[] er2=ErPoints.get(j).toCharArray();
            for(int t=0;t<er1.length;t++){
                if(er1[t]==er2[t]){
                    stringBuffer.append("1");
                }else{
                    stringBuffer.append("0");
                }
            }
            二进制.add(stringBuffer.toString());
        }
        StringBuffer  str=new StringBuffer("");
        for(String da:二进制) {
            str.append(Integer.parseInt(da,2)-1+",");
        }
        System.out.println(str);
        return 0;
    }
}
