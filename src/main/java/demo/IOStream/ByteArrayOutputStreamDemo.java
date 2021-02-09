package demo.IOStream;

import java.io.*;

public class ByteArrayOutputStreamDemo {

    private static ByteArrayOutputStream bos=new ByteArrayOutputStream();

    static{
        byte[] b = new String("abcdefg").getBytes();
        try {
            bos.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String path)throws IOException {

        File file=new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos=new FileOutputStream(file);
        bos.writeTo(fos);
    }

    public static void resetWrite(String path) throws IOException {
        bos.reset();
        byte[] b = new String("f").getBytes();
        bos.write(b);
        writeToFile(path);
    }

    public static void testSize(){
        int size = bos.size();
        byte[] bytes = bos.toByteArray();
        System.out.println(size==bytes.length);
    }

    public static void main(String[] args) throws IOException {
        testSize();
    }
}
