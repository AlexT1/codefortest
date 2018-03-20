package com.alexstudy.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author AlexTong
 * @ClassName JxlDataService
 * @Description TODO()
 * @date 2018/3/9 15:54:11
 */
public class JxlDataService {

        private String readFileAsString(String filePath) throws IOException {
            StringBuffer fileData = new StringBuffer();
            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath));
            char[] buf = new char[1024];
            int numRead=0;
            while((numRead=reader.read(buf)) != -1){
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
            }
            reader.close();
            return fileData.toString();
        }
    public static String readStream(InputStream is) {
        StringBuilder sb = new StringBuilder(512);
        try {
            Reader r = new InputStreamReader(is, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
        public static void main(String[] args){
            JxlDataService jxlDataAnalyseService = new JxlDataService();

            String reportdata = null;
            try {
                reportdata = reportdata == null ? jxlDataAnalyseService.readFileAsString("C:\\Users\\dixin\\Desktop\\lxVB_g2rSL-OyWPtwwWUlA.txt") :null;
                String rawdata = jxlDataAnalyseService.readFileAsString("C:\\Users\\dixin\\Desktop\\Y_k2nLO3TcmJ4TSFlbO59Q.txt");
//                reportdata = jxlDataAnalyseService.readFileAsString("C:\\Users\\dixin\\Desktop\\lxVB_g2rSL-OyWPtwwWUlA.txt");

            } catch (IOException e) {
                e.printStackTrace();
            }
            
    }

}
