import java.util.Scanner;

public class Test {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите выражение арабскими или римскими цифрами:");
        String input = in.nextLine();
        String[] operations = new String[5];
        operations = input.split("[+-/*]");
        System.out.printf(operations[1], operations[3]);

    }
}
