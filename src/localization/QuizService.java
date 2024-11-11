package localization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuizService {

    private ResourceBundle quizBundle;

    public QuizService(Locale locale) {
        quizBundle = ResourceBundle.getBundle("localization/quiz", locale);
    }

       public void askQuestions() {
        Scanner scanner = new Scanner(System.in);


        System.out.println(quizBundle.getString("question1"));
        String answer1 = scanner.nextLine();
        checkAnswer("answer1", answer1);


        System.out.println(quizBundle.getString("question2"));
        String answer2 = scanner.nextLine();
        checkAnswer("answer2", answer2);


        System.out.println(quizBundle.getString("question3"));
        String answer3 = scanner.nextLine();
        checkAnswer("answer3", answer3);
    }

    private void checkAnswer(String key, String userAnswer) {
        String correctAnswer = quizBundle.getString(key);
        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect! The correct answer is: " + correctAnswer);
        }
        System.out.println(); // Blank line for readability
    }

}
