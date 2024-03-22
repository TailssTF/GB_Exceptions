import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные:");
        String next = scanner.nextLine();

        String[] split = next.split(" ");
        try {
            validateLength(split);

            Person person = new Person(split);

            String fn = split[0] + ".txt";

            try (FileWriter fw = new FileWriter(fn, true)){
                fw.write(person.toString());
                fw.flush();
                System.out.println("Успешно добавлено");
            } catch (IOException e) {
                throw new RuntimeException();
            }
        } catch (MyInputException e) {
            e.printStackTrace();
        }

    }

    private static void validateLength(String[] s) throws MyInputException {
        if (s.length != 6) throw new MyInputException("Некорректное количество данных");
    }
}