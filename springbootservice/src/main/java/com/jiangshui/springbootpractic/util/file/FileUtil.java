package com.jiangshui.springbootpractic.util.file;

import java.io.File;
import java.io.IOException;

/**
 * @author xujiangshui
 * @Date on 2018/7/2 0002
 */
public class FileUtil {
    /**
     *  遍历目录
     */
    //IllegalArgumentException此异常表明向方法传递了一个不合法或不正确的参数
    public static void isFile(File file)throws IOException {
        if(!file.exists()){
            throw new IllegalArgumentException("目录"+file+"不存在");
        }
        if(!file.isDirectory()){
            throw new  IllegalArgumentException(file +"不是目录");
        }
        File[] filenames = file.listFiles();
        if(filenames!=null&&filenames.length>0) {
            for (File f : filenames) {
                if (f.isDirectory()) {
                    isFile(f);
                }else {
                    System.out.println(f);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        FileUtil.isFile(new File("F:\\a"));
    }
}
