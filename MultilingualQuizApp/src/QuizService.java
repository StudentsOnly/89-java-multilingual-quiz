import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class QuizService {
    private List<String> questions;

    public QuizService(List<String> questions){
        this.questions = questions;
    }

    public QuizService(){
        this.questions = List.of("What is the chemical symbol for water?\na) O₂\nb) CO₂\nc) H₂O\nd) CH₄\n",
                "What is the smallest country in the world?\n" +
                "a) Monaco\n" +
                "b) Vatican City\n" +
                "c) San Marino\n" +
                "d) Liechtenstein\n",
                "Who discovered America in 1492?\n" +
                "a) Marco Polo\n" +
                "b) Christopher Columbus\n" +
                "c) Ferdinand Magellan\n" +
                "d) Vasco da Gama\n");
    }

    public void getQuestions(Locale locale){
        ResourceBundle questions = ResourceBundle.getBundle("quiz", locale);
        String greeting = "";
        switch(locale.getCountry()) {
            case "DE" -> {
                greeting = "German version:";
            }
            case "PL" -> {
                greeting = "Polish version:";
            }
            case "US" -> {
                greeting = "English version:";
            }
            default -> {
                greeting = "Original version:";
            }
        }
            System.out.println(greeting);
            for(int i = 1; i <= this.questions.size(); i++){
                System.out.println(questions.getString("question" + i));
            }
            System.out.println("------------------------------------");
    }

}
