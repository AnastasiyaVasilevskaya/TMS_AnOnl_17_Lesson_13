import java.util.ArrayList;
import java.util.List;

//1. Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
//  С помощью Stream'ов:
//  - Удалить дубликаты
//  - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
//  - Каждый элемент умножить на 2
//  - Отсортировать и вывести на экран первых 4 элемента
//  - Вывести количество элементов в стриме
//  - Вывести среднее арифметическое всех чисел в стриме

public class Numbers {
    private final static int NUMBERS_OF_ELEMENTS = 100;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < NUMBERS_OF_ELEMENTS; i++) {
            numbers.add((int) (Math.random() * 40));
        }
        System.out.println("Исходный лист: " + numbers);

        List<Integer> newList = numbers.stream()
                .distinct()
                .filter(x -> x % 2 == 0 && x >= 7 && x <= 17)
                .peek(x -> System.out.print(x + " "))
                .map(x -> x * 2)
                .sorted()
                .limit(4)
                .toList();

        System.out.println("\nНовый лист: " + newList);
        System.out.println("Количество элементов в стриме: " + newList.size());
        System.out.println("Среднее арифметическое всех чисел в стриме: " + newList.stream().mapToDouble(Integer::doubleValue).average().orElse(0));


    }
}
