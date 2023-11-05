```C#
using System;

class Program
{
    static void Main(string[] args)
    {
        Console.Write("Enter the amount: ");
        int amount = Convert.ToInt32(Console.ReadLine());

        int[] coins = new int[] { 1, 5, 10, 25 };
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++)
        {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.Length; j++)
            {
                if (coins[j] <= i)
                {
                    dp[i] = Math.Min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        int result = dp[amount] > amount ? -1 : dp[amount];
        Console.WriteLine("Minimum number of coins needed: " + result);
    }
}
```