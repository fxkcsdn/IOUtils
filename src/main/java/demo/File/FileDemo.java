package demo.File;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        // 文件路径（相对、绝对）、文件分隔符（不同环境）、文件名编码
        File file=new File("D:\\file\\a.txt");
        boolean canRead = file.canRead();
        System.out.println(canRead);
        // 返回由此抽象路径名表示的文件或目录的名称，如果路径名名称序列为空，则返回空字符串。
        System.out.println(file.getName());
        // 返回此抽象路径名的父路径名的路径名字符串，如果此路径名没有指定父目录，则返回 null。
        System.out.println(file.getParent());
        // 返回此抽象路径名的父路径名的抽象路径名
        File parentFile = file.getParentFile();

        System.out.println(file.getPath());
        // 因为所有在java.io中的类都是将相对路径名解释为起始于程序当前路径,项目路径
        File file2=new File("app");
        System.out.println("file2.getAbsolutePath():"+file2.getAbsolutePath());
        // 规范路径名
        File file3=new File("\\\\*\\/////app////\\\\");
        System.out.println("file3.getName():"+file3.getName());

    }
}
