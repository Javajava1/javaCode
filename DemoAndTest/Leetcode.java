package edu.nwpu.zhao.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author:weilongzhao
 * @time:2021/7/15 21:38
 */

class TreeNode{
    private int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
public class Leetcode {
    public static void main(String[] args) {
        int[] arr = {1,7,3,5,6};
        //System.out.println(arrayCenterIndex(arr));
        int[] array = {-9,-8,0,1,2,2,3,3,3,4,4,4,4};
        //System.out.println(deleteDuplicatedElements(array));;
        //System.out.println((int)newton(1,10));
        //System.out.println(maxResultOfThereMultiple(array));
  //      int [] pos = twoNumsEqualsTarget(arr,13);
//        for (int i = 0; i < pos.length; i++) {
//            System.out.print(pos[i]+" ");
//        }
        //System.out.println(Fibonacci(10));
//        TreeNode root = generate();
//        System.out.println(minDeep2(root));
//        System.out.println(minDeep(root));
        //int []bills = new int[]{5,10,5,10,20};
        //System.out.println(isCharge(bills));
        System.out.println(maxCircleOfTriangle(arr));
    }
    /**
     * @author:weilongzhao
     * @time:2021/7/15
     * */
    private static int maxCircleOfTriangle(int []arr){
        Arrays.sort(arr);
        for(int i = arr.length-1;i>=2;i--){
            if(arr[i] < arr[i-1] + arr[i-2]){
                return arr[i] + arr[i-1] + arr[i-2];
            }
        }
        return -1;
    }
    private static boolean isCharge(int []arr){
        int five = 0,ten = 0;//5元面值0张，10元面值0张

        for(int bill:arr){
            if(bill == 5){
                five++;
            }else if(bill == 10){
                if(five>0){
                    five--;
                }else{
                    return false;
                }
            }else if(bill == 20){
                if(five>0 && ten > 0){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    private static int minDeep2(TreeNode root){
        TreeNode[] nodeQueue = new TreeNode[100];
        TreeNode tmp = null;
        int level = 0;
        int first = -1,last = 0;
        int levelEnd = last;
        if (root == null){
            return 0;
        }
        nodeQueue[last] = root;
        while(first<last){
            tmp = nodeQueue[++first];
            if(tmp.left==null && tmp.right==null){
                return level+1;
            }
            if(tmp.left!=null){//子节点入队
                nodeQueue[++last] = tmp.left;
            }
            if(tmp.right!=null){
                nodeQueue[++last] = tmp.right;
            }
            if(first == levelEnd){//一层已结束
                level++;
                levelEnd = last;
            }
        }
        return level;
    }
    private static int minDeep(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){//叶子节点
            return 1;
        }
        int tmp1 = Integer.MAX_VALUE,tmp2 = Integer.MAX_VALUE;
        if(root.left!=null){
            tmp1 = minDeep(root.left);
        }
        if(root.right!=null){
            tmp2 = minDeep(root.right);
        }
        return Math.min(tmp1,tmp2)+1;
    }
    private static TreeNode generate(){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node4 = new TreeNode(4,node5,node6);
        TreeNode node3 = new TreeNode(3,node4,null);
        TreeNode node2 = new TreeNode(2,null,node7);
        TreeNode node1 = new TreeNode(1,node2,node3);
        return node1;
    }
    private static int Fibonacci(int n){
        if (n==0) return 0;
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2;i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    private static int Fibonacci2(int n){
        int []arr = new int[n+1];

        return recurse(arr,n);
    }

    private static int recurse(int []array,int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(array[n]!=0){
            return array[n];
        }
        array[n] = recurse(array,n-1) + recurse(array, n-2);
        return array[n];
    }

    private static int[] twoNumsEqualsTarget(int[] arr,int target){//利用HashMap 存储已经遍历的值，这样当是真正的答案时，可以直接取出
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i = 0;i<arr.length;i++){
            if(hashMap.containsKey(target-arr[i])){
                return new int[]{i,hashMap.get(target-arr[i])};
            }
            hashMap.put(arr[i],i);
        }
        return new int[]{-1,-1};
    }
    private static double newton(double i,int x){//牛顿迭代法
        double res = (i+x/i)/2;
        if (res == i){
            return res;
        }
        return newton(res,x);
    }
    private static int maxResultOfThereMultiple(int []arr){//寻找一个数组中的三个数字,使得它们的乘积最大
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE-1;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE+1,max3 = Integer.MIN_VALUE+2;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<min1){
                min2 = min1;
                min1 = arr[i];
            }else if(arr[i]<min2){
                min2 = arr[i];
            }
            if(arr[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i]>max2){
                max3 = max2;
                max2 = arr[i];
            }else if(arr[i]>max3) {
                max3 = arr[i];
            }
        }
        return Math.max(min1 * min2 * max1,max1 * max2 * max3);

    }
    private static int arrayCenterIndex(int[] arr) {
        int total = 0;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        for(int i = 0;i<arr.length;i++){
            total += arr[i];
            if(total == sum){
                return i;
            }
            sum -= arr[i];
        }
        return -1;
    }
    public static int deleteDuplicatedElements(int[] array){
        int len = array.length;
        int count = 1;
        int j = 0;//慢游标
        for (int i = 1;i<len;i++,j++){
            if(array[i]!=array[j]){
                count++;
            }
        }
        return count;
    }
}
