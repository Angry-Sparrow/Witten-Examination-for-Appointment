//import java.util.Scanner;
//
///**
// * 多重背包
// * 多重和完全更接近，多了数量的限制，用一个count[n]计数数组来限制物品i的数量。
// * 当放入第i个物品是较优值的时候，count[i]=count[j-weight[i]]+1（j 的含义：）;
// * 这样做是因为，放入第i个物品的操作是基于count[j-weight[i]]放入的，
// * 所以当count[i-weight[i]]>=amount[i]时，就要阻止放入即便放入第i个物品是较优值
// */
//public class backpack03 {
//    public static void main(String[] args) {
///*        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();//物品种类个数
//        int [] weight = new int[n];//重量
//        int [] value = new int[n];//价值
//        for (int i = 0; i < n; i++) {
//            weight[i] = in.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            value[i] = in.nextInt();
//        }
//        int target = in.nextInt();//背包容量*/
//        int n = 3;
//        int [] value = {100,1,2}; //每种物品的满意度
//        int [] weight = {26,5,5}; //每种物品的价格
//        int target = 100;
//        int [] account = {4,4,2};//每种物品的数量
//        int[] arr = new int[target + 1];
//        //依次轮转，把当背包中有一个、二个、三个，，，
//        for (int i = 0; i < n; i++) {  // i 表示背包中可以放前（i + 1） 种物品
//            // 完全背包问题
//            if(weight[i] * account[i] >= target){
//                for (int j = weight[i]; j <= target; j++) {
//                    arr[j] = Math.max(arr[j],arr[j - weight[i]] + value[i]);
//                }
//                return;
//            }
//            //01背包问题，并使用二进制方法进行优化
//            int tmpCount = 1;
//            while (tmpCount < account[i]){
//                for (int j = target; j >= tmpCount * weight[i]; j--) {  // j 表示当前背包的容量
//                    arr[j] = Math.max(arr[j],arr[j - tmpCount * weight[i]] + tmpCount * value[i]);
//                }
//                account[i] -= tmpCount;
//                tmpCount = tmpCount << 1;
//            }
//            for (int j = target; j >= weight[i]; j--) {  // j 表示当前背包的容量
//                arr[j] = Math.max(arr[j],arr[j - weight[i]] + value[i]);
//            }
//
//        }
//        for (int i = 0; i <= target; i++) {
//            System.out.print(arr[i] + " ");
//        }
//
//    }
//}

import java.util.Scanner;

public class backpack01 {

    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int casenum = in.nextInt();//case种类
        while(casenum-- > 0){
            int number = in.nextInt(); //游戏的数目
            int sum = in.nextInt(); //总价值
            int [] value = new int[number];;
            int [] weight = new int[number];;
            for(int i = 0;i<number;i++){
                value[i] = in.nextInt();
                weight[i] = in.nextInt();

            }
            System.out.println(ZeroOnePack2(sum,number,weight,value));
        }
    }
}


