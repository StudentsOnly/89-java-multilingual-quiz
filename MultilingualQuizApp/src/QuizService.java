import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuizService {
    private List<String> questions;
    private ResourceBundle quiz;
  //  private List<Locale> localeList = List.of(new Locale("en", "US"), new Locale("de", "DE"), new Locale("sv", "SE"));
/*
    public QuizService(List<String> questions){
        this.questions = questions;
        System.out.println("Is store success? : " + storeQuestions(localeList.get(0)));
    }
*/
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
/*
    private boolean storeQuestions(Locale locale){
        URI uri = null;
       try {
           uri = new URI("/src/quiz.properties");
       }catch(URISyntaxException ex){
           ex.getMessage();
       }
       File file = new File("/home/dci-student/Java/Java_Module/assignments/java-multilingual-quiz-OlenaShcherbina-1/MultilingualQuizApp" + uri);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file, true);
            for(int i = 0; i < questions.size(); i++){
                fileWriter.write("question" + (i+1) +"=" + (i+1) + ". " + questions.get(i));
            }
            return true;
        }catch(IOException e){
            e.getMessage();
            return false;
        }
    }
*/
    private void setQuiz(ResourceBundle quiz){
        this.quiz = quiz;
    }

    private void getQuestions(Locale locale){
        setQuiz(ResourceBundle.getBundle("quiz", locale));
        String greeting = "";
        switch(locale.getCountry()) {
            case "DE" -> {
                greeting = "German version:";
            }
            case "SE" -> {
                greeting = "Swedish version:";
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
                System.out.println(quiz.getString("question" + i));
            }
            System.out.println("------------------------------------");
    }

    public void chooseLanguage(){
        Scanner scanner = new Scanner(System.in);
        Locale locale = null;
        System.out.println("Choose language: English, German or Swedish");
        String language = scanner.nextLine();
        switch(language.toLowerCase()){
            case "english", "en" -> locale = new Locale("en", "US");
            case "german", "ge", "de" -> locale = new Locale("de", "DE");
            case "swedish", "sv", "se", "sw" -> locale = new Locale("sv", "SE");
            default -> {
                locale = new Locale("en", "US");
                System.out.println("Sorry, your choice is not available!");
            }
        }
        getQuestions(locale);

        scanner.close();

    }

}
