import java.util.InputMismatchException;
import java.util.Scanner;

public class Navigate {

    public static Scanner navigator = new Scanner(System.in);


    /**
     *
     * @param nachricht
     * @return
     */
    static int number(String nachricht) {
        int choice;
        do {
            System.out.print(nachricht);
            try {
                choice = navigator.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("***Bitte gib eine Zahl ein.***");
                choice = -1;
                navigator.nextLine();
            }
        } while (choice < 0);

        return choice;
    }

    /**
     * no usages so far
     * @param nachricht
     * @return
     */
    static String string(String nachricht) {
        String input;
        System.out.print(nachricht);
        input = navigator.nextLine();
        return input;
    }
}