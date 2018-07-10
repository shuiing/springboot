package com.jiangshui.springbootpractic.practice.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author xujiangshui
 * @Date on 2018/7/9 0009
 */
public class IOtest {
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
        File directory = new File("F:\\directory");
        if(!directory.exists())
            directory.mkdir();
        File file = new File(directory,"file.text");
        if(!file.exists())
            file.createNewFile();
        long start = System.currentTimeMillis();

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        System.out.println(raf.getFilePointer());
        raf.write('A');
        String s = "中";
        byte[] b = s.getBytes("utf8");
        raf.write(b);

        //读取文件，必须把指针移到头部
        raf.seek(0);
        //一次性读取，把文件中的内容都读到数组中
        byte[] buf = new  byte[(int)raf.length()];
        raf.read(buf);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

