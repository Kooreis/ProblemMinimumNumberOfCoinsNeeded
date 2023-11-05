Here is a Java console application that solves the problem:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        int amount = scanner.nextInt();
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = coins.length;
        System.out.println("Minimum number of coins required: " + minCoins(coins, n, amount));
    }

    static int minCoins(int coins[], int m, int V) {
        int table[] = new int[V + 1];
        table[0] = 0;
        for (int i = 1; i <= V; i++)
            table[i] = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 0; j < m; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }
        }
        return table[V];
    }
}
```

This program uses dynamic programming to find the minimum number of coins needed to make a given amount. The user is asked to input the amount, and the program outputs the minimum number of coins needed. The coins array can be modified to represent the denominations of coins available.