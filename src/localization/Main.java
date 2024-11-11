package localization;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Choose a language: ");
            System.out.println("1. English");
            System.out.println("2. Spanish");
            System.out.println("3. German");

            int choice = scanner.nextInt();
            Locale locale;

            switch (choice) {
                case 1:
                    locale = new Locale("en", "US"); // English
                    break;
                case 2:
                    locale = new Locale("es", "ES"); // Spanish
                    break;
                case 3:
                    locale = new Locale("de", "DE"); // German
                    break;
                default:
                    locale = new Locale("en", "US"); // Default to English
                    System.out.println("Invalid choice. Defaulting to English.");
            }

            QuizService quizService = new QuizService(locale);
            quizService.askQuestions();
        }
    }
}
