package demo.File;

import util.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 用户查找具有特定扩展名的文件,传递给构造器的ext参数
 * 当它找到匹配的文件，则直接将文件传递给strategy对象，也是构造器参数strategy
 *
 */
public class ProcessFile {

    /**
     * 因为接口是不能实例化的，内部接口只有当它是静态的才有意义。因此，默认情况下，内部接口是静态的，不管你是否手动加了static关键字。
     * 区别于内部类，非静态内部类需要先实例化外部类，才能创建内部类。
     */
    public interface Strategy{
        void process(File file);
    }

    /**
     * 文件扩展名
     */
    private String ext;

    private Strategy strategy;

    public ProcessFile(String ext,Strategy strategy){
        this.ext=ext;
        this.strategy=strategy;
    }

    public void start(String path) throws IOException {
        File file=new File(path);
        if(file.isDirectory()){
            processDirectoryTree(file);
        }else{
            String filePath=path+"."+ext;
            strategy.process(new File(filePath).getCanonicalFile());
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        // 获取目录树，与处理策略分离
        for(File item:FileUtils.walk(root.getAbsolutePath(), ".*\\."+ext)){
            strategy.process(item.getCanonicalFile());
        }
    }

    public static void main(String[] args) throws IOException {
        // 查找修改时间在2021-1-29 13:00之后的文件
        new ProcessFile("txt", new Strategy() {
            public void process(File file) {
                if(file.lastModified()>1611896400000L)
                System.out.println(file.getName());
            }
        }).start("test");
    }


}
