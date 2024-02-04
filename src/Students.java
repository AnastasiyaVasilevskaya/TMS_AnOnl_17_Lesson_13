//2. Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
// С помощью Stream'ов:
// - Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
// - Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
// - Отсортировать и вернуть первый элемент коллекции или "Empty@, если коллекция пуста

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Students {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        students.add("Дима");
        students.add("дима");
        students.add("дИмА");
        students.add("Оля");
        students.add("Илья");
        students.add("артем");
        students.add("Маша");
        students.add("Артур");
        students.add("антон");

        System.out.println("Список студентов: " + students);

        long nameDima = students.stream()
                .filter(x -> x.equalsIgnoreCase("Дима"))
                .count();

        System.out.println("Число студентов с именем Дима: " + nameDima);

        List<String> namesStartsA = students.stream()
                .filter(x -> x.startsWith("а") || x.startsWith("А"))
                .toList();

        System.out.println("Студенты с именем на а/A: " + namesStartsA);

        String firstSortedName = students.stream()
                .min(String::compareToIgnoreCase)
                .orElse("Empty@");

        System.out.println("Первое имя в отсортированном списке: " + firstSortedName);
    }
}

