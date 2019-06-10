package vivotest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Created by ${Lee} on 2019/6/8
 * 第一题：从 arr1 数组中去除掉 arr2 数组中含有的元素
 * java版
 */
public class exam1 {
    private static void solution(int[] arr1, int[] arr2){
        Set<Integer> setarr = new HashSet<>();
        List<Integer> list = new ArrayList<>();
//        先对arr2去重,用setarr来保存从arr2中提炼出来的，没有重复元素的数组
        for(int i : arr2){
            setarr.add(i);
        }
//        去除arr1中含有arr2的元素，将结果保存在可以存放重复元素的list中
        for(int j : arr1){
            if(!setarr.contains(j)){
                list.add(j);
            }
        }
//        for(int k = 0; k < list.size(); k++){
//            System.out.println(list.get(k) + " ");
//        }
//        以上注释部分可用以下一行替换
        list.forEach(System.out::println);
    }
    public static void main(String[] args){
        int arr1[] = {1,2,3,4,5,6,1,6,5};
        int arr2[] = {1,2,10};
        solution(arr1,arr2);
    }
}