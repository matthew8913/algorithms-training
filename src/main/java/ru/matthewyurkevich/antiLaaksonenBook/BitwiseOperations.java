package ru.matthewyurkevich.antiLaaksonenBook;

public class BitwiseOperations {
    public static void main(String[] args) {
        System.out.println(14 << 1); // Сдвиг влево
        System.out.println(14 >> 1); // Сдвиг вправо
        System.out.println(14 & 1);  // Побитовое И. Даёт 0 если число четное
        System.out.println(13 & 1);  // Побитовое И. Дает 1 если нет
    }
}