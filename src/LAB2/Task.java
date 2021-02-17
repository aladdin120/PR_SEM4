package LAB2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

    public Task() {
        List<Human> input = new ArrayList<>();
        Random random = new Random();
        String[] names = {"Steven", "Henry", "Elon", "Isaac"};
        String[] surnames = {"Hawking", "Ford", "Mask", "Newton"};
        LocalDate[] birth = {LocalDate.of(1942, Month.JANUARY, 8), LocalDate.of(1863, 7, 30), LocalDate.of(1971, 6, 28), LocalDate.of(1643, Month.JANUARY, 4)};
        for(int i = 0; i < 4; i++) {
            input.add(new Human(random.nextInt(70)+30, random.nextInt(70)+30, names[i], surnames[i], birth[i]));
        }
        System.out.println("Изначальный массив");
        input.stream()
                .forEach(System.out::println);
        System.out.println("1 этап");
        input.stream()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("2 этап");
        input.stream()
                .limit(3)
                .sorted(Comparator.comparing(Human::getBirhdate))
                .forEach(System.out::println);
        System.out.println("3 этап");
        input.stream()
                .limit(3)
                .sorted(Comparator.comparing(Human::getBirhdate))
                .filter(human->human.getWeight() > 60)
                .forEach(System.out::println);
        System.out.println("4 этап");
        input.stream()
                .limit(3)
                .sorted(Comparator.comparing(Human::getBirhdate))
                .filter(human->human.getWeight() > 60)
                .forEach(human -> System.out.println(human.getFirstName()+" "+human.getLastName()));
    }
}
