package ru.matthewyurkevich.antiLaaksonenBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализации рекурсивной генерации подмножеств. Идея в том, что каждый элемент множества может быть либо включен
 * в подмножество, либо нет. Таким образом на каждом уровне рекурсии у нас идет разветвление: включаем/не включаем элемент.
 */
public class GenerateSubsets {
    public static void main(String[] args) {
        List<Integer> set = Arrays.asList(1, 2, 3);
        generateSubSets(set, new ArrayList<>(), 0);
    }

    public static void generateSubSets(List<Integer> originalSet, List<Integer> currentSubset, int index) {
        if (index == originalSet.size()) {
            System.out.println(currentSubset);
        } else {
            // Добавляем элемент в подмножество
            currentSubset.add(originalSet.get(index));
            generateSubSets(originalSet, currentSubset, index + 1);
            // Удаляем элемент
            currentSubset.removeLast();

            // Рассматриваем варианты без этого элемента
            generateSubSets(originalSet, currentSubset, index + 1);
        }
    }
}