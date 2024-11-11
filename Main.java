import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    QuizService qs = new QuizService();

    System.out.println("""
      *************************************************************
      * WELCOME TO THE GREATEST MULTILINGUAL QUIZ OF ALL TIMES!!! *
      *************************************************************
      
      """);

    String input = "";
    while (true) {
      System.out.println("Enter anything to continue or type exit to quit: ");
      input = scanner.nextLine();
      if (input.contains("exit")) {
        System.exit(0);
      }

      String[] questionAnswer = qs.poseQuestionRng();
      System.out.println("Question: " + questionAnswer[0]);
      System.out.println("Press enter to get the answer or exit to quit: ");

      scanner.nextLine();
      if (input.contains("exit")) {
        System.exit(0);
      }
      System.out.println("Answer: " + questionAnswer[1]);
    }

  }
}
