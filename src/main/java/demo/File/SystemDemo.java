package demo.File;

public class SystemDemo {
    public static void main(String[] args) {
        // 获得程序当前路径,项目路径
        System.out.println(System.getProperty("user.dir"));
        // 名称分隔符
        System.out.println(System.getProperty("file.separator"));
        // 路径分隔符,在 UNIX 系统上，此字段为 ':',在  Microsoft Windows 系统上，它为 ';'
        // 此字符用于分隔以路径列表 形式给定的文件序列中的文件名
        System.out.println(System.getProperty("path.separator"));
    }
}
