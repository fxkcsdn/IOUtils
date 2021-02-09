package demo.IOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputSteamDemo {

    public static void write()throws IOException{
        // 直接覆盖原有文件
        FileOutputStream fos=new FileOutputStream("test/1.txt");
        byte[] b=new String("a").getBytes();
        fos.write(b);
        fos.close();
    }

    public static void appendWrite()throws IOException{
        // 直接覆盖原有文件
        FileOutputStream fos=new FileOutputStream("test/1.txt",true);
        byte[] b=new String("b").getBytes();
        fos.write(b);
        fos.close();
    }

    public static void testSync(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream fos=new FileOutputStream("test/1.txt",true);
                    byte[] b=new String("a").getBytes();
                    for(int i=0;i<10;i++){
                        fos.write(b);
                        System.out.println("a写完了");
                        Thread.sleep(1000);
                    }
                }catch (Exception e){}
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileOutputStream fos=new FileOutputStream("test/1.txt",true);
                    byte[] b=new String("b").getBytes();
                    for(int i=0;i<10;i++){
                        fos.write(b);
                        System.out.println("b写完了");
                        Thread.sleep(1000);
                    }
                }catch (Exception e){}
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        testSync();
    }
}
