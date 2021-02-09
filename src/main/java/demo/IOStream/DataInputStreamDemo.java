package demo.IOStream;

import java.io.*;

public class DataInputStreamDemo {


    public static void write() throws IOException {

        DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream("test/1.txt",true));
        int a=1;
        dataOutputStream.writeInt(a);
        float b=1.2f;
        dataOutputStream.writeFloat(b);
        dataOutputStream.close();
    }

    public static void read() throws IOException {
        DataInputStream dataInputStream=new DataInputStream(new FileInputStream("test/1.txt"));
        int i = dataInputStream.readInt();
        float v = dataInputStream.readFloat();
        System.out.println("int:"+i+",float:"+v);
        dataInputStream.close();
    }



    public static void main(String[] args) throws IOException {

        DataOutputStream dataOutputStream=new DataOutputStream(new FileOutputStream("test/1.txt",true));
        dataOutputStream.writeUTF("abv");
        dataOutputStream.close();
        DataInputStream dataInputStream=new DataInputStream(new FileInputStream("test/1.txt"));
        String s = dataInputStream.readUTF();
        dataOutputStream.close();
        System.out.println(s);

    }
}
