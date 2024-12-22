package ru.matthewyurkevich.antiLaaksonenBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализация рекурсивной генерации перестановок. Работает примерно также, как и генерация подмножеств.
 * Только в данном случае в конце концов мы включаем все элементы в выходное множество. То есть на каждом шаге
 * рекурсии мы решаем, будет ли текущий элемент стоять на данной позиции или не будет. Рассматриваем оба варианта.
 * Если он не будет стоять - на следующем шаге - всё равно он будет помечен как не выбранный и в конечном итоге используется.
 */
public class GeneratePermutations {
    public static void main(String[] args) {
        generatePermutations(Arrays.asList(1, 2, 3, 4), new boolean[10], new ArrayList<>());
    }

    public static void generatePermutations(List<Integer> originalList, boolean[] chosen, List<Integer> currentPermutation) {
        // Если мы собрали перестановку - печатаем
        if (currentPermutation.size() == originalList.size()) {
            System.out.println(currentPermutation);
        } else {
            // Грубо говоря рассматриваем все невыбранные элементы в множестве
            for (int i = 0; i < originalList.size(); i++) {
                if (chosen[i]) {
                    continue;
                }
                // Можем на данном этапе включить элемент в перестановку
                chosen[i] = true;
                currentPermutation.add(originalList.get(i));
                generatePermutations(originalList, chosen, currentPermutation);

                // Можем не включать (всё равно рано или поздно включим)
                chosen[i] = false;
                currentPermutation.removeLast();
            }
        }
    }
}