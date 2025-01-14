package utilities;

import java.util.Random;

public class ReusableMethods extends GlobalVars {
    Random random = new Random();


    public String generateRandomString(int minLength, int maxLength) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

    // Generate a random integer between min and max (inclusive)
    public int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("The minimum value cannot be greater than the maximum value.");
        }
        return random.nextInt(max - min + 1) + min;
    }
}
