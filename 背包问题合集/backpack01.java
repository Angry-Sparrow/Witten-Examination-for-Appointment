/**
 * Created by ${Lee} on 2019/8/6
 * 01背包问题，题目不做赘述
 */
import java.util.Scanner;
public class Backpack01 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            int[] value = new int[n];
            int[] weight = new int[n];
            for (int i = 0;i < n;i++){
                value[i] = sc.nextInt();
                weight[i] = sc.nextInt();
            }
            System.out.println(gameSolution(w,n,weight,value));

        }

    }

    public static int gameSolution(int w,int n ,int[] weight,int[] value){
        int[] dp = new int[w + 1];
        for (int i = 1; i < n+1 ; i++){
            for (int j = w;j >= weight[i - 1];j--){
                dp[j] = Math.max(dp[j-weight[i - 1]] + value[i - 1],dp[j]);
            }
        }
        return dp[w];
    }

}
