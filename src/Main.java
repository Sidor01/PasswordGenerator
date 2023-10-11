import java.util.Scanner;

public class Main {

    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Generate generator = new Generate(input);
        generator.mainLoop();
        input.close();
    }
}