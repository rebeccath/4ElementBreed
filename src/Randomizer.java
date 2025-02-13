import java.util.Random;

public class Randomizer {
    private static final String ZEICHEN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();

    /**
     * Returns random String of upper case letters, lower case letters and numbers of variable length
     * Was created by chatGPT
     *
     * @param laenge specifies how long the random String is supposed to be.
     * @return random String
     */
    public static String randomString(int laenge) {
        StringBuilder sb = new StringBuilder(laenge);
        for (int i = 0; i < laenge; i++) {
            int index = RANDOM.nextInt(ZEICHEN.length());
            sb.append(ZEICHEN.charAt(index));
        }
        return sb.toString();
    }
}