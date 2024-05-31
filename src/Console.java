import java.util.Scanner;

public class Console {
    private static Scanner key = new Scanner(System.in);

    public static void write(Object x) {
        System.out.println(x);
    }

    public static String readString(String message) {
        Console.write(message);
        return key.nextLine();
    }

    public static int readInt(String message) {
        Console.write(message);
        return key.nextInt();
    }

    public static float readFloat(String message) {
        Console.write(message);
        return key.nextFloat();
    }

    public static void clean() {
        key.nextLine();
    }
}