import java.util.Random;

public class Randomizer {
    private static final String ZEICHEN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    public static String randomString(int laenge) {
        StringBuilder sb = new StringBuilder(laenge);
        for (int i = 0; i < laenge; i++) {
            int index = RANDOM.nextInt(ZEICHEN.length());
            sb.append(ZEICHEN.charAt(index));
        }
        return sb.toString();
    }
}