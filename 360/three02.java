
import java.util.Scanner;
import java.util.Arrays;
public class three02 {
        public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0 ; i < n; i++){
            arr1[i] = in.nextInt();
        }
        for(int j = 0; j < n; j++){
            arr2[j] = in.nextInt();
        }
        int[][] arr3 = new int[n][n];
        int[] arr4 = new int[n];
        for(int ii = 0; ii < n; ii++){
            for(int jj = 0; jj < n; jj++){
                arr3[ii][jj] = (arr1[ii] + arr2[jj]) % m;
            }
        }
        for(int pos = 0; pos<n;pos++){
            int px = 0;
            int py = 0;
            for(int ii = 0; ii < n; ii++){
                for(int jj = 0; jj < n; jj++){
                    if(arr4[pos] < arr3[ii][jj]){
                        arr4[pos] = arr3[ii][jj];
                        px = ii;
                        py = jj;
                    }
                }
            }
            for(int i = 0;i < n;i++){
                for(int j=0;j<n;j++){
                    if(i == px || j == py){
                        arr3[i][j] = -1;
                    }
                }
            }
        }
        Arrays.sort(arr4);
        for(int r = n-1; r >= 0; r--){
            System.out.print(arr4[r]);
            System.out.print(" ");
        }
    }
}