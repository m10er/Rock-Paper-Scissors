package onerme.utilities;

import onerme.service.Language;

public class ValidateInput {
    private InputProvider provider;

    public ValidateInput(InputProvider provider) {
        this.provider = provider;
    }

    public int getValidatedIntInput(int min, int max, String errorMessage) {
        while (true) {
            try {
                String value = provider.getInput();
                int input = Integer.parseInt(value);
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println(errorMessage);
                }
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public String getValidatedStringInput() {

        while (true) {
            String input = provider.getInput();

            if (!input.isEmpty() && input.matches("[a-zA-Z ]+")) {
                if (input.length() <= 30) {
                    return input;
                } else {
                    System.out.println(Language.messages.getString("maxLengthError"));
                }
            } else {
                System.out.println(Language.messages.getString("invalidName"));
            }
        }
    }

    public boolean getValidatedYesNoInput(String promptMessage) {

        while (true) {
            System.out.println(promptMessage);
            String response = provider.getInput();

            if (response.equals("1")) {
                return true;
            } else if (response.equals("2")) {
                return false;
            } else {
                System.out.println(Language.messages.getString("invalidInput"));
            }
        }
    }
}
