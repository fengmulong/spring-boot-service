package com.step.template.main.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

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
                   //具體使用
                }
            }
        }
    }
}
