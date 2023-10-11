import java.util.Objects;
import java.util.Scanner;


public class Generate {
    Alphabet alphabet;

    public static Scanner input;

    public Generate(Scanner scanner){
        input = scanner;
    }
    private void processPassword(){
        boolean uppercaseInput = false;
        boolean lowercaseInput = false;
        boolean numbersInput = false;
        boolean symbolsInput = false;
        boolean correctData = true;

        System.out.println("\nFor next questions answer with yes/no.\n");

        System.out.println("\nDo you want to use uppercase letters in your password(e.g. ABCD)?\n");

        String answer = input.next();

        do {
            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                answerError(answer);
                answer = input.next();
            }
            if (IncludeValue(answer))
                uppercaseInput = true;

            System.out.println("\nDo you want to use lowercase letters in your password(e.g. abcd)?\n");

            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                answerError(answer);
                answer = input.next();
            }
            if (IncludeValue(answer))
                lowercaseInput = true;

            System.out.println("\nDo you want to use numbers in your password(e.g. 1234)?\n");

            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                answerError(answer);
                answer = input.next();
            }
            if (IncludeValue(answer))
                numbersInput = true;

            System.out.println("\nDo you want to use symbols in your password(e.g. !@#$)?\n");

            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                answerError(answer);
                answer = input.next();
            }
            if (IncludeValue(answer))
                symbolsInput = true;

            if (!uppercaseInput && !lowercaseInput && !numbersInput && !symbolsInput) {
                correctData = false;
                System.out.println("You have answered 4 times 'no' which means that program don't have any characters from which it can generate password\n" + "At least one 'yes' answer is needed.");
            }
        }while(!correctData);

        System.out.println("Enter password length.");
        int length = input.nextInt();

        final Generate generator = new Generate(uppercaseInput, lowercaseInput, numbersInput, symbolsInput);
        final Password password = generator.generatePassword(length);

        System.err.println("Your generated password:" + password);



    }
    public Generate(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean symbolsIncluded)
    {
        alphabet = new Alphabet(uppercaseIncluded,lowercaseIncluded,numbersIncluded,symbolsIncluded);
    }

    public void mainLoop(){
        System.out.println("Welcome to Password Generator.");
        printMenu();

        String userChoice = "-1";

        while(!userChoice.equals("4"))
        {
            userChoice = input.next();

            switch(userChoice) {
                case "1" -> {
                    processPassword();
                    printMenu();
                }
                case "2" -> {
                    printInfo();
                    printMenu();
                }
                case "3" -> printCloseMessage();
                default -> {
                    System.out.println();
                    System.out.println("Please select one of the available menu options in order to proceed.");
                    printMenu();
                }
            }

        }
    }
    private Password generatePassword(int length)
    {
        final StringBuilder password = new StringBuilder("");
        int passLength = length - 1;
        int min = 0;
        int range = passLength - min;

        for(int i = 0; i< length; i++)
        {
            int index = (int)(Math.random() * range) + min;
            password.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(password.toString());
    }

        private void printInfo()
    {
        System.out.println("1.Provide minimum 8 characters of password length.");
        System.out.println("2.You can use uppercase and lowercase letters, numbers and symbols.");
        System.out.println("Reminder: Don't share your password.");
        System.out.println("Try not to use dictionary keywords, keyboard patterns, or characters, numbers and symbols sequences.");
        System.out.println("Avoid using your sensitive data in password.");
    }
    private void printMenu() {
        System.out.println("1. - Generate Password");
        System.out.println("2. - General Information");
        System.out.println("3. - Close the program");
        System.out.println("Choice: ");
    }
    private void printCloseMessage()
    {
        System.out.println("Closing program...");
    }
    private void answerError (String i) {
        if (!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
            System.out.println("Answer you have provided is incorrect, try again... \n");
        }
    }
    private boolean IncludeValue(String answer)
    {
        if(answer.equalsIgnoreCase("yes"))
            return true;
        else
            return false;
    }
}
