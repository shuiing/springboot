package com.jiangshui.springbootpractic.practice.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author xujiangshui
 * @Date on 2018/7/4 0004
 */
public class socketTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());

        try {
            //创建一个URL实例
            URL url = new URL("https://www.baidu.com");
            //通过openStream获取URL对象所表示的资源的字节输入流
            InputStream is = url.openStream();
            //字节流转为字符流
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader isb = new BufferedReader(isr);
            String date = isb.readLine();
            while(date!=null){
                date= isb.readLine();
                System.out.println(date);
            }
                isb.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
