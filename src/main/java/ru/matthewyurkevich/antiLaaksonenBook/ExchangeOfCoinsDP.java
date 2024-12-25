package ru.matthewyurkevich.antiLaaksonenBook;

public class ExchangeOfCoinsDP {
    private static final int MAX_VALUE = Integer.MAX_VALUE - 10000;
    private static boolean[] ready;
    private static int[] value;

    public static int solveRecursive(int sum, int[] coins) {
        if (sum < 0) return MAX_VALUE;

        if (sum == 0) return 0;

        if (ready[sum]) return value[sum];

        int best = MAX_VALUE;
        for (int coin : coins) {
            best = Math.min(best, solveRecursive(sum-coin, coins) + 1);
        }

        ready[sum] = true;
        value[sum] = best;
        return best;
    }

    public static int solveIteratively(int sum, int[] coins) {
        // Инициализация массива value
        for (int i = 0; i <= sum; i++) {
            value[i] = MAX_VALUE;
        }
        value[0] = 0; // Базовый случай: сумма 0 требует 0 монет

        // Итерационный процесс
        for (int subSum = 1; subSum <= sum; subSum++) {
            for (int coin : coins) {
                if (subSum - coin >= 0) {
                    value[subSum] = Math.min(value[subSum], value[subSum - coin] + 1);
                }
            }
        }

        // Возвращаем результат для заданной суммы
        return value[sum];
    }

    public static void main(String[] args) {
        int[] coins = {1,3,4};
        int sum = 10;
        ready = new boolean[sum + 1];
        value = new int[sum + 1];
        long start = System.nanoTime();
        int result = solveRecursive(sum, coins);
        long end = System.nanoTime();

        System.out.println("Result: " + result);
        System.out.println("Time: " + (end - start) + " ns");

        result = solveIteratively(sum, coins);
        System.out.println("Result: " + result);
    }
}