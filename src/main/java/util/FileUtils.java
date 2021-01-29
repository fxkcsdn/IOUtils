package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtils {

    public static boolean createFile(String path) throws IOException {
        File file=new File(path);
        if(file.exists()){
            return true;
        }
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        boolean newFile = file.createNewFile();
        return newFile;
    }

    /**
     * 递归查找所有匹配的文件
     * @param start 开始递归文件
     * @param regex 正则表达式
     * @return 查找所有匹配的文件
     */
    public static TreeInfo recurseDirs(File start,String regex){
        TreeInfo treeInfo=new TreeInfo();
        File[] files = start.listFiles();
        for(File item:files){
            if(item.isDirectory()){
                treeInfo.dirs.add(item);
                treeInfo.addTreeInfo(recurseDirs(item,regex));
            }else{
                if(item.getName().matches(regex))
                    treeInfo.files.add(item);
            }
        }
        return treeInfo;
    }

    /**
     * 查找目录下所有文件，采用的是递归形式
     * @param start 开始递归的路径
     * @return
     */
    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }



    /**
     * 查找目录下匹配的文件，采用的是递归形式
     * @param start 开始递归路径
     * @param regex 匹配的正则表达式
     * @return
     */
    public static TreeInfo walk(String start,String regex){
        return recurseDirs(new File(start),regex);
    }

    /**
     * 定义一个数据结构，里面包含文件列表和目录列表
     */
    public static class TreeInfo implements Iterable<File>{
        public List<File> dirs=new ArrayList<File>();
        public List<File> files=new ArrayList<File>();

        public void addTreeInfo(TreeInfo other){
            dirs.addAll(other.dirs);
            files.addAll(other.files);
        }

        // 便于打印数据结构的内容
        @Override
        public String toString() {
            return "TreeInfo{" +
                    "dirs=" + PrintUtils.convertToString(dirs) +
                    ", files=" + PrintUtils.convertToString(files) +
                    '}';
        }

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
    }

    public static void main(String[] args) {
        TreeInfo treeInfo = walk("test","1.*.bmp");
        System.out.println(treeInfo);
    }

}
