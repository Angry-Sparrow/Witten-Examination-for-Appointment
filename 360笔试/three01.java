import java.util.Scanner;

public class three01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] x = new int[N + 2][M + 2];
        int[][] y = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int mianji = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                x[i][j] = in.nextInt();
                if (x[i][j] > 0) {
                    mianji++;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (x[i][j] > x[i + y[k][0]][j + y[k][1]]) {
                        mianji += x[i][j] - x[i + y[k][0]][j + y[k][1]];
                    }
                }
            }
        }
        System.out.println(mianji + M * N);
    }
}
