import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        QuizService qs = new QuizService();
        Locale english = new Locale("en", "US");
        Locale polish = new Locale("pl", "PL");
        Locale german = new Locale("de", "DE");
        Locale spanish = new Locale("es", "ES");
        qs.getQuestions(polish);
        qs.getQuestions(german);
        qs.getQuestions(english);
        qs.getQuestions(spanish);

    }
}
