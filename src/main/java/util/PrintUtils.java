package util;

import java.util.Collection;

public class PrintUtils {

    /**
     * 数据与显示分离
     * 格式化集合列表，参数是泛型列表，支持对象，输出格式化的字符串，如果参数为空，则返回“[]”
     * @param c
     */
    public static String convertToString(Collection<?> c){
        if(c==null ||c .size()==0){return "[]";};
        StringBuilder sb=new StringBuilder("[");
        for(Object item:c){
            sb.append("{");
            sb.append(item);
            sb.append("},\n");
        }
        sb.substring(0,sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

}
