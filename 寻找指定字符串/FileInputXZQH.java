import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import com.alibaba.fastjson.JSON;
/**
 * @ProjectName: BCDS
 * @Package: PACKAGE_NAME
 * @ClassName: FileInputXZQH
 * @Author: yuxingsheng
 * @Description:
 * 在指定文件目录中，搜索指定字符串，输出包含该字符串的txt文件名称及字符串所在行号。
 * 注意：
 * 	输出结果按文件名称升序排列（排序时不包含路径），文件名为包含系统绝对路径的完整名称；
 * 	如果文件名称相同，从最靠近文件的目录开始，升序排序；目录和Windows盘符比较时，盘符在后；
 * 	文件内容行号从1开始，行号使用String类型；
 * 示例：
 * 输入：目录名：E:/cop；关键字：exam2018
 * 输出：
 * E:\cop\lambo-plantform\lambo-cache\applicationContext-ehcache.txt
 * 3
 * E:\cop\lambo-plantform\applicationContext-ehcache.txt
 * 3
 * E:\cop\lambo-plantform\ehcache.txt
 * 7
 * 16
 * E:\cop\cigar-plantform\pom.txt
 * 4
 * E:\cop\lambo-plantform\lambo-cache\pom.txt
 * 4
 * @Date: 2020/1/8 11:08
 * @Version: 1.0
 */
public class FileInputXZQH {
   /* public static void main(String[] args) {
        String str=readFileContent("F:\\省级行政区划json.txt");
        str.replace("jsonp_location("," ");
        str.replace(");"," ");
                Map sjxz=  (Map)JSON.parse(str);
                System.out.println(sjxz.get("110000"));
                System.out.println(str);


    }
    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }*/
   static class FileNode{
        String filePath;//文件路径
        String line;//出现行数
        FileNode(){
            line="";
        }
    }
    static class FileNodeSort implements Comparator<FileNode> {

        @Override
        public int compare(FileNode o1, FileNode o2) {
            return o1.filePath.compareTo(o2.filePath);
        }
    }
     //统计文件中字符串出现的list 路径及行号
    private static ArrayList<FileNode> AppearFileList(File f, String word, ArrayList<FileNode> fns){
        File[]listFile=f.listFiles();
        if(null!=listFile){
            for(File file:listFile){
                if(file.isDirectory()){//如果文件是文件夹继续执行
                    AppearFileList(file,word,fns);
                }else{
                    try {
                        BufferedReader br=new BufferedReader(new FileReader(file));
                        FileNode fn=new FileNode();
                        String str;
                        for(int i=1;null!=(str=br.readLine());i++){
                            if(str.contains(word)){
                                fn.filePath=file.getAbsolutePath();
                                fn.line=fn.line.concat(Integer.toString(i)).concat(" ");

                            }
                        }
                        fns.add(fn);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return fns;
    }
    public static void test1(String fileName, String word){
        File f=new File(fileName);
        ArrayList<FileNode> fns=new ArrayList<>();
        fns=AppearFileList(f,word,fns);
        FileNode[]farray=new FileNode[fns.size()];
        fns.toArray(farray);
        FileNodeSort fs=new FileNodeSort();
        Arrays.sort(farray,fs);
        for(FileNode fo:farray){
            System.out.println(fo.filePath);
            System.out.println(fo.line);
        }
    }

    public static void main(String[] args) {
        test1("F:/测试","ok");
    }

}