import java.util.*;

public class QuizService {

  private static List<Locale> locales = List.of(
    new Locale("en", "US"),
    new Locale("de", "DE"),
    new Locale("es", "ES"),
    new Locale("fr", "FR")
  );

  private static List<ResourceBundle> resourceBundles;

  static {
    resourceBundles = new ArrayList<>();
    for (Locale locale : locales) {
      resourceBundles.add(ResourceBundle.getBundle("localization/config", locale));
    }
  }

  private static Random random = new Random();

  public String[] poseQuestionRng() {

    ResourceBundle resourceBundleRng = resourceBundles.get(random.nextInt(resourceBundles.size()));
    int questionCount = resourceBundleRng.keySet().size() / 2;

    int questionId = random.nextInt(1, questionCount);
    String question =
      resourceBundleRng.getString("q" + questionId);
    String answer =
      resourceBundleRng.getString("a" + questionId);

    return new String[]{question, answer};
  }
}
