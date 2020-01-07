import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * DNA sorting
 * @ProjectName: BCDS
 * @Package: PACKAGE_NAME
 * @ClassName: ShangwuYuxingsheng
 * @Author: yuxingsheng
 * @Description: 于兴胜
 * 描述
 * One measure of ``unsortedness'' in a sequence is the number of pairs of entries that are out of order with respect to each other. For instance, in the letter sequence ``DAABEC'', this measure is 5, since D is greater than four letters to its right and E is greater than one letter to its right. This measure is called the number of inversions in the sequence. The sequence ``AACEDGG'' has only one inversion (E and D)---it is nearly sorted---while the sequence ``ZWQM'' has 6 inversions (it is as unsorted as can be---exactly the reverse of sorted).
 * You are responsible for cataloguing a sequence of DNA strings (sequences containing only the four letters A, C, G, and T). However, you want to catalog them, not in alphabetical order, but rather in order of ``sortedness'', from ``most sorted'' to ``least sorted''. All the strings are of the same length.
 *
 * 输入
 * The first line contains two integers: a positive integer n (0 < n <= 50) giving the length of the strings; and a positive integer m (0 < m <= 100) giving the number of strings. These are followed by m lines, each containing a string of length n.
 * 输出
 * Output the list of input strings, arranged from ``most sorted'' to ``least sorted''. Since two strings can be equally sorted, then output them according to the orginal order.
 * 样例输入
 * 10 6
 * AACATGAAGG
 * TTTTGGCCAA
 * TTTGGCCAAA
 * GATCAGATTT
 * CCCGGGGGGA
 * ATCGATGCAT
 * 样例输出
 * CCCGGGGGGA
 * AACATGAAGG
 * GATCAGATTT
 * ATCGATGCAT
 * TTTTGGCCAA
 * TTTGGCCAAA
 * @Date: 2020/1/7 11:47
 * @Version: 1.0
 */
public class ShangwuYuxingsheng {
    public ShangwuYuxingsheng(){

    }
    class DNA{
        String line;//字符串
        int leve;//度数
    }
    class DNAType implements Comparator<DNA> {
        @Override
        public int compare(DNA arg1, DNA arg2) {
          return arg1.leve-arg2.leve;
        }
    }
    public void test1(){
       Scanner in=new Scanner(System.in);
       String s=in.nextLine();
       String[] str=s.split(" ");
       int col=Integer.parseInt(str[0]);
       int row=Integer.parseInt(str[1]);
       DNA[] na=new DNA[row];
       for(int i=0;i<row;i++){
           na[i]=new DNA();
           String line="";
           line=in.nextLine();
           na[i].line=line;
           na[i].leve=getLineLeve(line);
       }
       DNAType dt=new DNAType();
       Arrays.sort(na,dt);
       for(int i=0;i<row;i++){
           System.out.println(na[i].line);
       }
    }

    private int getLineLeve(String line) {
        int count=0;
        for(int i=0;i<line.length();i++){
            for(int j=i+1;j<line.length();j++){
                if(line.charAt(i)>line.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ShangwuYuxingsheng yu=new ShangwuYuxingsheng();
        yu.test1();
    }
}
