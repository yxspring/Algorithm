import java.util.Scanner;

/**
 * @ProjectName: BCDS
 * @Package: PACKAGE_NAME
 * @ClassName: MonkeyEatPeach
 * @Author: yuxingsheng
 * @Description: 猴子吃桃子，一口1个，一口2个，假设有n个桃子，几口吃完？
 * @Date: 2020/1/7 14:47
 * @Version: 1.0
 */
public class MonkeyEatPeach {
    /**
     * method1 回溯算法
    * */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public int test2(){
        int count=0;
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        //创建二叉树
        TreeNode root=new TreeNode(0);//根节点的val 为0
        root=createTree(root,n,0);
        if(n<=0){
            return 0;
        }
        return hasPathSum(root,n,0);
    }
    public int hasPathSum(TreeNode root, int sum,int count) {
        int cnt=count;
        if(root==null){
            return cnt;
        }
        sum -= root.val;
        if (sum==0) {
            cnt++;
            return cnt;
        }
        cnt=hasPathSum(root.left, sum,cnt);
        cnt=hasPathSum(root.right, sum,cnt);
        return cnt;
    }
    private TreeNode createTree(TreeNode root,int n,int cnt){//树根  树的高度
        cnt=++cnt;
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        if (cnt>n){
            root.left=null;
            root.right=null;
        }else{
            createTree(root.left,n,cnt);
            createTree(root.right,n,cnt);
        }
        return root;
    }

    public static void main(String[] args) {
        MonkeyEatPeach mp=new MonkeyEatPeach();
       // System.out.println(mp.test2());
        Scanner in=new Scanner(System.in);
        System.out.println(f(in.nextInt()));
        // System.out.println(fx(in.nextInt()));
    }
    /**
     * method 2:递归 一行代码
     */
    public  static long f(long n){
        return n<=2?n:f(n-1)+f(n-2);
    }
}
