Here is a Python console application that solves the problem:

```python
def min_coins(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0

    for coin in coins:
        for x in range(coin, amount + 1):
            dp[x] = min(dp[x], dp[x - coin] + 1)

    return dp[amount] if dp[amount] != float('inf') else -1

def main():
    coins = list(map(int, input("Enter the coin denominations (separated by spaces): ").split()))
    amount = int(input("Enter the amount: "))
    result = min_coins(coins, amount)
    if result != -1:
        print("The minimum number of coins needed: ", result)
    else:
        print("The amount cannot be made up by given coins")

if __name__ == "__main__":
    main()
```

This console application first asks the user to input the coin denominations, separated by spaces. Then it asks for the amount for which the minimum number of coins is to be determined. It uses a dynamic programming approach to solve the problem. If the amount cannot be made up by the given coins, it prints a message indicating so.