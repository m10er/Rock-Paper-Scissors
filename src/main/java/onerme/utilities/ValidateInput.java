package onerme.utilities;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

import static onerme.service.Language.messages;

public class ValidateInput {
    public  static Scanner scanner = new Scanner(System.in);

    public static int getValidatedIntInput(int min, int max, String errorMessage) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }

    public static String getValidatedStringInput() {
        while (true) {
            String input = scanner.nextLine().trim();

            if (!input.isEmpty() && input.matches("[a-zA-Z ]+")) {
                if (input.length() <= 30) {
                    return input;
                } else {
                    System.out.println(messages.getString("maxLengthError"));
                }
            } else {
                System.out.println(messages.getString("invalidName"));
            }
        }
    }

    public static boolean getValidatedYesNoInput(String promptMessage, ResourceBundle messages) {
        while (true) {
            System.out.println(promptMessage);
            String response = scanner.nextLine().trim();

            if (response.equals("1")) {
                return true;
            } else if (response.equals("2")) {
                return false;
            } else {
                System.out.println(messages.getString("invalidInput"));
            }
        }
    }
}
