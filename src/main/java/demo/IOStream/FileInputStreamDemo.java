package demo.IOStream;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;

/**
 * 文件输入流
 */
public class FileInputStreamDemo {

    private static FileInputStream fileInputStream1;
    private static FileInputStream fileInputStream2;
    private static FileInputStream fileInputStream3;

    static {
        try {
            // 只能用于文件，而非目录
            fileInputStream1=new FileInputStream("test/1.txt");
            fileInputStream2=new FileInputStream("test/1.txt");
            fileInputStream3=new FileInputStream("test/1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void testRead() throws IOException {
        // 读取单个字节，关闭
        int c = 0;
        while((c=fileInputStream1.read())!=-1){
            System.out.println((char)c);
        }
        fileInputStream1.close();
    }

    public static void testReadArray() throws IOException {
        // 读取多个字节，关闭
        byte[] b=new byte[4];
        int c = 0;
        while((c=fileInputStream2.read(b))!=-1){
            System.out.println(new String(b));
        }
        fileInputStream2.close();
    }

    public static void testSync(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int read = fileInputStream1.read();
                    System.out.println(read);
                    Thread.sleep(6000);
                }catch (Exception e){}
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int read = fileInputStream2.read();
                    System.out.println(read);
                    Thread.sleep(6000);
                }catch (Exception e){}
            }
        }).start();
    }

    /**
     * FileInputSteam不支持reset
     * @param readLimit
     * @param resetNumber
     * @throws IOException
     */
    public static void testReset(int readLimit,int resetNumber) throws IOException {
        // 标记重置
//        fileInputStream3.mark(readLimit);
//        for(int i=0;i<resetNumber;i++){
//            int c = fileInputStream3.read();
//            System.out.println((char) c);
//        }
//        fileInputStream3.reset();
//        for(int i=0;i<resetNumber;i++){
//            int c = fileInputStream3.read();
//            System.out.println((char) c);
//        }
    }


    public static void main(String[] args) throws IOException {
        testSync();
    }

}
