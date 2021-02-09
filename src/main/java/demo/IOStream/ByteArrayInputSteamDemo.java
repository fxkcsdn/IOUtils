package demo.IOStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ByteArrayInputSteamDemo {


    public static void read(){
        byte[] b=new String("abcdefg").getBytes();
        ByteArrayInputStream bis=new ByteArrayInputStream(b);
        byte[] b2=new byte[4];
        bis.read(b2,2,2);
        System.out.println(new String(b2));
    }

    public static void testReset(int readLimit,int resetNumber){
        // 标记重置
        byte[] b=new String("abcdefg").getBytes();
        ByteArrayInputStream bis=new ByteArrayInputStream(b);
        bis.mark(readLimit);
        for(int i=0;i<resetNumber;i++){
            int c = bis.read();
            System.out.println((char) c);
        }
        bis.reset();
        for(int i=0;i<resetNumber;i++){
            int c = bis.read();
            System.out.println((char) c);
        }
    }

    public static void main(String[] args) {
        testReset(3,4);
    }


}
