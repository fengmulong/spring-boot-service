package com.step.template.main.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liyd
 * @date 2023年02月20日 14:52
 */
@Slf4j
public class FileUtils {

    public static void handerFile(File filePath, String fileName){
            try {
                fileDir(filePath,fileName);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.info("{}文件有问题，请检查图片配置",fileName);
            }
    }
    public static void fileDir(File filePath,String fileName) {
        File[] files = filePath.listFiles();
        for (File file : files) {
            if (file.isDirectory()){
                fileDir(file,fileName);
            }else{
                String path = file.getPath();
                String s = path.toLowerCase();
                boolean b = s.endsWith(fileName);
                if(b){
                    SendZHibo(file);
                    log.info("{}报表图片发送成功：",file.getName());
                }
            }
        }
    }


    public static void SendZHibo(File files) {
        Map<String, File> fileMap = new HashMap();
        log.info("excel源文件地址:{}", files.getPath());
        File file=ExcelToPng.ConvertPng(files.getPath());
        log.info("新文件地址:{}", file.getPath());
        fileMap.put("file", file);
        try {
           // HttpClientUtils.doFormPostFileTryThreeTimes(RyWeChatUtil.pushwechat_url, file.getName(), fileMap);
            log.info("{}报表生成图片 发送成功",file.getName());
        } catch (Exception e) {
            log.error("{}报表生成图片 发送失败",file.getName());
        }

    }
}
