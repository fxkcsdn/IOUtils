package demo.IOStream;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {

    private ObjectInputStream ois;

    public static void main(String[] args) {
        char c=126;
        String s=Character.toString(c);
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
    }

}
