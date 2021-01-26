package util;

import java.io.File;
import java.io.IOException;

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
}
