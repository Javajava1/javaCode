package edu.nwpu.zhao.Test;

/**
 * @author:weilongzhao
 * @time:2021/7/15 21:38
 */
public class Leecode {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        //System.out.println(arrayCenterIndex(arr));
        int[] array = {0,1,2,2,3,3,3,4,4,4,4};
        System.out.println(deleteDuplicatedElements(array));;
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
